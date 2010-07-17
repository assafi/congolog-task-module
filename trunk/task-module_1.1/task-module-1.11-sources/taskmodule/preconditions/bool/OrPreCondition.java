/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class OrPreCondition implements IBoolPreCondition {

	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return ((Boolean)op1.check() || (Boolean)op2.check());
	}

	public OrPreCondition(IPreCondition op1, IPreCondition op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
}
