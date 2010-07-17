/**
 * 
 */
package taskmodule.preconditions.var;

import taskmodule.TaskModuleException;
import taskmodule.preconditions.bool.IBoolPreCondition;

/**
 * @author Assaf
 *
 */
public class BoolVariable extends VarPreCondition implements IBoolPreCondition {

	public BoolVariable(String varName) {
		super(varName);
	}
	
	public String variableName(){
		return varName;
	}

	@Override
	public Object check() throws TaskModuleException {
		if (taskModule.getBoolVariableSet().contains(varName)) {
			return (Boolean)taskModule.getBoolVariableValue(varName);
		}
		
		throw new TaskModuleException("Unsupported variable: " + varName);
	}
}
