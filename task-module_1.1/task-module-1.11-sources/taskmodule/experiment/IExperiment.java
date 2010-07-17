/**
 * Date: Mar 15, 2010
 * task-module - IExperiment.java
 */
package taskmodule.experiment;

import java.io.Serializable;
import java.util.Set;

import taskmodule.TaskModuleException;
import taskmodule.datamodel.IDataModel;
import taskmodule.task.ITask;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public interface IExperiment extends Serializable {

		/**
		 * Returns the name of the experiment.
		 * 
		 * @return Experiment name
		 */
		String getName();
	
		/**
		 * Adds the given task to the experiment.
		 * 
		 * @param task Task to be added.
		 */
		void addTask(ITask task);
		
		
		/**
		 * Removes the given task from the experiment.
		 * @param task An ITask object to be removed from the experiment.		 */
		void removeTask(ITask task);
		/**
		 * Returns a set of tasks currently in the experiment.
		 * 
		 * @return Set of tasks in the experiment.
		 */
		Set<ITask> getTasks();
		
		/**
		 * Activates the experiment. 
		 * After invocation all activities 
		 * that happen in the system and are part of at 
		 * least one task will be recorded.
		 */
		void enable();
		/**
		 * Stops the experiment.
		 * After invocation if an activity that is part of at 
		 * least one task happened it won't be recorded.  
		 */
		void disable();
		
		/**
		 * Returns the recorded activities that are part
		 * of at least one task in the experiment.
		 * 
		 * @return IDataModel - Recorded data object.
		 * @throws TaskModuleException
		 */
		IDataModel getData() throws TaskModuleException;
}
