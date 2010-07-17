package taskmodule.preconditions.var;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.preconditions.bool.IPreCondition;

public abstract class VarPreCondition implements IPreCondition {

	private static final long serialVersionUID = 7196104956355920391L;
	
	protected String varName;
	protected ITaskModule taskModule = null;

	public VarPreCondition(String varName) { 
		this.varName = varName;
		this.taskModule = TaskModule.getInstance();
	}

	@Override
	public abstract Object check() throws TaskModuleException;
}
