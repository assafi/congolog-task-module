/**
 * 
 */
package taskmodule.preconditions.var;

import taskmodule.TaskModuleException;
import taskmodule.preconditions.integer.IIntPreCondition;

/**
 * @author Assaf
 *
 */
public class IntVariable extends VarPreCondition implements IIntPreCondition {

	private static final long serialVersionUID = 2026258381840348977L;

	public IntVariable(String varName) { 
		super(varName);
	}

	@Override
	public Object check() throws TaskModuleException {
		if (taskModule.getIntVariableSet().contains(varName)) {
			return (Integer)taskModule.getIntVariableValue(varName);
		}
		
		throw new TaskModuleException("Unsupported variable: " + varName);
	}

}
