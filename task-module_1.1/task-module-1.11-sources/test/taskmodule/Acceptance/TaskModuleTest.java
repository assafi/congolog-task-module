package taskmodule.Acceptance;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.conglogcompiler.SemanticsErrorException;
import taskmodule.conglogcompiler.SyntaxErrorException;
import taskmodule.datamodel.IDataModel;
import taskmodule.experiment.IExperiment;
import taskmodule.task.ITask;

public class TaskModuleTest {
	
	private static final String taskDescription = 
		    "Precondition-axioms(registration) = true;" +
			"Precondition-axioms(login) = var1 > 55;" +
			"Precondition-axioms(logout) = var2 > 0;" +
			"Label a:{" +
			"Label b:{registration;}" +
			"Label c:{login;}" +
			"Label d:{logout;}" +
			"}";
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TaskModuleAcceptenceTest() throws TaskModuleException, SyntaxErrorException, SemanticsErrorException{
		// Get Task Module instance
		ITaskModule taskModule = TaskModule.getInstance();
		
		// Module Initialization
		taskModule.addVariableSupport("var1", 0);
		taskModule.addVariableSupport("var2", 0);
		taskModule.addActivitySupport("registration");
		taskModule.addActivitySupport("login");
		taskModule.addActivitySupport("logout");
		
		// Create task and experiment
		ITask task = taskModule.compileConGlog("task", taskDescription);
		IExperiment exper = taskModule.createExperiment("expr");
		exper.addTask(task);
		
		// Enable experiment
		exper.enable();
		
		// Change variables and activities accrue
		taskModule.varChanged("var1", 60);
		taskModule.varChanged("var2", 10);
		taskModule.activityOccured("registration");
		taskModule.activityOccured("login");
		taskModule.activityOccured("logout");
		
		// Get data from experiment and analyze
		IDataModel experData = exper.getData();
		experData.analyze(task);
		
		// Get all recorded data and analyze 
		IDataModel allData = taskModule.getData();
		allData.analyze(task);
	}
}
