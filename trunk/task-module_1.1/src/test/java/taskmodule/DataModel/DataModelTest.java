package taskmodule.DataModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.datamodel.DataModel;
import taskmodule.datamodel.DataObject;
import taskmodule.task.ITask;
import taskmodule.task.Task;

public class DataModelTest {

	static private Task task1 = null;
	static private Timestamp taskTime1 = null;
	static private ITaskModule taskModule = TaskModule.getInstance();
	static private final String TaskDescription1 = "Precondition-axioms(login) = true;\n " +
												   "Label a:{login;}\n"; 
	
	static private Task task2 = null;
	static private Timestamp taskTime2 = null;
	static private final String TaskDescription2 = "Precondition-axioms(login) = true;\n"  +
												   "Precondition-axioms(logout) = true;\n" +
												   "Label d:{\n" +
												   "Label a:{" +
												   "	Label b:{" +
												   "		Label e:{login;}\n" +
												   "	}" +
												   "	Label c:{logout;}\n" +
												   "}" +
												   "}\n";
	
	static private Task task3 = null;
	static private Timestamp taskTime3 = null;
	static private final String TaskDescription3 = "Precondition-axioms(login) = true;\n"  +
												   "Precondition-axioms(act2) = true;\n" +
												   "Precondition-axioms(logout) = true;\n" +
												   "Label d:{\n" +
												   "Label a:{" +
												   "	Label b:{" +
												   "		login;\n" +
												   "		[act1 | act2]" +
												   "	}" +
												   "	Label c:{logout;}\n" +
												   "}" +
												   "}\n";
	
	static private Task task4 = null;
	static private final String TaskDescription4 = "Precondition-axioms(login) = true;\n"  +
												   "Precondition-axioms(act1) = true;\n" +
												   "Precondition-axioms(act2) = true;\n" +
												   "Precondition-axioms(act3) = true;\n" +
												   "Precondition-axioms(logout) = true;\n" +
												   "Label a:{\n" +
												   "	Label b:{\n" +
												   "		Label c:{\n" +
												   "			login;\n" +
												   "			act2;\n" +
												   "		}\n" +
												   "		Label d:{\n" +
												   "			logout;\n" +
												   "			[bool1 ? act1 | bool2 ? c]\n" +
												   "			Label e:\n{" +
												   "				[bool1 ? act3]\n" +
												   "			}\n" +
												   " 	   }\n" +
												   "	}\n" +
												   "}\n";
	
	static private DataModel dModel = null;
	static private DataModel dModel2 = null;
	static private DataModel dModel3 = null;
	static private DataModel dModel4 = null;
	static private DataModel dModel5 = null;
	static private DataModel dModel6 = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dModel = new DataModel();
		dModel2 = new DataModel();
		dModel3 = new DataModel();
		dModel4 = new DataModel();
		dModel5 = new DataModel();
		dModel6 = new DataModel();
		
