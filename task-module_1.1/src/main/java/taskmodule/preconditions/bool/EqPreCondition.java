/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class EqPreCondition implements IBoolPreCondition {

	private static final long serialVersionUID = -4357018850477756195L;
	
	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return ((Integer)op1.check()).compareTo((Integer)op2.check()) == 0;
	}

	public EqPreCondition(IPreCondition op1, IPreCondition op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
}
