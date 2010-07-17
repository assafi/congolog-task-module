/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class NotPreCondition implements IBoolPreCondition {

	private IPreCondition op1;
	
	@Override
	public Object check() throws TaskModuleException {
		return !(Boolean)op1.check();
	}

	public NotPreCondition(IPreCondition op1) {
		this.op1 = op1;
	}
}
