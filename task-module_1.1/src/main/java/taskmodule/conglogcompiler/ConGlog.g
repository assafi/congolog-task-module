grammar ConGlog;

options {
  language=Java;
}

tokens {
	NEGATION;
}

@header {
	package taskmodule.conglogcompiler;
	import java.util.Map; 
	import java.util.HashMap;
	import java.util.UUID;
	import taskmodule.task.Task;
	import taskmodule.preconditions.bool.*;
	import taskmodule.preconditions.integer.*;
	import taskmodule.preconditions.var.*;
	import taskmodule.util.Tree;
	import taskmodule.TaskModule;
	import taskmodule.ITaskModule;
}

@lexer::header {
	package taskmodule.conglogcompiler;
}

@members {
  private Map<String, IPreCondition> preconditionAxioms = new HashMap<String, IPreCondition>();
  private ITaskModule taskModule = TaskModule.getInstance();
  
  private ICompilerErrorReporter syntaxErrorReporter = new CompilerErrorReporter();
  private ICompilerErrorReporter semanticsErrorReporter = new CompilerErrorReporter();
  
  private boolean phase2 = false;
  private Map<String, Tree<String>> labels = new HashMap<String, Tree<String>>();
  private Map<Tree<String>, IPreCondition> dynamicConditions = new HashMap<Tree<String>, IPreCondition>();
  
  public void setSyntaxErrorReporter(ICompilerErrorReporter syntaxErrorReporter) {
  	this.syntaxErrorReporter = syntaxErrorReporter;
  }
  
  public void setSemanticErrorReporter(ICompilerErrorReporter semanticsErrorReporter) {
  	this.semanticsErrorReporter = semanticsErrorReporter;
  }
  
  public void emitErrorMessage(String msg) {
  	syntaxErrorReporter.reportError(msg);
  }
  
  public void checkTypeInt(IPreCondition variable) {
      if (null == variable) return; //Living these cases to be handles by the Syntactic check
      if (!(IIntPreCondition.class.isAssignableFrom(variable.getClass()))) {
        semanticsErrorReporter.reportError("Error in expression - invalid operation on type Integer"); 
      }
  }
  
  public void checkTypeBool(IPreCondition variable) {
      if (null == variable) return; //Living these cases to be handles by the Syntactic check
      if (!(IBoolPreCondition.class.isAssignableFrom(variable.getClass()))) {
        semanticsErrorReporter.reportError("Error in expression - invalid operation on type Boolean");
      }
  }
  
  public void checkSimilarity(IPreCondition var1, IPreCondition var2) {
      if (null == var1 || null == var2) return; //Living these cases to be handles by the Syntactic check
      if (!((IBoolPreCondition.class.isAssignableFrom(var1.getClass()) && 
             IBoolPreCondition.class.isAssignableFrom(var2.getClass())) ||
           (IIntPreCondition.class.isAssignableFrom(var1.getClass()) && 
            IIntPreCondition.class.isAssignableFrom(var2.getClass())))) {
         semanticsErrorReporter.reportError("Error in expression - invalid operation on mixed types");   
      }
  }
}

program	returns [ Task task ]
	:	precondition* { phase2 = true; } statement EOF 
	{
		$task = new Task($statement.subtree,preconditionAxioms, dynamicConditions);
	}
	;

precondition 
	: 'Precondition-axioms' '(' activity ')' '=' expression ';'
	{
		if (!preconditionAxioms.containsKey($activity.text)) {
			preconditionAxioms.put($activity.text,$expression.condition);
		}
		else {
			semanticsErrorReporter.reportError("Precondition for '" + $activity.text + 
					" already defined");
		}
	} 
	;

term returns [ IPreCondition condition ]
	:	IDENT				{ if (taskModule.getIntVariableSet().contains($IDENT.text)) {
	                    $condition = new IntVariable($IDENT.text);
	                }
	                else if (taskModule.getBoolVariableSet().contains($IDENT.text)) {
	                    $condition = new BoolVariable($IDENT.text);
	                }
	                else {
								      semanticsErrorReporter.reportError("Unsupported " + 
										      "variable: " + $IDENT.text); 
							    }
                }
	|	'(' expression ')'  { $condition = $expression.condition; }					
	|	INTEGER 			{ $condition = new IntPreCondition(Integer.parseInt($INTEGER.text)); }
	|	'true'				{ $condition = new BoolPreCondition(true); }
	|	'false'				{ $condition = new BoolPreCondition(false); }												
	;
	
