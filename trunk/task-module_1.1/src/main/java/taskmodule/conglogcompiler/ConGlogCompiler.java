/**
 * 
 */
package taskmodule.conglogcompiler;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import taskmodule.task.Task;

/**
 * @author Assaf
 *
 */
public class ConGlogCompiler {
	
	private ConGlogLexer lexer;
	private ConGlogParser parser;
	private ICompilerErrorReporter syntaxErrorReporter 
		= new CompilerErrorReporter();
	private ICompilerErrorReporter semanticsErrorReporter
		= new CompilerErrorReporter();
	
	public ConGlogCompiler() {
		
		this.lexer = new ConGlogLexer();
		TokenStream tokenStream = new CommonTokenStream(lexer);
		this.parser = new ConGlogParser(tokenStream);
		this.parser.setSyntaxErrorReporter(syntaxErrorReporter);
		this.parser.setSemanticErrorReporter(semanticsErrorReporter);
	}
	
	public Task parse(String input) throws SyntaxErrorException, SemanticsErrorException {
		
		clean();
		CharStream stream =
			new ANTLRStringStream(input);
		lexer.setCharStream(stream);
		Task task;
		try {
			task = parser.program();
		} catch (RecognitionException e) {
			throw new SyntaxErrorException(e);
		}
		
		checkSyntaxErrors();
		return task;
	}

	private void clean() {
		syntaxErrorReporter.clean();
		semanticsErrorReporter.clean();
	}

	private void checkSyntaxErrors() throws SyntaxErrorException, SemanticsErrorException {
		/*
		 * Syntax will take priority over Semantics
		 */
		if (syntaxErrorReporter.hadErrors()) {
			throw new SyntaxErrorException(syntaxErrorReporter.errorReport());
		}
		
		if (semanticsErrorReporter.hadErrors()) {
			throw new SemanticsErrorException(semanticsErrorReporter.errorReport());
		}
	}
}
