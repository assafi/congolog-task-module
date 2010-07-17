/**
 * Date: Mar 15, 2010
 * task-module - DataModel.java
 */
package taskmodule.datamodel;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import taskmodule.TaskModuleException;
import taskmodule.datamodel.DataObject.Label;
import taskmodule.preconditions.bool.IPreCondition;
import taskmodule.preconditions.var.BoolVariable;
import taskmodule.task.ITask;
import taskmodule.task.Task;
import taskmodule.util.Tree;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public class DataModel implements IDataModel {

	private static final long serialVersionUID = 7748497430805107083L;

	private PriorityQueue<DataObject> data = null;
	
	private Timestamp lastActivityTime = null;
	
	/**
	 * 
	 */
	public DataModel() {
		data = new PriorityQueue<DataObject>();
	}
	
	public void addActivity(Task task, Timestamp timestamp, String activityName, 
			boolean preconditionsMet){
		
		DataObject dobj = new DataObject(task, activityName, preconditionsMet, timestamp);
		addData(dobj);
	}
	
	public void addVariable(String variableName, int variableValue, Timestamp timestamp){
		
		DataObject dobj = new DataObject(variableName, variableValue, timestamp);
		addData(dobj);
	}
	
	public void addVariable(String variableName, boolean variableValue, Timestamp timestamp){
		
		DataObject dobj = new DataObject(variableName, variableValue, timestamp);
		addData(dobj);
	}
	
	public void addRecord(DataObject dobj){
		if (!data.contains(dobj)){
			data.add(dobj);
		}
	}
	
	@Override
	public boolean analyze(ITask task) {	
		if (null == task)
			throw new NullPointerException("Task parameter is null.");
		
		if (!(task instanceof Task))
			throw new UnsupportedClassVersionError("Task Module does not support new ITask implementations.");
		
		
		Task cTask = (Task)task;
		
		Tree<String> layout = cTask.getTaskLayout();
		
		DataModel recordedTaskData = getDataModel(task);
		
		if (recordedTaskData.data.isEmpty()){
			return false;
		}
		
		lastActivityTime = recordedTaskData.data.peek().getTimestamp();
		
		return compareLayoutData(cTask, layout, recordedTaskData);
	}
			
	private boolean compareLayoutData(Task task ,Tree<String> layout,
									  DataModel recordedTaskData) {
		String nodeName = layout.getHead();
		Collection<Tree<String>> succesors = layout.getSubTrees();
		if (succesors.isEmpty()){
			return checkActivitiesInRecording(nodeName, recordedTaskData);
		}
		else{
			if (nodeName.startsWith("or")){
				boolean orCond = false;
				Map<Tree<String>, IPreCondition> dynamicConditions = task.getDynamicConditions();
				for (Tree<String> succesor : succesors) {
					IPreCondition dynamicCond = dynamicConditions.get(succesor);
					boolean boolDynamicCond = true;
					try {
						boolDynamicCond = checkDynamicCondInRecording(dynamicCond,recordedTaskData);
					} catch (TaskModuleException e) {
					}
					orCond = orCond || ( boolDynamicCond && compareLayoutData(task, succesor, recordedTaskData));
				}
				return orCond;
			}
			else{
				boolean cond = true;
				for (Tree<String> succesor : succesors) {
					cond = cond && compareLayoutData(task, succesor, recordedTaskData);
				}
				return cond;
			}
		}
	}

	private boolean checkDynamicCondInRecording(IPreCondition dynamicCond, DataModel recordedTaskData) throws TaskModuleException {
		// if we don't have dynamic condition return true
		if (null == dynamicCond){
			return true;
		}
		
		String condName = ((BoolVariable)dynamicCond).variableName();
		Map<String, Boolean> varValues = new HashMap<String, Boolean>();
		for (DataObject dobj : recordedTaskData.data) {
			if(!dobj.isActivityRecord()
			   && (dobj.getTimestamp().before(lastActivityTime) || dobj.getTimestamp().equals(lastActivityTime))){
				if (varValues.containsKey(dobj.getVariable())){
					varValues.remove(dobj.getVariable());
				}
				varValues.put(dobj.getVariable(), dobj.getVariableValue() == 1 ? true : false);
			}
		}
		
		if (varValues.containsKey(condName)){
			return varValues.get(condName);
		}
		
		return (Boolean)dynamicCond.check();
		
	}

	private boolean checkActivitiesInRecording(String nodeName,
			DataModel recordedTaskData) {
		Iterator<DataObject> dataIter = recordedTaskData.data.iterator();
		while (dataIter.hasNext()){
			DataObject dobj = dataIter.next();
			if(dobj.isActivityRecord() 
			   && dobj.getActivity().equals(nodeName)
			   && dobj.isPreconditionsMet()
			   && (dobj.getTimestamp().after(lastActivityTime) || dobj.getTimestamp().equals(lastActivityTime))){
				if (dataIter.hasNext())
					dobj = dataIter.next();
				while(!dobj.isActivityRecord() && dataIter.hasNext())
					dobj = dataIter.next();
				lastActivityTime = dobj.getTimestamp();
				return true;
			}
		}
		
		return false;
	}

	
	public DataModel getDataModel(ITask task) {
		DataModel dataModel = new DataModel();
		
		for (DataObject dobj : data) {
			// the variable recordings are relevant for all tasks
			if(!dobj.isActivityRecord()){
				dataModel.addRecord(dobj);
				continue;
			}
			
			if (null != dobj.getTaskName() && task.getName().equals(dobj.getTaskName())){
				dataModel.addRecord(dobj);
			}
		}
		
		return dataModel;
	}
	
	public DataModel getDataModel(Set<ITask> tasks){
		DataModel dataModel = new DataModel();
		
		for (DataObject dobj : data) {
			
			// the variable recordings are relevant for all tasks
			if(!dobj.isActivityRecord()){
				dataModel.addRecord(dobj);
				continue;
			}
			
			for (ITask task : tasks) {
				if (task.getName().equals(dobj.getTaskName())){
					dataModel.addRecord(dobj);
				}
			}
		}
		
		return dataModel;
	}

	@Override
	public void export2CSV(String fileName) throws IOException {
		File file = new File(fileName);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		if (!file.canWrite()) {
			throw new IOException("Can't write to file " + fileName);
		}
		
		CsvWriter writer = new CsvWriter(file, System.getProperty("file.encoding"));
		writer.writeLabels(DataObject.Label.names());

		for (DataObject dataObj : data) {
			writer.writeData(dataObj.getData());
		}
		
		writer.close();
	}

	@Override
	public void importFromCSV(String filePath) throws IOException {
		CsvReader reader = null;
		try {
			File file = new File(filePath);
			
			if (!file.exists()) {
				throw new IOException("File not found");
			}
			if (!file.canRead()) {
				throw new IOException("Can't read file");
			}
			
			reader = new CsvReader(file, System.getProperty("file.encoding"));
			List<String> importedLabels = reader.readLabels();
			for (String label : Label.names()) {
				if (!importedLabels.contains(label)) {
					throw new IllegalArgumentException("CSV file format does is not valid");
				}
			}
			while (reader.next()) {
				DataObject dobj = reader.getData();
				addData(dobj);
			}
		} finally {
			if (null != reader) 
				reader.close();
		}
	}

	private void addData(DataObject dobj) {
		if (!data.contains(dobj)) {
			data.add(dobj);
		}
	}
	
	public void merge(DataModel in) {
		
		for (DataObject inObj : in.data) {
			addData(inObj);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (!(o instanceof DataModel)) {
			return false;
		}
		
		DataModel dm = (DataModel) o;
		
		if (data.size() != dm.data.size()) {
			return false;
		}
		
		for (DataObject dobj : data) {
			if (!dm.data.contains(dobj)) {
				return false;
			}
		}
		return true;
	}
}