unary returns [ IPreCondition condition ]
	:	{ boolean positive=true; }
	('+' | '-' {positive = !positive ;} )* term 
	{
		$condition = $term.condition;
		if (!positive) {
		  checkTypeInt($condition); //Must be sure this is a Numeric variable
			$condition = new NegationPreCondition($condition);
		}		
	}
	;
	
mult returns [ IPreCondition condition ]
	:	op1=unary 		{ $condition = $op1.condition; } 
	   //Only if we had a non unary operator can we check the first operator. 
     //Otherwise, we can't be sure it should actually be Numeric. 
	( 	'*' op2=unary 	{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                      $condition = new MultiplyPreCondition($condition,$op2.condition); }
	| 	'/' op2=unary	{   checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                      $condition = new DividePreCondition($condition,$op2.condition); }
	| 	'mod' op2=unary	{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                      $condition = new ModPreCondition($condition,$op2.condition); }
	)*  
	;

add returns [ IPreCondition condition ]
	:	op1=mult 		{ $condition = $op1.condition; } 
	(	'+' op2=mult 	{  checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                   	   $condition = new PlusPreCondition($condition,$op2.condition); }
	|   '-' op2=mult	{  checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                       $condition = new MinusPreCondition($condition,$op2.condition); }
	)*
	;
	
relation returns [ IPreCondition condition ]
	:	op1=add 		{ $condition = $op1.condition; }
	
	     //We can ask if two booleans are (not) equal, the same way as we can as
	     //if two Numeric values are (not) equal. but we can't ask if two boolean
	     //values are ">" | "<" | "<=" | ">=" from one another. 
	( 	'=' op2=add		{ checkSimilarity($op1.condition,$op2.condition);
	                    $condition = new EqPreCondition($condition,$op2.condition); }
	| 	'!=' op2=add	{ checkSimilarity($op1.condition,$op2.condition);
	                    $condition = new NeqPreCondition($condition,$op2.condition); }
	| 	'<' op2=add		{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                    $condition = new LtPreCondition($condition,$op2.condition); }
	|	'<=' op2=add	{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                    $condition = new LeqPreCondition($condition,$op2.condition); }
	| 	'>' op2=add		{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                    $condition = new GtPreCondition($condition,$op2.condition); }
	| 	'>=' op2=add	{ checkTypeInt($op2.condition); checkTypeInt($op1.condition);
	                    $condition = new GeqPreCondition($condition,$op2.condition); }
	)*
	;
/*
	TODO: Add support for "member of" operator 
	TODO: Add support for non-integer numbers
*/
not returns [ IPreCondition condition ]
  : { boolean positive=true; }  
  ('not' {positive = !positive ;} )* relation
  {
    $condition = $relation.condition;
    if (!positive) {
      checkTypeBool($relation.condition);
      $condition = new NotPreCondition($condition);
    }
  }
  ;
  
expression returns [ IPreCondition condition ]
	:	op1=not 		{ $condition = $op1.condition; } 
	(	'&&' op2=not 	{ $condition = new AndPreCondition($condition,$op2.condition); }
	| 	'||' op2=not	{ $condition = new OrPreCondition($condition,$op2.condition); }
	)*            
	;

statement returns [ Tree<String> subtree ]
	:	labelDefinition		{ $subtree = $labelDefinition.subtree; }
	|	act					{ $subtree = $act.subtree; }
	|	orScope				{ $subtree = $orScope.subtree; }
	|	dynCondStatement		{ $subtree = $dynCondStatement.subtree; }
//	|	ifStatement
//	|	whileStatement
//	|	empty 
	;
	
block returns [ String text ]
	:	'{' 
	(
	(	statement )+ 	{ $text = null; }	// Label cannot be empty !
	|	activity		{ $text = $activity.text; }
	) 	'}'
	;
	
//ifStatement
//	:	'if' expression 'then' statement
//		'else' statement 
//	;
//
//whileStatement
//	:	'while' expression 'do' statement
//	;

