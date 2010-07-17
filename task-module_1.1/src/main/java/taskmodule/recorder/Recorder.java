/**
 * 
 */
package taskmodule.recorder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import taskmodule.TaskModuleException;
import taskmodule.datamodel.DataModel;
import taskmodule.datamodel.IDataModel;
import taskmodule.experiment.Experiment;
import taskmodule.task.ITask;
import taskmodule.task.Task;
/**
 * @author eli
 *
 */
public class Recorder {
	
	/*
	 * This list holds all experiments that were enabled by the user.
	 * When an experiment is being enabled it must add itself to this list.
	 */
	private List<Experiment> activeExperiments = null; 
	
	private DataModel recordedData = null;
	
	private final static Recorder instance = new Recorder();
	
	private Recorder(){
		reset();
	}

	public void reset() {
		activeExperiments = new LinkedList<Experiment>();
		recordedData = new DataModel();
	}
	
	public static Recorder getInstance(){
		
		return instance;
	}
	
	public void addActiveExperiment(Experiment expr){
		if (null == expr){
			throw new NullPointerException();
		}
		
		activeExperiments.add(expr);
	}
	
	public void removeActiveExperiment(Experiment expr){
		if (null == expr){
			throw new NullPointerException();
		}
		
		if (activeExperiments.contains(expr)){
			activeExperiments.remove(expr);
		}
	}
	
	public void recordActivity(String activityName) throws TaskModuleException {
	
		if (null == activityName){
			throw new NullPointerException();
		}
		
		// Record only if this activity is a part of some task at at least one active experiment
		for (Experiment expr : activeExperiments) {
			for (ITask itask : expr.getTasks()) {
				Task task = (Task) itask;
				if (task.getTaskLayout().containsNode(activityName)){
						recordedData.addActivity(task, new Timestamp(new Date().getTime()), activityName, 
								task.checkPreCondition(activityName));
				}
			}
		}
	}
	
	public void recordVariableChange(String variableName, int value) throws TaskModuleException{
		if (null == variableName){
			throw new NullPointerException();
		}
		
		//Record variable change anyway
		recordedData.addVariable(variableName, value, new Timestamp(new Date().getTime()));
	}
	
	public void recordVariableChange(String variableName, boolean value) throws TaskModuleException{
		if (null == variableName){
			throw new NullPointerException();
		}
		
		//Record variable change anyway
		recordedData.addVariable(variableName, value, new Timestamp(new Date().getTime()));
	}

	public DataModel getData() {
		return this.recordedData;
	}
	
	public DataModel getData(Experiment expr) throws TaskModuleException {
		if (null == expr){
			throw new NullPointerException();
		}
		
		return recordedData.getDataModel(expr.getTasks());
	}

	public void loadData(IDataModel data) throws TaskModuleException {

		if (!(data instanceof DataModel)) {
			throw new TaskModuleException("Task Model conrcrete " +
					"implementation does not support customized IDataModel objects");
		}
		recordedData.merge((DataModel)data);
	}
	
}
