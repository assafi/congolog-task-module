/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class GeqPreCondition implements IBoolPreCondition {

	private static final long serialVersionUID = -8077030638696678719L;
	
	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return ((Integer)op1.check()).compareTo((Integer)op2.check()) >= 0;
	}

	public GeqPreCondition(IPreCondition op1, IPreCondition op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
}
