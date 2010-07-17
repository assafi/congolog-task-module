package taskmodule.experiment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.datamodel.IDataModel;
import taskmodule.task.ITask;
import taskmodule.task.Task;

public class ExperimentTest {

	private static Experiment expr = null;
	
	static private Task task1 = null;
	static private ITaskModule taskModule = TaskModule.getInstance();
	static private final String TaskDescription1 = "Precondition-axioms(login) = true;\n " +
												   "Label a:{login;}\n"; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		taskModule.reset();
		expr = new Experiment("expr1");
		taskModule.addActivitySupport("login");
		ConGlogCompiler compiler1 = new ConGlogCompiler();
		try{
			task1 = compiler1.parse(TaskDescription1);
			task1.setName("task1");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddTask() {
		expr.addTask(task1);
		Set<ITask> exprTasks = expr.getTasks();
		assertTrue(exprTasks.contains(task1));
	}
	
	@Test
	public void testEnable() {
		expr.enable();
		assertTrue(expr.isExperimentActive());
	}

	@Test
	public void testDesiable() {
		expr.disable();
		assertFalse(expr.isExperimentActive());
	}

	@Test
	public void testSetGetName() {
		expr.setExperimentName("expr");
		assertEquals(expr.getName(), "expr");
	}

	@Test
	public void testSetGetExperimentId() {
		UUID id = UUID.randomUUID();
		expr.setExperimentId(id);
		assertEquals(id, expr.getExperimentId());
	}
	
	@Test
	public void testSetGetStartTimeStamp() {
		Timestamp exprTime = new Timestamp(new Date().getTime());
		expr.setStartTimeStamp(exprTime);
		assertEquals(exprTime, expr.getStartTimeStamp());
	}
	
	@Test
	public void testGetData() throws IOException, TaskModuleException, InterruptedException {
		IDataModel dModel = null;
		expr.addTask(task1);
		expr.enable();
		taskModule.activityOccured("login");
		dModel = expr.getData();

		Thread.sleep(500);
		String timeInMilli = String.valueOf(
				Calendar.getInstance().getTimeInMillis());
		Thread.sleep(500);
		String fileName = timeInMilli + ".csv";
		dModel.export2CSV(fileName);

		File outFile = new File(fileName);
		outFile.deleteOnExit();
		
		BufferedReader in = new BufferedReader(new FileReader(outFile));
		in.readLine();
		String[] data = in.readLine().split(",");
		assertEquals(task1.getName(), data[0]);
		assertEquals("login", data[1]);
		in.close();
	}

}
