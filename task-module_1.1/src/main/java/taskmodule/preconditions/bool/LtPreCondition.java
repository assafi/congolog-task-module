/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class LtPreCondition implements IBoolPreCondition {

	private static final long serialVersionUID = -546899390746018802L;
	
	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return ((Integer)op1.check()).compareTo((Integer)op2.check()) < 0;
	}

	public LtPreCondition(IPreCondition op1, IPreCondition op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
}
