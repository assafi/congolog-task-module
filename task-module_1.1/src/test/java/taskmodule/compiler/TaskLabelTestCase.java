package taskmodule.compiler;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JTree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.conglogcompiler.SemanticsErrorException;
import taskmodule.conglogcompiler.SyntaxErrorException;
import taskmodule.task.ITask;
import taskmodule.task.Task;
import taskmodule.task.TaskDriver;


public class TaskLabelTestCase {

	static final private String HEADER = "Precondition-axioms(registration) = true ;\n"; 
	
	static private ITaskModule taskModule = TaskModule.getInstance();
	
	private ConGlogCompiler compiler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.compiler = new ConGlogCompiler();
		taskModule.addActivitySupport("registration");
		taskModule.addActivitySupport("login_page");
		taskModule.addActivitySupport("forget_password_page");
		taskModule.addActivitySupport("recovering_questions");
		taskModule.addActivitySupport("password_recovering_email");
		taskModule.addActivitySupport("login_info");
		taskModule.addActivitySupport("login_confirm");
	}

	@After
	public void tearDown() throws Exception {
		this.compiler = null;
		taskModule.reset();
	}
	
	@Test
	public void simpleLabelTest() 
	throws SyntaxErrorException, SemanticsErrorException {
		String paLine = HEADER + "Label signup : { registration; } ";
		Task task = compiler.parse(paLine);
		Assert.assertTrue(task.getTaskLayout().containsNode("signup"));
		Assert.assertTrue(task.getTaskLayout().containsNode("registration"));
	}

	@Test
	public void complexLabelTest() throws 
	SyntaxErrorException, SemanticsErrorException {
		String conglogExpr = HEADER + 
			"Label Login: {\n" +
			"	Label Go_to_login_page: {\n" +
			"		login_page;\n" +
			"	}\n" +
			"	Label Forget_password: {\n" +
			"		Label Go_to_forget_password_page: {\n" +
			"			forget_password_page;\n" +
			"		}\n" +
			"		Label Recovering_Questions: {\n" +
			"			recovering_questions;\n" +
			"		}\n" +
			"		Label Email_to_recover_password: {\n" +
			"			password_recovering_email;\n" +
			"		}\n" +
			"	}\n" +
			"	Label Entering_login_info: {\n" +
			"		login_info;\n" +
			"		Go_to_login_page;\n" +		
			"	}\n" +
			"	Label Confirm_login: {\n" +
			"		login_confirm;\n" +
			"	}\n" +
			"}";
		Task task = compiler.parse(conglogExpr);
		Assert.assertTrue(task.getTaskLayout().containsNode("Email_to_recover_password"));
		Assert.assertTrue(task.getTaskLayout().containsNode("login_info"));
		System.out.println("Tested input");
		System.out.println("------------");
		System.out.println();
		System.out.println(conglogExpr);
		System.out.println();
		System.out.println("Compiler returned structure");
		System.out.println("---------------------------");
		System.out.println();
		System.out.println(task.getTaskLayout());
		System.out.println();
	}
	
	@Test
	public void tempT() throws TaskModuleException, SyntaxErrorException, SemanticsErrorException{
		String script = "Precondition-axioms(activity_1) = true ;\n"+
						 "Precondition-axioms(activity_2) = x < 3 ;\n"+
						 "Precondition-axioms(activity_3) = ((x + y) mod (y / 5)) > 3 ;\n"+
						 "Label A : {\n"+
						 	"Label B : {\n"+
						 		"Label C : {\n"+
						 			"activity_1;\n"+
						 			"activity_2;\n"+
								"}\n"+
								"Label D : {\n"+
									"activity_3;\n"+
								"}\n"+
								"C;\n"+
							"}\n"+
							"B;\n"+
						"}";	
		taskModule.addActivitySupport("activity_1");
		taskModule.addActivitySupport("activity_2");
		taskModule.addActivitySupport("activity_3");
		taskModule.addVariableSupport("x", 4);
		taskModule.addVariableSupport("y", 4);
		
		ITask task = taskModule.compileConGlog("my task", script);
		JTree description = task.getDescription();
        assertNotNull(description);
        TaskDriver.testFlight(description);
	}
	
    /*
     * Test or operator.
     */
    @Test
    public void testOrOperator() throws Exception {
    	String script = "Label A : {\n" +
    					"			Label B : { \n" +
    					"				[ activity_1 ] " +
    					"			}"	+		
    					"			activity_2; \n" +
    					"			[ B | activity_3 ]\n" +
    					"}";
    	taskModule.addActivitySupport("activity_1");
		taskModule.addActivitySupport("activity_2");
		taskModule.addActivitySupport("activity_3");
		ITask task = taskModule.compileConGlog("my task", script);
		JTree description = task.getDescription();
        assertNotNull(description);
        TaskDriver.testFlight(description);
    }
    
    /*
     * Test ? operator.
     */
    @Test
    public void testDynamicOperator() throws Exception {
    	String script = "Label A : {\n" +
    					"			[ bool1 ? activity_1 ] " +
    					"			activity_1; \n" +
    					"			[ activity_1 | bool2 ? activity_2 ]\n" +
    					"}";
    	taskModule.addActivitySupport("activity_1");
		taskModule.addActivitySupport("activity_2");
		taskModule.addVariableSupport("bool1", true);
		taskModule.addVariableSupport("bool2", true);
		Task task = (Task)taskModule.compileConGlog("my task", script);
		JTree description = task.getDescription();
        assertNotNull(description);
        TaskDriver.testFlight(description);
        assertTrue(task.getDynamicConditions().containsKey(task.getTaskLayout().getSubTree("activity_2")));
    }
    
    /*
     * Test ? operator.
     */
    @Test (expected=SemanticsErrorException.class)
    public void testDynamicOperatorError() throws Exception {
    	String script = "Label A : {\n" +
    					"			[ bool1 ? activity_1 ] " +
    					"			activity_1; \n" +
    					"			[ activity_1 | bool2 ? activity_2 ]\n" +
    					"}";
    	taskModule.addActivitySupport("activity_1");
//		taskModule.addActivitySupport("activity_2");	Didn't defined activity_2. should throw SemanticException
		taskModule.addVariableSupport("bool1", true);
		taskModule.addVariableSupport("bool2", true);	
		taskModule.compileConGlog("my task", script);
    }
}
