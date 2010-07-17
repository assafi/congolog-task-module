/**
 * Date: Mar 15, 2010
 * task-module - TaskModule.java
 */
package taskmodule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.conglogcompiler.SemanticsErrorException;
import taskmodule.conglogcompiler.SyntaxErrorException;
import taskmodule.datamodel.IDataModel;
import taskmodule.experiment.Experiment;
import taskmodule.experiment.IExperiment;
import taskmodule.recorder.Recorder;
import taskmodule.task.ITask;
import taskmodule.task.Task;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public class TaskModule implements ITaskModule {

	private static TaskModule instance = null;
	private Recorder recorder = null;
	private Set<String> activities = null;
	private Map<String, Integer> intVariables = null;
	private Map<String, Boolean> boolVariables = null;
	
	private TaskModule() {
		this.recorder = Recorder.getInstance();
		init();
	}

	private void init() {
		this.activities = new HashSet<String>();
		this.intVariables = new HashMap<String, Integer>();
		this.boolVariables = new HashMap<String, Boolean>();
	}
	
	public static ITaskModule getInstance() {
		if (null == instance) {
			instance = new TaskModule();
		}
		
		return instance;
	}

	@Override
	public void activityOccured(String activityName) throws TaskModuleException {
		
		if (null == activityName) {
			throw new NullPointerException();
		}
		
		if (!activities.contains(activityName)) {
			throw new TaskModuleException("Activity " + activityName + " is not supported. please add it using addActivity()");
		}
		recorder.recordActivity(activityName);
	}

	@Override
	public void addActivitySupport(String activityName) {
		if (null == activityName) {
			throw new NullPointerException();
		}
		if (!activities.contains(activityName)) {
			activities.add(activityName);
		}
	}
	
	@Override
	public void removeActivitySupport(String activityName) {
		
		activities.remove(activityName);
	}

	@Override
	public void addVariableSupport(String variableName, int initialValue) throws TaskModuleException {
		
		if (!intVariables.containsKey(variableName)) {
			intVariables.put(variableName, new Integer(initialValue));
			return;
		} 
		
		if (!intVariables.get(variableName).equals(new Integer(initialValue))) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
	}

	@Override
	public void addVariableSupport(String variableName, boolean initialValue) throws TaskModuleException{
		if (!boolVariables.containsKey(variableName)) {
			boolVariables.put(variableName, new Boolean(initialValue));
			return;
		} 
		
		if (!boolVariables.get(variableName).equals(new Boolean(initialValue))) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
	}
	
	@Override
	public void removeVariableSupport(String variableName)
			throws TaskModuleException {
		boolVariables.remove(variableName);
		intVariables.remove(variableName);
	}

	@Override
	public ITask compileConGlog(String taskName, String conglogProgram)
		throws SyntaxErrorException, SemanticsErrorException{
		
		ConGlogCompiler compiler = new ConGlogCompiler();
		Task task = compiler.parse(conglogProgram);
		task.setName(taskName);
		return task;
	}

	@Override
	public Set<String> getSupportedActivities() {
		return new HashSet<String>(this.activities);
	}

	@Override
	public Set<String> getBoolVariableSet() {
		return new HashSet<String>(this.boolVariables.keySet());
	}

	@Override
	public Set<String> getIntVariableSet() {
		return new HashSet<String>(this.intVariables.keySet());
	}

	@Override
	public IDataModel getData() {
		return recorder.getData();
	}

	@Override
	public void varChanged(String variableName, int newValue) throws TaskModuleException{
		if (null == variableName) {
			throw new NullPointerException();
		}
		
		if (!intVariables.containsKey(variableName)) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
		intVariables.remove(variableName);
		intVariables.put(variableName, new Integer(newValue));
		recorder.recordVariableChange(variableName, newValue);
	}

	@Override
	public void varChanged(String variableName, boolean newValue) throws TaskModuleException{
		if (null == variableName) {
			throw new NullPointerException();
		}
		
		if (!boolVariables.containsKey(variableName)) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
		boolVariables.remove(variableName);
		boolVariables.put(variableName, new Boolean(newValue));
		recorder.recordVariableChange(variableName, newValue);
	}

	@Override
	public boolean getBoolVariableValue(String variableName) throws TaskModuleException {  
		if (null == variableName) {
			throw new NullPointerException();
		}
		
		if (!boolVariables.containsKey(variableName)) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
		
		return boolVariables.get(variableName);
	}

	@Override
	public int getIntVariableValue(String variableName) throws TaskModuleException {
		if (null == variableName) {
			throw new NullPointerException();
		}
		
		if (!intVariables.containsKey(variableName)) {
			throw new TaskModuleException(varNotSupported(variableName));
		}
		
		return intVariables.get(variableName);
	}
	
	private static String varNotSupported(String variableName) {
		return "Variable " + variableName + " is not supported.  please add it using addVariable()";
	}
	
	private static String activityNotSupported(String activityName) {
		return "Activity " + activityName + " is not supported.  please add it using addVariable()";
	}

	@Override
	public IExperiment createExperiment(String experimentName) {
		return new Experiment(experimentName);
	}

	@Override
	public IExperiment createExperiment(String experimentName, Set<ITask> tasks) {
		return new Experiment(experimentName, tasks);
	}

	@Override
	public void reset() {
		init();
		recorder.reset();
	}

	@Override
	public void loadData(IDataModel data) throws TaskModuleException {
		
		if (null == data) {
			return;
		}
		recorder.loadData(data);
	}

}
