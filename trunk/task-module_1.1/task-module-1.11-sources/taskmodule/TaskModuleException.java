/**
 * Date: Mar 15, 2010
 * task-module - TaskModuleException.java
 */
package taskmodule;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public class TaskModuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9062493971624037654L;

	public TaskModuleException() {
		super();
	}

	public TaskModuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaskModuleException(String message) {
		super(message);
	}

	public TaskModuleException(Throwable cause) {
		super(cause);
	}
}
