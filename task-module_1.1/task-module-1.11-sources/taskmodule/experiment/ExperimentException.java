/**
 * 
 */
package taskmodule.experiment;

/**
 * @author eli
 *
 */
public class ExperimentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2088801085193978509L;

	/**
	 * 
	 */
	public ExperimentException() {
	}

	/**
	 * @param message
	 */
	public ExperimentException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExperimentException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExperimentException(String message, Throwable cause) {
		super(message, cause);
	}
}
