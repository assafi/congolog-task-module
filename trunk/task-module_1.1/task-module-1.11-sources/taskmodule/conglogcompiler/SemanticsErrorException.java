/**
 * 
 */
package taskmodule.conglogcompiler;

/**
 * @author Assaf
 *
 */
public class SemanticsErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4759126759467779096L;

	/**
	 * 
	 */
	public SemanticsErrorException() {
	}

	/**
	 * @param message
	 */
	public SemanticsErrorException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SemanticsErrorException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SemanticsErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
