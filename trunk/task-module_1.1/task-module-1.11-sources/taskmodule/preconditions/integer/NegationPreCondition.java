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
public class NegationPreCondition implements IIntPreCondition {

	private IPreCondition op;
	
	@Override
	public Object check() throws TaskModuleException {
		return -(Integer)op.check();
	}
	public NegationPreCondition(IPreCondition op) {
		this.op = op;
	}
}
