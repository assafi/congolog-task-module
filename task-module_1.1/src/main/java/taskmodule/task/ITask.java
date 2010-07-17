/**
 * Date: Mar 15, 2010
 * task-module - ITask.java
 */
package taskmodule.task;

import java.io.Serializable;

import javax.swing.JTree;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public interface ITask extends Serializable {

    /**
     * Sets the name of the task. If a previous name has been set, it will be 
     * run over.
     * 
     */
    public void setName(String name);

	/**
	 * Returns the name of the task.
	 * 
	 * @return Task name.
	 */
	public String getName();
	
	/**
	 * Returns the activities of the task as a JTree.
	 * The order of the activities in the tree is set 
	 * according to the compiled ConGlog script of the task.  
	 * 
	 * @return Tree of task's activities.
	 */
	public JTree getDescription();
}
