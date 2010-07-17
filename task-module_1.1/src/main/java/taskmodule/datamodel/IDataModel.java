/**
 * 
 */
package taskmodule.datamodel;

import java.io.IOException;
import java.io.Serializable;

import taskmodule.task.ITask;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public interface IDataModel extends Serializable{
	
	/**
	 * Exports the data stored in the IDataModel object
	 * to CSV formated file.
	 * 
	 * @param fileName File name of an output file
	 * @throws IOException Thrown if handled I/O errors during file handling
	 */
	public void export2CSV(String fileName) throws IOException;
	
	
	/**
	 * Imports the data from a previously exported CSV formated
	 * file into this IDataModel object.
	 * @param filePath Absolute or relative path to CSV formated file  
	 * @throws IOException Thrown if handled I/O errors during file handling
	 */
	public void importFromCSV(String filePath) throws IOException;
	
	/**
	 * Analyzes the data against the given task.
	 * Returns whether the task has occurred with correct preconditions. 
	 * 
	 * @param task The task to analyze. 
	 * @return True if task has occurred with correct preconditions, </br>
	 * false otherwise
	 */
	public boolean analyze(ITask task);
}
