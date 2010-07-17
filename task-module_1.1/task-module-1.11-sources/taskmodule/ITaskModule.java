/**
 * 
 */
package taskmodule;

import java.util.Set;

import taskmodule.conglogcompiler.SemanticsErrorException;
import taskmodule.conglogcompiler.SyntaxErrorException;
import taskmodule.datamodel.IDataModel;
import taskmodule.experiment.IExperiment;
import taskmodule.task.ITask;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public interface ITaskModule {
	
	/*
	 * Setup methods
	 */
	
	/**
	 * Add <i>activityName</i> support to Task Module
	 * @param activityName Activity name
	 */
	public void addActivitySupport(String activityName);
	
	/**
	 * <p>
	 * Removes Task Module support for <i>activityName</i> activity.
	 * Whether <i>activityName</i> task actually exists in the Task
	 * Module or not, the post condition of this action is that
	 * no activity named <i>activityName</i> is supported in the Task Module.
	 * </p>
	 * <p>
	 * Note: that this only effects future recording and not past recorded 
	 * data.
	 * </p>
	 * @param activityName Activity name
	 */
	public void removeActivitySupport(String activityName);
	
	/**
	 * Add <i>variableName</i> support to Task Module
	 * @param variableName Variable name
	 * @param initialValue Initial value.
	 * @throws TaskModuleException Thrown when trying to add existing variable <\br>
	 * with a new value
	 */
	public void addVariableSupport(String variableName, int initialValue) throws TaskModuleException;
	
	/**
	 * Add <i>variableName</i> support to Task Module
	 * @param variableName Variable name
	 * @param initialValue Initial value.
	 * @throws TaskModuleException Thrown when trying to add existing variable </br>
	 * with a new value
	 */
	public void addVariableSupport(String variableName, boolean initialValue) throws TaskModuleException;
	
	/**
	 * <p>
	 * Removes Task Module support for <i>variableName</i> variables.
	 * Whether <i>variableName</i> variable actually exists in the Task
	 * Module or not, the post condition of this action is that
	 * <b>no</b> variable (of any type) named <i>variableName</i> is 
	 * supported in the Task Module.
	 * </p>
	 * <p>
	 * Note: that this only effects future recording and not past recorded 
	 * data.
	 * </p>
	 * @param activityName Activity name
	 */
	public void removeVariableSupport(String variableName) throws TaskModuleException;
	
	/**
	 * Resets the Task Module. All supported activities and variables </br>
	 * are deleted as well as the recorded data.
	 */
	public void reset();
	
	/*
	 * State inquiries
	 */
	
	/**
	 * Returns the supported activities.
	 * @return A Set of supported activities.
	 */
	public Set<String> getSupportedActivities();

	/**
	 * Returns the supported Integer variables.
	 * @return A Set of supported Integer variables.
	 */
	public Set<String> getIntVariableSet();
	
	/**
	 * Returns the supported Boolean variables.
	 * @return A Set of supported Boolean variables.
	 */
	public Set<String> getBoolVariableSet();
	
	/**
	 * Returns the <i>variableName</i> value.
	 * @param variableName The name of the variable.
	 * @return The value of <i>variableName</i>
	 * @throws TaskModuleException Thrown when the variable isn't supported
	 */
	public int getIntVariableValue(String variableName) throws TaskModuleException;
	
	/**
	 * Returns the <i>variableName</i> value.
	 * @param variableName The name of the variable.
	 * @return The value of <i>variableName</i>
	 * @throws TaskModuleException Thrown when the variable isn't supported
	 */
	public boolean getBoolVariableValue(String variableName) throws TaskModuleException;

	/*
	 * Task Module Invocation
	 */
	
	/**
	 * Reports to the Task Module that the <i>activityName</i> activity occurred
	 * 
	 * @param activityName Activity name.
	 * @throws TaskModuleException Thrown when the activity isn't supported
	 */
	public void activityOccured(String activityName) throws TaskModuleException;
	
	/**
	 * Reports to the Task Module that the <i>variableName</i> value has changed to <i>newValue</i>
	 * 
	 * @param variableName Variable name.
	 * @param newValue New variable value
	 * @throws TaskModuleException Thrown when the variable isn't supported
	 */
	public void varChanged(String variableName, int newValue) throws TaskModuleException;
	
	/**
	 * Reports to the Task Module that the <i>variableName</i> value has changed to <i>newValue</i>
	 * 
	 * @param variableName Variable name.
	 * @param newValue New variable value
	 * @throws TaskModuleException Thrown when the variable isn't supported
	 */
	public void varChanged(String variableName, boolean newValue) throws TaskModuleException;
	
	/*
	 * Compilation
	 */
	
	
	/**
	 * Compile a ConGlog Script to a new concrete ITask object.
	 * 
	 * @param taskName Task name
	 * @param conglogProgram ConGlog script
	 * @return ITask concrete object.
	 * @throws SyntaxErrorException Thrown upon syntactic errors in the script
	 * @throws SemanticsErrorException Thrown upon semantic errors in the script.
	 */
	public ITask compileConGlog(String taskName, String conglogProgram) throws SyntaxErrorException, SemanticsErrorException;

	/*
	 * Management
	 */
	
	/**
	 * Creates a new concrete IExperiment object.</br>
	 * 
	 * @param experimentName Experiment name.
	 * @return Concrete IExperiment object.
	 */
	public IExperiment createExperiment(String experimentName);
	
	/**
	 * Creates a new concrete IExperiment object with an initial ITask Set.
	 * 
	 * @param experimentName Experiment name.
	 * @param tasks Initial ITask Set
	 * @return Concrete IExperiment object.
	 */
	public IExperiment createExperiment(String experimentName, Set<ITask> tasks);

	/*
	 * Data Model
	 */
	
	/**
	 * Returns the recorded data for <b>all</b> enabled experiments in the Task Module.  
	 * 
	 * @return IDataModel concrete object.
	 */
	public IDataModel getData();
	
	
	/**
	 * <p>
	 * Merges the data found in the given <i>data</i> argument into the
	 * Task Module.
	 * </p>
	 * <p>
	 * Please note: It is highly recommended that only the IDataModel object
	 * that was extracted from the <code>ITaskModule.getData()</code> method
	 * will be given as an argument here, so post method state will hold
	 * <b>all</b> previously exported data. Also, don't try to implement an 
	 * IDataModel object of your own, as this will cause a <code>TaskModuleException</code>
	 * to be thrown upon method invocation. 
	 * </p>
	 * @param data An IDataModel data object.
	 * @throws TaskModuleException Thrown in case the IDataModel implementation
	 * is not supported by the TaskModule.  
	 */
	public void loadData(IDataModel data) throws TaskModuleException;
}
