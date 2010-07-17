package taskmodule.DataModel;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.datamodel.DataObject;
import taskmodule.task.ITask;
import taskmodule.task.Task;

public class DataObjectTest {

	static private DataObject dobj = null;
	static private ITask task = null;
	static private Timestamp taskTime = null;
	static private ITaskModule taskModule = TaskModule.getInstance();
	static private final String taskDesc = "Precondition-axioms(login) = true;\n " +
									"Label a:{login;}\n"; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		taskModule.addActivitySupport("login");
		taskTime = new Timestamp(new Date().getTime());
		ConGlogCompiler compiler = new ConGlogCompiler();
		try{
		task = compiler.parse(taskDesc);
		task.setName("t1");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		dobj = new DataObject((Task)task, "login", true, taskTime);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTask() {
		assertTrue(dobj.getTaskName().equals(((Task)task).getName()));
	}

	@Test
	public void testIsPreconditionsMet() {
		assertTrue(dobj.isPreconditionsMet());
	}

	@Test
	public void testGetActivity() {
		assertTrue(dobj.getActivity().equals("login"));
	}

	@Test
	public void testGetTimestamp() {
		assertTrue(dobj.getTimestamp().equals(taskTime));
	}

	@Test
	public void testGetData() {
		Map<String, String> dataMapping = dobj.getData(); 
		assertNotNull(dataMapping);
		assertTrue(dataMapping.size() == DataObject.Label.size());
		assertTrue("login".equals(dataMapping.get(DataObject.Label.Activity.name())));
	}
}
