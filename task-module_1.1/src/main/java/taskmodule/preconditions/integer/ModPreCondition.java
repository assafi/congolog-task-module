/**
 * 
 */
package taskmodule.preconditions.integer;

import taskmodule.TaskModuleException;
import taskmodule.preconditions.bool.IPreCondition;

/**
 * @author Assaf
 *
 */
public class ModPreCondition implements IIntPreCondition {

	private static final long serialVersionUID = 8301412552708743916L;
	
	private IPreCondition op1;
	private IPreCondition op2;
	
	@Override
	public Object check() throws TaskModuleException {
		return (Integer)op1.check() % (Integer)op2.check();
	}

	public ModPreCondition(IPreCondition op1, IPreCondition op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
}
