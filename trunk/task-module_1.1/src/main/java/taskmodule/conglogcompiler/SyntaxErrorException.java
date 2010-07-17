/**
 * 
 */
package taskmodule.conglogcompiler;

/**
 * @author Assaf
 *
 */
public class SyntaxErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6005951477313788074L;

	/**
	 * 
	 */
	public SyntaxErrorException() {
	}

	/**
	 * @param message
	 */
	public SyntaxErrorException(String message) {
		super("Syntax error: " + message);
	}

	/**
	 * @param cause
	 */
	public SyntaxErrorException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SyntaxErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}