orScope returns [ Tree<String> subtree ]
	:	'[' {$subtree = new Tree<String>("or hidden:" + UUID.randomUUID());}
	(
		( st1=statement { $subtree.addSubTree($st1.subtree); } ) 
		| 
		( ac1=activity  { 
			//Old Label
     		if (labels.containsKey($ac1.text)) {
     			$subtree.addSubTree(labels.get($ac1.text).clone());
     			System.out.println("Label added " + $ac1.text);
     		} else {
     		//Activity
     			$subtree.addSubTree(new Tree<String>($ac1.text));
     		}
     	})
	)
	(
	(
		'|' 
		(
			( st2=statement { $subtree.addSubTree($st2.subtree); })
			|
			( ac2=activity  { 
			    //Old labels
	     	if (labels.containsKey($ac2.text)) {
	     		//If this is an old label, will try to copy the subtree.
	     		$subtree.addSubTree(labels.get($ac2.text).clone());
	     	} else {
	     		//Activity
	     		$subtree.addSubTree(new Tree<String>($ac2.text));
	     	}
	     	})
		)
	)*
	)	']'
	;

dynCondStatement returns [ Tree<String> subtree ]
  :
  boolVar=IDENT '?' activity 
    {
     if (taskModule.getBoolVariableSet().contains($boolVar.text)) {
     
     	//Old labels
     	if (labels.containsKey($activity.text)) {
     		//If this is an old label, will try to copy the subtree.
     		$subtree = labels.get($activity.text).clone();
     	} else {
     		//Activity
     		$subtree = new Tree<String>($activity.text);
     	}
     
     	IPreCondition dynamicCondition = new BoolVariable($boolVar.text);
     	dynamicConditions.put($subtree, dynamicCondition);
     } else {
     	semanticsErrorReporter.reportError("Unsupported boolean variable: "
     			+ $boolVar.text);
     }
    }
  ;
	
labelDefinition	returns [ Tree<String> subtree ]
	:	'Label' labelID=IDENT ':' '{'	
		{ 
			$subtree = new Tree<String>($labelID.text); 
			if (!labels.containsKey($labelID.text)) {
	        	labels.put($labelID.text, $subtree);
	      	}
	      	else {
	        	semanticsErrorReporter.reportError("Doubly defined label: " + $labelID.text); 
	      	} 
		}
		( statement 
			{
				if (!$subtree.addSubTree($statement.subtree)) {
					semanticsErrorReporter.reportError("Internal error!"); 
				} 				
			}
		)* '}'
	;
	
act returns [ Tree<String> subtree ]	
	:	activity ';' 
	    {
	      //Old labels
	      if (labels.containsKey($activity.text)) {
	        //If this is an old label, will try to copy the subtree.
	        $subtree = labels.get($activity.text).clone();
          }	else {
	      //Activity
	        $subtree = new Tree<String>($activity.text);
	      }
	    }
	;

//activity stands for any supported activity or known Label
activity returns [ String text ]
	:	IDENT 
	{
		if (!taskModule.getSupportedActivities().contains($IDENT.text) &&
		    !labels.containsKey($IDENT.text)) {
			semanticsErrorReporter.reportError("Unsupported activity " + $IDENT.text);
		}
		
		$text = new String($IDENT.text);
		//In case where the activity is supported but no precondition-axiom
		//was defined, the default will be a "true" precondition.
		if (phase2 && !preconditionAxioms.containsKey($IDENT.text) &&
		    !labels.containsKey($IDENT.text)) {
			preconditionAxioms.put($IDENT.text, new BoolPreCondition(true));
		}		
	}
	;
	
constant 
	: INTEGER 
	;

empty 
	:	EMPTY ';'
	;
	
fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT 	: ('0'..'9') ;
fragment NEWLINE : ('\n' | '\r') ;
fragment WHITESPACE : (' ' | '\t') ;
EMPTY : 'empty';
INTEGER : DIGIT+;
IDENT : LETTER (LETTER | DIGIT | '_')* ;
IGNORE : ( WHITESPACE | NEWLINE )+ { $channel = HIDDEN ; };
COMMENT : '//' .* ('\n' | '\r') {$channel = HIDDEN;};
MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;};
