/**
 * 
 */
package taskmodule.preconditions.bool;

import java.io.Serializable;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public interface IPreCondition extends Serializable {
	
	public Object check() throws TaskModuleException;
}