		initDataActivity();
		dModel.addActivity(task1, taskTime1, "login", true);
	}

	@Before
	public void setUp() throws Exception {
	}

	static private void initDataActivity() throws TaskModuleException {
		taskModule.addActivitySupport("login");
		taskModule.addActivitySupport("logout");
		taskModule.addActivitySupport("act1");
		taskModule.addActivitySupport("act2");
		taskModule.addActivitySupport("act3");
		taskModule.addVariableSupport("bool1", false);
		taskModule.addVariableSupport("bool2", false);
		
		taskTime1 = new Timestamp(new Date().getTime());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		taskTime2 = new Timestamp(new Date().getTime());
		taskTime3 = new Timestamp(new Date().getTime());
		
		ConGlogCompiler compiler1 = new ConGlogCompiler();
		ConGlogCompiler compiler2 = new ConGlogCompiler();
		ConGlogCompiler compiler3 = new ConGlogCompiler();
		ConGlogCompiler compiler4 = new ConGlogCompiler();
		try{
			task1 = compiler1.parse(TaskDescription1);
			task1.setName("task1");
			task2 = compiler2.parse(TaskDescription2);
			task2.setName("task2");
			task3 = compiler3.parse(TaskDescription3);
			task3.setName("task3");
			task4 = compiler4.parse(TaskDescription4);
			task4.setName("task4");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnalyze() throws InterruptedException {

		assertTrue(dModel.analyze(task1));// test success

		assertFalse(dModel2.analyze(task1)); // test empty model - fail

		dModel2.addActivity(task1, taskTime1, "login", false);
		assertFalse(dModel2.analyze(task1)); // test wrong precondition - fail

		dModel2.addActivity(task1, taskTime1, "login", true);
		assertTrue(dModel2.analyze(task1)); // test wrong precondition - fail

		Timestamp time1 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time2 = new Timestamp(new Date().getTime());
		
		dModel3.addActivity(task2, time1, "logout", true);
		dModel3.addActivity(task2, time2, "login", true);
		assertFalse(dModel3.analyze(task2)); // test wrong order - fail
		
		Thread.sleep(1000);
		time1 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		time2 = new Timestamp(new Date().getTime());
		
		dModel3.addActivity(task2, time1, "login", true);
		dModel3.addActivity(task2, time2, "logout", false);
		assertFalse(dModel3.analyze(task2)); // test wrong order - fail

		Thread.sleep(1000);
		time1 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		time2 = new Timestamp(new Date().getTime());
		
		dModel3.addActivity(task2, time1, "login", true);
		dModel3.addActivity(task2, time2, "logout", true);
		assertTrue(dModel3.analyze(task2)); // test wrong order - fail
	}

	@Test
	public void testSelectiveOrAnalyze() throws InterruptedException {
		
		dModel4.addActivity(task3, taskTime3, "login", true);

		Timestamp time1 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time2 = new Timestamp(new Date().getTime());
		
		dModel4.addActivity(task3, time1, "act2", true);
		dModel4.addActivity(task3, time2, "logout", true);
		
		assertTrue(dModel4.analyze(task3));// test success
	}
	
	@Test
	public void testSelectiveOrAnalyzeStress() throws InterruptedException, TaskModuleException {
		
		Timestamp time1 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time2 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time3 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time4 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time5 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time6 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time7 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time8 = new Timestamp(new Date().getTime());
		Thread.sleep(1000);
		Timestamp time9 = new Timestamp(new Date().getTime());

		
		dModel5.addActivity(task4, time1, "login", true);
		assertFalse(dModel5.analyze(task4)); // test not all activities happend

		
		dModel5.addActivity(task4, time2, "act2", true);
		dModel5.addActivity(task4, time3, "logout", true);
		dModel5.addVariable("bool2", true, time4);
		dModel5.addActivity(task4, time5, "login", true);
		dModel5.addActivity(task4, time6, "act2", true);
		dModel5.addVariable("bool1", true, time7);
		dModel5.addActivity(task4, time8, "act3", true);
		
		assertTrue(dModel5.analyze(task4));// test success
		
		dModel5 = new DataModel();
		dModel5.addVariable("bool1", false, time1);
		dModel5.addVariable("bool2", false, time1);
		dModel5.addActivity(task4, time1, "login", true);
		dModel5.addActivity(task4, time2, "act2", true);
		dModel5.addActivity(task4, time3, "logout", true);
		dModel5.addVariable("bool2", false, time4);
		dModel5.addActivity(task4, time5, "login", true);
		dModel5.addActivity(task4, time6, "act2", true);
		dModel5.addVariable("bool1", true, time7);
		dModel5.addActivity(task4, time8, "act3", true);
		dModel5.addVariable("bool2", true, time9);
		assertFalse(dModel5.analyze(task4));// test faild - bool2 is false just before [ |c] -> bool2 ? c is not valid
	}

	@Test
	public void testExportImportCSV() throws IOException{
		String timeInMilli = String.valueOf(
				Calendar.getInstance().getTimeInMillis());

		String fileName = timeInMilli + ".csv";
		dModel.export2CSV(fileName);

		File testFile = new File(fileName);
		assertTrue(testFile.exists());

		int numLines = 0;

		BufferedReader in = new BufferedReader(new FileReader(testFile));
		String line;

		while ((line = in.readLine()) != null) {
			numLines++;
			assertTrue(line.split(",").length == DataObject.Label.size());
		}
		in.close();
		
		assertTrue(numLines == 2);
		
		dModel6.importFromCSV(fileName);
		assertTrue(dModel6.equals(dModel));
		testFile.deleteOnExit();
	}
	
	@Test
	public void testGetDataModelITask() {
		DataModel tDModel = dModel.getDataModel(task1);
		assertTrue(tDModel.analyze(task1));
	}
	
	@Test
	public void testGetDataModelSetOfITask() {
		Set<ITask> tasks = new HashSet<ITask>();
		tasks.add(task1);
		tasks.add(task2);
		dModel.addActivity(task2, taskTime1, "login", true);
		dModel.addActivity(task2, taskTime2, "logout", true);
		DataModel tDModel = dModel.getDataModel(tasks);
		assertTrue(tDModel.analyze(task2));
	}
}
