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

	private static final long serialVersionUID = -524197264860944615L;
	
	private IPreCondition op;
	
	@Override
	public Object check() throws TaskModuleException {
		return -(Integer)op.check();
	}
	public NegationPreCondition(IPreCondition op) {
		this.op = op;
	}
}
