// $ANTLR 3.2 Sep 23, 2009 14:05:07 C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g 2010-04-29 16:55:00

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConGlogParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATION", "IDENT", "INTEGER", "EMPTY", "LETTER", "DIGIT", "NEWLINE", "WHITESPACE", "IGNORE", "COMMENT", "MULTILINE_COMMENT", "'Precondition-axioms'", "'('", "')'", "'='", "';'", "'true'", "'false'", "'+'", "'-'", "'*'", "'/'", "'mod'", "'!='", "'<'", "'<='", "'>'", "'>='", "'not'", "'&&'", "'||'", "'{'", "'}'", "'['", "'|'", "']'", "'?'", "'Label'", "':'"
    };
    public static final int INTEGER=6;
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int LETTER=8;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=11;
    public static final int IGNORE=12;
    public static final int EOF=-1;
    public static final int EMPTY=7;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int MULTILINE_COMMENT=14;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int NEWLINE=10;
    public static final int NEGATION=4;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int IDENT=5;
    public static final int DIGIT=9;
    public static final int COMMENT=13;

    // delegates
    // delegators


        public ConGlogParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConGlogParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ConGlogParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g"; }


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



    // $ANTLR start "program"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:77:1: program returns [ Task task ] : ( precondition )* statement EOF ;
    public final Task program() throws RecognitionException {
        Task task = null;

        Tree<String> statement1 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:78:2: ( ( precondition )* statement EOF )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:78:4: ( precondition )* statement EOF
            {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:78:4: ( precondition )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:78:4: precondition
            	    {
            	    pushFollow(FOLLOW_precondition_in_program57);
            	    precondition();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             phase2 = true; 
            pushFollow(FOLLOW_statement_in_program62);
            statement1=statement();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_program64); 

            		task = new Task(statement1,preconditionAxioms, dynamicConditions);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return task;
    }
    // $ANTLR end "program"


    // $ANTLR start "precondition"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:84:1: precondition : 'Precondition-axioms' '(' activity ')' '=' expression ';' ;
    public final void precondition() throws RecognitionException {
        String activity2 = null;

        IPreCondition expression3 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:85:2: ( 'Precondition-axioms' '(' activity ')' '=' expression ';' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:85:4: 'Precondition-axioms' '(' activity ')' '=' expression ';'
            {
            match(input,15,FOLLOW_15_in_precondition80); 
            match(input,16,FOLLOW_16_in_precondition82); 
            pushFollow(FOLLOW_activity_in_precondition84);
            activity2=activity();

            state._fsp--;

            match(input,17,FOLLOW_17_in_precondition86); 
            match(input,18,FOLLOW_18_in_precondition88); 
            pushFollow(FOLLOW_expression_in_precondition90);
            expression3=expression();

            state._fsp--;

            match(input,19,FOLLOW_19_in_precondition92); 

            		if (!preconditionAxioms.containsKey(activity2)) {
            			preconditionAxioms.put(activity2,expression3);
            		}
            		else {
            			semanticsErrorReporter.reportError("Precondition for '" + activity2 + 
            					" already defined");
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "precondition"


    // $ANTLR start "term"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:97:1: term returns [ IPreCondition condition ] : ( IDENT | '(' expression ')' | INTEGER | 'true' | 'false' );
    public final IPreCondition term() throws RecognitionException {
        IPreCondition condition = null;

        Token IDENT4=null;
        Token INTEGER6=null;
        IPreCondition expression5 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:98:2: ( IDENT | '(' expression ')' | INTEGER | 'true' | 'false' )
            int alt2=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case INTEGER:
                {
                alt2=3;
                }
                break;
            case 20:
                {
                alt2=4;
                }
                break;
            case 21:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:98:4: IDENT
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_term111); 
                     if (taskModule.getIntVariableSet().contains((IDENT4!=null?IDENT4.getText():null))) {
                    	                    condition = new IntVariable((IDENT4!=null?IDENT4.getText():null));
                    	                }
                    	                else if (taskModule.getBoolVariableSet().contains((IDENT4!=null?IDENT4.getText():null))) {
                    	                    condition = new BoolVariable((IDENT4!=null?IDENT4.getText():null));
                    	                }
                    	                else {
                    								      semanticsErrorReporter.reportError("Unsupported " + 
                    										      "variable: " + (IDENT4!=null?IDENT4.getText():null)); 
                    							    }
                                    

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:109:4: '(' expression ')'
                    {
                    match(input,16,FOLLOW_16_in_term121); 
                    pushFollow(FOLLOW_expression_in_term123);
                    expression5=expression();

                    state._fsp--;

                    match(input,17,FOLLOW_17_in_term125); 
                     condition = expression5; 

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:110:4: INTEGER
                    {
                    INTEGER6=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term138); 
                     condition = new IntPreCondition(Integer.parseInt((INTEGER6!=null?INTEGER6.getText():null))); 

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:111:4: 'true'
                    {
                    match(input,20,FOLLOW_20_in_term148); 
                     condition = new BoolPreCondition(true); 

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:112:4: 'false'
                    {
                    match(input,21,FOLLOW_21_in_term158); 
                     condition = new BoolPreCondition(false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "term"


    // $ANTLR start "unary"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:115:1: unary returns [ IPreCondition condition ] : ( '+' | '-' )* term ;
    public final IPreCondition unary() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition term7 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:116:2: ( ( '+' | '-' )* term )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:116:4: ( '+' | '-' )* term
            {
             boolean positive=true; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:117:2: ( '+' | '-' )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==22) ) {
                    alt3=1;
                }
                else if ( (LA3_0==23) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:117:3: '+'
            	    {
            	    match(input,22,FOLLOW_22_in_unary195); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:117:9: '-'
            	    {
            	    match(input,23,FOLLOW_23_in_unary199); 
            	    positive = !positive ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            pushFollow(FOLLOW_term_in_unary206);
            term7=term();

            state._fsp--;


            		condition = term7;
            		if (!positive) {
            		  checkTypeInt(condition); //Must be sure this is a Numeric variable
            			condition = new NegationPreCondition(condition);
            		}		
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "unary"


    // $ANTLR start "mult"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:127:1: mult returns [ IPreCondition condition ] : op1= unary ( '*' op2= unary | '/' op2= unary | 'mod' op2= unary )* ;
    public final IPreCondition mult() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition op1 = null;

        IPreCondition op2 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:128:2: (op1= unary ( '*' op2= unary | '/' op2= unary | 'mod' op2= unary )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:128:4: op1= unary ( '*' op2= unary | '/' op2= unary | 'mod' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult228);
            op1=unary();

            state._fsp--;

             condition = op1; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:131:2: ( '*' op2= unary | '/' op2= unary | 'mod' op2= unary )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 24:
                    {
                    alt4=1;
                    }
                    break;
                case 25:
                    {
                    alt4=2;
                    }
                    break;
                case 26:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:131:5: '*' op2= unary
            	    {
            	    match(input,24,FOLLOW_24_in_mult250); 
            	    pushFollow(FOLLOW_unary_in_mult254);
            	    op2=unary();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                      condition = new MultiplyPreCondition(condition,op2); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:133:5: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult263); 
            	    pushFollow(FOLLOW_unary_in_mult267);
            	    op2=unary();

            	    state._fsp--;

            	       checkTypeInt(op2); checkTypeInt(op1);
            	    	                      condition = new DividePreCondition(condition,op2); 

            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:135:5: 'mod' op2= unary
            	    {
            	    match(input,26,FOLLOW_26_in_mult275); 
            	    pushFollow(FOLLOW_unary_in_mult279);
            	    op2=unary();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                      condition = new ModPreCondition(condition,op2); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "mult"


    // $ANTLR start "add"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:140:1: add returns [ IPreCondition condition ] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final IPreCondition add() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition op1 = null;

        IPreCondition op2 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:141:2: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:141:4: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_add304);
            op1=mult();

            state._fsp--;

             condition = op1; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:142:2: ( '+' op2= mult | '-' op2= mult )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }
                else if ( (LA5_0==23) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:142:4: '+' op2= mult
            	    {
            	    match(input,22,FOLLOW_22_in_add314); 
            	    pushFollow(FOLLOW_mult_in_add318);
            	    op2=mult();

            	    state._fsp--;

            	      checkTypeInt(op2); checkTypeInt(op1);
            	    	                   	   condition = new PlusPreCondition(condition,op2); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:144:6: '-' op2= mult
            	    {
            	    match(input,23,FOLLOW_23_in_add328); 
            	    pushFollow(FOLLOW_mult_in_add332);
            	    op2=mult();

            	    state._fsp--;

            	      checkTypeInt(op2); checkTypeInt(op1);
            	    	                       condition = new MinusPreCondition(condition,op2); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "add"


    // $ANTLR start "relation"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:149:1: relation returns [ IPreCondition condition ] : op1= add ( '=' op2= add | '!=' op2= add | '<' op2= add | '<=' op2= add | '>' op2= add | '>=' op2= add )* ;
    public final IPreCondition relation() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition op1 = null;

        IPreCondition op2 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:150:2: (op1= add ( '=' op2= add | '!=' op2= add | '<' op2= add | '<=' op2= add | '>' op2= add | '>=' op2= add )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:150:4: op1= add ( '=' op2= add | '!=' op2= add | '<' op2= add | '<=' op2= add | '>' op2= add | '>=' op2= add )*
            {
            pushFollow(FOLLOW_add_in_relation356);
            op1=add();

            state._fsp--;

             condition = op1; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:155:2: ( '=' op2= add | '!=' op2= add | '<' op2= add | '<=' op2= add | '>' op2= add | '>=' op2= add )*
            loop6:
            do {
                int alt6=7;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt6=1;
                    }
                    break;
                case 27:
                    {
                    alt6=2;
                    }
                    break;
                case 28:
                    {
                    alt6=3;
                    }
                    break;
                case 29:
                    {
                    alt6=4;
                    }
                    break;
                case 30:
                    {
                    alt6=5;
                    }
                    break;
                case 31:
                    {
                    alt6=6;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:155:5: '=' op2= add
            	    {
            	    match(input,18,FOLLOW_18_in_relation389); 
            	    pushFollow(FOLLOW_add_in_relation393);
            	    op2=add();

            	    state._fsp--;

            	     checkSimilarity(op1,op2);
            	    	                    condition = new EqPreCondition(condition,op2); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:157:5: '!=' op2= add
            	    {
            	    match(input,27,FOLLOW_27_in_relation402); 
            	    pushFollow(FOLLOW_add_in_relation406);
            	    op2=add();

            	    state._fsp--;

            	     checkSimilarity(op1,op2);
            	    	                    condition = new NeqPreCondition(condition,op2); 

            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:159:5: '<' op2= add
            	    {
            	    match(input,28,FOLLOW_28_in_relation414); 
            	    pushFollow(FOLLOW_add_in_relation418);
            	    op2=add();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                    condition = new LtPreCondition(condition,op2); 

            	    }
            	    break;
            	case 4 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:161:4: '<=' op2= add
            	    {
            	    match(input,29,FOLLOW_29_in_relation426); 
            	    pushFollow(FOLLOW_add_in_relation430);
            	    op2=add();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                    condition = new LeqPreCondition(condition,op2); 

            	    }
            	    break;
            	case 5 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:163:5: '>' op2= add
            	    {
            	    match(input,30,FOLLOW_30_in_relation438); 
            	    pushFollow(FOLLOW_add_in_relation442);
            	    op2=add();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                    condition = new GtPreCondition(condition,op2); 

            	    }
            	    break;
            	case 6 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:165:5: '>=' op2= add
            	    {
            	    match(input,31,FOLLOW_31_in_relation451); 
            	    pushFollow(FOLLOW_add_in_relation455);
            	    op2=add();

            	    state._fsp--;

            	     checkTypeInt(op2); checkTypeInt(op1);
            	    	                    condition = new GeqPreCondition(condition,op2); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "relation"


    // $ANTLR start "not"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:173:1: not returns [ IPreCondition condition ] : ( 'not' )* relation ;
    public final IPreCondition not() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition relation8 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:174:3: ( ( 'not' )* relation )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:174:5: ( 'not' )* relation
            {
             boolean positive=true; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:175:3: ( 'not' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:175:4: 'not'
            	    {
            	    match(input,32,FOLLOW_32_in_not485); 
            	    positive = !positive ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            pushFollow(FOLLOW_relation_in_not492);
            relation8=relation();

            state._fsp--;


                condition = relation8;
                if (!positive) {
                  checkTypeBool(relation8);
                  condition = new NotPreCondition(condition);
                }
              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "not"


    // $ANTLR start "expression"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:185:1: expression returns [ IPreCondition condition ] : op1= not ( '&&' op2= not | '||' op2= not )* ;
    public final IPreCondition expression() throws RecognitionException {
        IPreCondition condition = null;

        IPreCondition op1 = null;

        IPreCondition op2 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:186:2: (op1= not ( '&&' op2= not | '||' op2= not )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:186:4: op1= not ( '&&' op2= not | '||' op2= not )*
            {
            pushFollow(FOLLOW_not_in_expression516);
            op1=not();

            state._fsp--;

             condition = op1; 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:187:2: ( '&&' op2= not | '||' op2= not )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==33) ) {
                    alt8=1;
                }
                else if ( (LA8_0==34) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:187:4: '&&' op2= not
            	    {
            	    match(input,33,FOLLOW_33_in_expression526); 
            	    pushFollow(FOLLOW_not_in_expression530);
            	    op2=not();

            	    state._fsp--;

            	     condition = new AndPreCondition(condition,op2); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:188:5: '||' op2= not
            	    {
            	    match(input,34,FOLLOW_34_in_expression539); 
            	    pushFollow(FOLLOW_not_in_expression543);
            	    op2=not();

            	    state._fsp--;

            	     condition = new OrPreCondition(condition,op2); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return condition;
    }
    // $ANTLR end "expression"


    // $ANTLR start "statement"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:192:1: statement returns [ Tree<String> subtree ] : ( labelDefinition | act | orScope | dynCondStatement );
    public final Tree<String> statement() throws RecognitionException {
        Tree<String> subtree = null;

        Tree<String> labelDefinition9 = null;

        Tree<String> act10 = null;

        Tree<String> orScope11 = null;

        Tree<String> dynCondStatement12 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:193:2: ( labelDefinition | act | orScope | dynCondStatement )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt9=1;
                }
                break;
            case IDENT:
                {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==40) ) {
                    alt9=4;
                }
                else if ( (LA9_2==19) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case 37:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:193:4: labelDefinition
                    {
                    pushFollow(FOLLOW_labelDefinition_in_statement576);
                    labelDefinition9=labelDefinition();

                    state._fsp--;

                     subtree = labelDefinition9; 

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:194:4: act
                    {
                    pushFollow(FOLLOW_act_in_statement584);
                    act10=act();

                    state._fsp--;

                     subtree = act10; 

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:195:4: orScope
                    {
                    pushFollow(FOLLOW_orScope_in_statement595);
                    orScope11=orScope();

                    state._fsp--;

                     subtree = orScope11; 

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:196:4: dynCondStatement
                    {
                    pushFollow(FOLLOW_dynCondStatement_in_statement605);
                    dynCondStatement12=dynCondStatement();

                    state._fsp--;

                     subtree = dynCondStatement12; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subtree;
    }
    // $ANTLR end "statement"


    // $ANTLR start "block"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:202:1: block returns [ String text ] : '{' ( ( statement )+ | activity ) '}' ;
    public final String block() throws RecognitionException {
        String text = null;

        String activity13 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:203:2: ( '{' ( ( statement )+ | activity ) '}' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:203:4: '{' ( ( statement )+ | activity ) '}'
            {
            match(input,35,FOLLOW_35_in_block627); 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:204:2: ( ( statement )+ | activity )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37||LA11_0==41) ) {
                alt11=1;
            }
            else if ( (LA11_0==IDENT) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==19||LA11_2==40) ) {
                    alt11=1;
                }
                else if ( (LA11_2==36) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:205:2: ( statement )+
                    {
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:205:2: ( statement )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==IDENT||LA10_0==37||LA10_0==41) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:205:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_block636);
                    	    statement();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                     text = null; 

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:206:4: activity
                    {
                    pushFollow(FOLLOW_activity_in_block648);
                    activity13=activity();

                    state._fsp--;

                     text = activity13; 

                    }
                    break;

            }

            match(input,36,FOLLOW_36_in_block657); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return text;
    }
    // $ANTLR end "block"


    // $ANTLR start "orScope"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:219:1: orScope returns [ Tree<String> subtree ] : '[' ( (st1= statement ) | (ac1= activity ) ) ( ( '|' ( (st2= statement ) | (ac2= activity ) ) )* ) ']' ;
    public final Tree<String> orScope() throws RecognitionException {
        Tree<String> subtree = null;

        Tree<String> st1 = null;

        String ac1 = null;

        Tree<String> st2 = null;

        String ac2 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:220:2: ( '[' ( (st1= statement ) | (ac1= activity ) ) ( ( '|' ( (st2= statement ) | (ac2= activity ) ) )* ) ']' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:220:4: '[' ( (st1= statement ) | (ac1= activity ) ) ( ( '|' ( (st2= statement ) | (ac2= activity ) ) )* ) ']'
            {
            match(input,37,FOLLOW_37_in_orScope682); 
            subtree = new Tree<String>("or hidden:" + UUID.randomUUID());
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:221:2: ( (st1= statement ) | (ac1= activity ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==37||LA12_0==41) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENT) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==19||LA12_2==40) ) {
                    alt12=1;
                }
                else if ( ((LA12_2>=38 && LA12_2<=39)) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:222:3: (st1= statement )
                    {
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:222:3: (st1= statement )
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:222:5: st1= statement
                    {
                    pushFollow(FOLLOW_statement_in_orScope695);
                    st1=statement();

                    state._fsp--;

                     subtree.addSubTree(st1); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:224:3: (ac1= activity )
                    {
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:224:3: (ac1= activity )
                    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:224:5: ac1= activity
                    {
                    pushFollow(FOLLOW_activity_in_orScope713);
                    ac1=activity();

                    state._fsp--;

                     
                    			//Old Label
                         		if (labels.containsKey(ac1)) {
                         			subtree.addSubTree(labels.get(ac1).clone());
                         			System.out.println("Label added " + ac1);
                         		} else {
                         		//Activity
                         			subtree.addSubTree(new Tree<String>(ac1));
                         		}
                         	

                    }


                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:235:2: ( ( '|' ( (st2= statement ) | (ac2= activity ) ) )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:236:2: ( '|' ( (st2= statement ) | (ac2= activity ) ) )*
            {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:236:2: ( '|' ( (st2= statement ) | (ac2= activity ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==38) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:237:3: '|' ( (st2= statement ) | (ac2= activity ) )
            	    {
            	    match(input,38,FOLLOW_38_in_orScope730); 
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:238:3: ( (st2= statement ) | (ac2= activity ) )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==37||LA13_0==41) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==IDENT) ) {
            	        int LA13_2 = input.LA(2);

            	        if ( (LA13_2==19||LA13_2==40) ) {
            	            alt13=1;
            	        }
            	        else if ( ((LA13_2>=38 && LA13_2<=39)) ) {
            	            alt13=2;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 13, 2, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:239:4: (st2= statement )
            	            {
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:239:4: (st2= statement )
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:239:6: st2= statement
            	            {
            	            pushFollow(FOLLOW_statement_in_orScope744);
            	            st2=statement();

            	            state._fsp--;

            	             subtree.addSubTree(st2); 

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:241:4: (ac2= activity )
            	            {
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:241:4: (ac2= activity )
            	            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:241:6: ac2= activity
            	            {
            	            pushFollow(FOLLOW_activity_in_orScope761);
            	            ac2=activity();

            	            state._fsp--;

            	             
            	            			    //Old labels
            	            	     	if (labels.containsKey(ac2)) {
            	            	     		//If this is an old label, will try to copy the subtree.
            	            	     		subtree.addSubTree(labels.get(ac2).clone());
            	            	     	} else {
            	            	     		//Activity
            	            	     		subtree.addSubTree(new Tree<String>(ac2));
            	            	     	}
            	            	     	

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            match(input,39,FOLLOW_39_in_orScope778); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subtree;
    }
    // $ANTLR end "orScope"


    // $ANTLR start "dynCondStatement"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:256:1: dynCondStatement returns [ Tree<String> subtree ] : boolVar= IDENT '?' activity ;
    public final Tree<String> dynCondStatement() throws RecognitionException {
        Tree<String> subtree = null;

        Token boolVar=null;
        String activity14 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:257:3: (boolVar= IDENT '?' activity )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:258:3: boolVar= IDENT '?' activity
            {
            boolVar=(Token)match(input,IDENT,FOLLOW_IDENT_in_dynCondStatement798); 
            match(input,40,FOLLOW_40_in_dynCondStatement800); 
            pushFollow(FOLLOW_activity_in_dynCondStatement802);
            activity14=activity();

            state._fsp--;


                 if (taskModule.getBoolVariableSet().contains((boolVar!=null?boolVar.getText():null))) {
                 
                 	//Old labels
                 	if (labels.containsKey(activity14)) {
                 		//If this is an old label, will try to copy the subtree.
                 		subtree = labels.get(activity14).clone();
                 	} else {
                 		//Activity
                 		subtree = new Tree<String>(activity14);
                 	}
                 
                 	IPreCondition dynamicCondition = new BoolVariable((boolVar!=null?boolVar.getText():null));
                 	dynamicConditions.put(subtree, dynamicCondition);
                 } else {
                 	semanticsErrorReporter.reportError("Unsupported boolean variable: "
                 			+ (boolVar!=null?boolVar.getText():null));
                 }
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subtree;
    }
    // $ANTLR end "dynCondStatement"


    // $ANTLR start "labelDefinition"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:280:1: labelDefinition returns [ Tree<String> subtree ] : 'Label' labelID= IDENT ':' '{' ( statement )* '}' ;
    public final Tree<String> labelDefinition() throws RecognitionException {
        Tree<String> subtree = null;

        Token labelID=null;
        Tree<String> statement15 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:281:2: ( 'Label' labelID= IDENT ':' '{' ( statement )* '}' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:281:4: 'Label' labelID= IDENT ':' '{' ( statement )* '}'
            {
            match(input,41,FOLLOW_41_in_labelDefinition826); 
            labelID=(Token)match(input,IDENT,FOLLOW_IDENT_in_labelDefinition830); 
            match(input,42,FOLLOW_42_in_labelDefinition832); 
            match(input,35,FOLLOW_35_in_labelDefinition834); 
             
            			subtree = new Tree<String>((labelID!=null?labelID.getText():null)); 
            			if (!labels.containsKey((labelID!=null?labelID.getText():null))) {
            	        	labels.put((labelID!=null?labelID.getText():null), subtree);
            	      	}
            	      	else {
            	        	semanticsErrorReporter.reportError("Doubly defined label: " + (labelID!=null?labelID.getText():null)); 
            	      	} 
            		
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:291:3: ( statement )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDENT||LA15_0==37||LA15_0==41) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:291:5: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_labelDefinition845);
            	    statement15=statement();

            	    state._fsp--;


            	    				if (!subtree.addSubTree(statement15)) {
            	    					semanticsErrorReporter.reportError("Internal error!"); 
            	    				} 				
            	    			

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,36,FOLLOW_36_in_labelDefinition858); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subtree;
    }
    // $ANTLR end "labelDefinition"


    // $ANTLR start "act"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:300:1: act returns [ Tree<String> subtree ] : activity ';' ;
    public final Tree<String> act() throws RecognitionException {
        Tree<String> subtree = null;

        String activity16 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:301:2: ( activity ';' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:301:4: activity ';'
            {
            pushFollow(FOLLOW_activity_in_act875);
            activity16=activity();

            state._fsp--;

            match(input,19,FOLLOW_19_in_act877); 

            	      //Old labels
            	      if (labels.containsKey(activity16)) {
            	        //If this is an old label, will try to copy the subtree.
            	        subtree = labels.get(activity16).clone();
                      }	else {
            	      //Activity
            	        subtree = new Tree<String>(activity16);
            	      }
            	    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return subtree;
    }
    // $ANTLR end "act"


    // $ANTLR start "activity"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:315:1: activity returns [ String text ] : IDENT ;
    public final String activity() throws RecognitionException {
        String text = null;

        Token IDENT17=null;

        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:316:2: ( IDENT )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:316:4: IDENT
            {
            IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_activity901); 

            		if (!taskModule.getSupportedActivities().contains((IDENT17!=null?IDENT17.getText():null)) &&
            		    !labels.containsKey((IDENT17!=null?IDENT17.getText():null))) {
            			semanticsErrorReporter.reportError("Unsupported activity " + (IDENT17!=null?IDENT17.getText():null));
            		}
            		
            		text = new String((IDENT17!=null?IDENT17.getText():null));
            		//In case where the activity is supported but no precondition-axiom
            		//was defined, the default will be a "true" precondition.
            		if (phase2 && !preconditionAxioms.containsKey((IDENT17!=null?IDENT17.getText():null)) &&
            		    !labels.containsKey((IDENT17!=null?IDENT17.getText():null))) {
            			preconditionAxioms.put((IDENT17!=null?IDENT17.getText():null), new BoolPreCondition(true));
            		}		
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return text;
    }
    // $ANTLR end "activity"


    // $ANTLR start "constant"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:333:1: constant : INTEGER ;
    public final void constant() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:334:2: ( INTEGER )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:334:4: INTEGER
            {
            match(input,INTEGER,FOLLOW_INTEGER_in_constant918); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "constant"


    // $ANTLR start "empty"
    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:337:1: empty : EMPTY ';' ;
    public final void empty() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:338:2: ( EMPTY ';' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:338:4: EMPTY ';'
            {
            match(input,EMPTY,FOLLOW_EMPTY_in_empty931); 
            match(input,19,FOLLOW_19_in_empty933); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "empty"

    // Delegated rules


 

    public static final BitSet FOLLOW_precondition_in_program57 = new BitSet(new long[]{0x0000022000008020L});
    public static final BitSet FOLLOW_statement_in_program62 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_program64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_precondition80 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_precondition82 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_activity_in_precondition84 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_precondition86 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_precondition88 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_expression_in_precondition90 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_precondition92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_term121 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_expression_in_term123 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_term138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_term148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_term158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_unary195 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_23_in_unary199 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_term_in_unary206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult228 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_24_in_mult250 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_unary_in_mult254 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_25_in_mult263 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_unary_in_mult267 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_26_in_mult275 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_unary_in_mult279 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_mult_in_add304 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_add314 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_mult_in_add318 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_23_in_add328 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_mult_in_add332 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_add_in_relation356 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_18_in_relation389 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation393 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_27_in_relation402 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation406 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_28_in_relation414 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation418 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_29_in_relation426 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation430 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_30_in_relation438 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation442 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_31_in_relation451 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_add_in_relation455 = new BitSet(new long[]{0x00000000F8040002L});
    public static final BitSet FOLLOW_32_in_not485 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_relation_in_not492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_in_expression516 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_expression526 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_not_in_expression530 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_34_in_expression539 = new BitSet(new long[]{0x0000000100F10060L});
    public static final BitSet FOLLOW_not_in_expression543 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_labelDefinition_in_statement576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_act_in_statement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orScope_in_statement595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dynCondStatement_in_statement605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_block627 = new BitSet(new long[]{0x0000022000000020L});
    public static final BitSet FOLLOW_statement_in_block636 = new BitSet(new long[]{0x0000023000000020L});
    public static final BitSet FOLLOW_activity_in_block648 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_block657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_orScope682 = new BitSet(new long[]{0x0000022000000020L});
    public static final BitSet FOLLOW_statement_in_orScope695 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_activity_in_orScope713 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_38_in_orScope730 = new BitSet(new long[]{0x0000022000000020L});
    public static final BitSet FOLLOW_statement_in_orScope744 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_activity_in_orScope761 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_39_in_orScope778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_dynCondStatement798 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_dynCondStatement800 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_activity_in_dynCondStatement802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_labelDefinition826 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_labelDefinition830 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_labelDefinition832 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_labelDefinition834 = new BitSet(new long[]{0x0000023000000020L});
    public static final BitSet FOLLOW_statement_in_labelDefinition845 = new BitSet(new long[]{0x0000023000000020L});
    public static final BitSet FOLLOW_36_in_labelDefinition858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_activity_in_act875 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_act877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_activity901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_constant918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EMPTY_in_empty931 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_empty933 = new BitSet(new long[]{0x0000000000000002L});

}