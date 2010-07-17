/**
 * 
 */
package taskmodule.preconditions;

/**
 * @author Assaf
 *
 */
public class InvalidPreConditionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 857405228045937307L;

	/**
	 * 
	 */
	public InvalidPreConditionException() {
	}

	/**
	 * @param message
	 */
	public InvalidPreConditionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidPreConditionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidPreConditionException(String message, Throwable cause) {
		super(message, cause);
	}

}
