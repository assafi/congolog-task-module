/**
 * 
 */
package taskmodule.preconditions.bool;

import taskmodule.TaskModuleException;

/**
 * @author Assaf
 *
 */
public class AndPreCondition implements IBoolPreCondition {

	private static final long serialVersionUID = 4695132414442166855L;
	
	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return ((Boolean)op1.check() && (Boolean)op2.check());
	}

	public AndPreCondition(IPreCondition op1, IPreCondition op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
	}
}
