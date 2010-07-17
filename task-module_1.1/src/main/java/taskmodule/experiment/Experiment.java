/**
 * Date: Mar 20, 2010
 * task-module - DataModel.java
 */
package taskmodule.experiment;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import taskmodule.TaskModuleException;
import taskmodule.datamodel.IDataModel;
import taskmodule.recorder.Recorder;
import taskmodule.task.ITask;
import taskmodule.task.Task;


/**
 * @author Assaf Israel & Eli Nazarov (Group 3, SE Project)
 *
 */
public class Experiment implements IExperiment{

	private static final long serialVersionUID = -4916878865445781938L;
	
	private String experimentName = "New experiment";
	private UUID experimentId = null;
	private boolean isExperimentActive;
	private Timestamp startTimeStamp;
	private Set<ITask> tasks = null;
	
	private void init(String name) {
		tasks = new HashSet<ITask>();
		this.experimentName = name;
		isExperimentActive = false;
		this.experimentId = UUID.randomUUID();
	}
	
	public Experiment(String name){
		init(name);
	}

	public Experiment(String name, Set<ITask> tasks_) {
		init(name);
		tasks = tasks_;
	}

	@Override
	public void addTask(ITask task) {
		if(!(task instanceof Task)) {
			throw new UnsupportedClassVersionError("Task Module does not support new ITask implementations.");
		}
		this.tasks.add(task);
	}

	@Override
	public void disable() {
		this.isExperimentActive = false;
		Recorder.getInstance().removeActiveExperiment(this);
	}

	@Override
	public void enable() {
		this.isExperimentActive = true;
		Recorder.getInstance().addActiveExperiment(this);
	}

	@Override
	public IDataModel getData() throws TaskModuleException {
		return Recorder.getInstance().getData(this);
	}
	@Override
	public Set<ITask> getTasks(){
		return tasks;
	}
	
	@Override
	public String getName() {
		return experimentName;
	}
	
	public UUID getExperimentId() {
		return experimentId;
	}

	public void setExperimentId(UUID experimentId) {
		this.experimentId = experimentId;
	}

	public boolean isExperimentActive() {
		return isExperimentActive;
	}

	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}
	
	public Timestamp getStartTimeStamp() {
		return startTimeStamp;
	}

	public void setStartTimeStamp(Timestamp timeStamp) {
		this.startTimeStamp = timeStamp;
	}

	@Override
	public void removeTask(ITask task) {
		if(!(task instanceof Task)) {
			throw new UnsupportedClassVersionError("Task Module does not support new ITask implementations.");
		}
		
		tasks.remove(task);
	}
	
	@Override
	public String toString() {
		return experimentName;
	}
}
