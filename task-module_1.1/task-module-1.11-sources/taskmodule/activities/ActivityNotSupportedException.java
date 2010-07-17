/**
 * 
 */
package taskmodule.activities;

/**
 * @author Assaf
 *
 */
public class ActivityNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2039069664804966627L;

	/**
	 * 
	 */
	public ActivityNotSupportedException() {
	}

	/**
	 * @param message
	 */
	public ActivityNotSupportedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ActivityNotSupportedException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ActivityNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

}
