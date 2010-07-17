/**
 * Date: Mar 15, 2010
 * task-module - DataObject.java
 */
package taskmodule.datamodel;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import taskmodule.task.Task;

/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public class DataObject implements Comparable<DataObject>, Comparator<DataObject>,
	Serializable {

	private static final long serialVersionUID = -1240017865873535767L;

	private boolean isActivityRecord;
	private String taskName = null;
	private String activity = null;
	private boolean preconditionsMet = true;
	private String variable = null;
	private int variableValue;
	private Timestamp timestamp = null;
	
	public enum Label {
		Task {
			public String getData(DataObject dataObject) {
				return dataObject.getTaskName();
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.taskName = textValue;
			}
		},
		Activity {
			public String getData(DataObject dataObject) {
				return dataObject.getActivity();
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.activity = textValue;
			}
		},
		Variable {
			public String getData(DataObject dataObject) {
				return dataObject.getVariable();
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.variable = textValue;
			}
		},
		Variable_Value {
			public String getData(DataObject dataObject) {
				return String.valueOf(dataObject.getVariableValue());
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.variableValue = Integer.valueOf(textValue);
			}
		},
		PreConditions_Status {
			public String getData(DataObject dataObject) {
				return String.valueOf(dataObject.isPreconditionsMet());
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.preconditionsMet = Boolean.getBoolean(textValue);
			}
		},
		Timestamp {
			public String getData(DataObject dataObject) {
				return dataObject.getTimestamp().toString();
			}

			@Override
			public void setData(DataObject dobj, String textValue) {
				dobj.timestamp = java.sql.Timestamp.valueOf(textValue);
			}
		}
		;
		
		public static String[] names() {
			String[] names = new String[size()];
			for (int i = 0; i<names.length; i++) {
				names[i] = Label.values()[i].name();
			}
			return names;
		}
		
		public static int size() {
			return Label.values().length;
		}

		abstract public String getData(DataObject dataObject);
		
		abstract public void setData(DataObject dobj, String textValue);
	}
	
	public DataObject(Task task, String activity, boolean preconditionsMet, Timestamp timestamp) {
		
		this.isActivityRecord = true;
		this.taskName = task.getName();
		this.activity = activity;
		this.preconditionsMet = preconditionsMet;
		this.timestamp = timestamp;
	}
	
	public DataObject(String variable, int value, Timestamp timestamp) {
		
		this.isActivityRecord = false;
		this.variable = variable;
		this.variableValue = value;
		this.timestamp = timestamp;
	}
	
	public DataObject(String variable, boolean value, Timestamp timestamp) {
		
		this.isActivityRecord = false;
		this.variable = variable;
		this.variableValue = (value ? 1 : 0);
		this.timestamp = timestamp;
	}
	
	public DataObject(Map<String, String> data) {
		this.isActivityRecord = data.get(Label.Variable.name()).equals("");
		this.activity = data.get(Label.Activity.name());
		this.preconditionsMet = data.get(Label.PreConditions_Status.name()).equals("1");
		this.taskName = data.get(Label.Task.name());
		this.timestamp = Timestamp.valueOf(data.get(Label.Timestamp.name()));
		this.variable = data.get(Label.Variable.name());
		this.variableValue = Integer.valueOf(data.get(Label.Variable_Value.name()));
	}
	
	public String getTaskName() {
		return taskName;
	}

	public boolean isPreconditionsMet() {
		return preconditionsMet;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public String getVariable() {
		return variable;
	}

	public int getVariableValue() {
		return variableValue;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public boolean isActivityRecord(){
		return isActivityRecord;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof DataObject)) {
			return false;
		}
		
		DataObject dobj = (DataObject)obj;
		
		if ((null != taskName && null == dobj.getTaskName()) 
			|| (null == taskName && null != dobj.getTaskName())){
			return false;
		}
		
		// if this is activity data
		if (null != taskName){
			if (dobj.getTaskName().equals(taskName) &&
				preconditionsMet == dobj.preconditionsMet &&
				activity.equals(dobj.activity) && timestamp.equals(dobj.timestamp)) {
					return true;
			}
		}else{// if this is variable data
			if (variable.equals(dobj.getVariable()) &&
				variableValue== dobj.getVariableValue() &&
				timestamp.equals(dobj.timestamp)) {
					return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(DataObject o) {
		int iRet;
		if (this.equals(o)) {
			iRet = 0;
		} else {
			iRet = timestamp.compareTo(o.timestamp);
		}
		return iRet;
	}

	@Override
	public int compare(DataObject dobj1, DataObject dobj2) {
		return dobj1.compareTo(dobj2);
	}
	
	public Map<String, String> getData() {
		Map<String, String> dataMapping = new HashMap<String, String>(Label.size());
		
		for (Label label : Label.values()) {
			dataMapping.put(label.name(), label.getData(this));
		}
		return dataMapping;
	}
}
