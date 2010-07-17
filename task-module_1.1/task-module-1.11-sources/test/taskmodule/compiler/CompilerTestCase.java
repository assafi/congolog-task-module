package taskmodule.compiler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import taskmodule.ITaskModule;
import taskmodule.TaskModule;
import taskmodule.TaskModuleException;
import taskmodule.conglogcompiler.ConGlogCompiler;
import taskmodule.conglogcompiler.SemanticsErrorException;
import taskmodule.conglogcompiler.SyntaxErrorException;
import taskmodule.preconditions.bool.IPreCondition;
import taskmodule.task.Task;


public class CompilerTestCase {

	static final private String P1 = "Precondition-axioms(registration) = true ;\n"; 
	static final private String P2 = "Precondition-axioms(login_page) = (z = 3) ;\n";
	static final private String P3 = "Precondition-axioms(forget_password_page) = (x != 2 mod y + 8) ;\n";
	
	static final private String P4 = "Precondition-axioms forget_password_page) = (x != 2 mod y + 8) ;\n";
	static final private String P5 = "Precondition-axioms (forget_password_page) = x = true ;\n";
	
	static final private String L1 = 	"Label Signup : { registration; }\n";
	static final private String L2 = 	"Label Login: {\n" +
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
										"}";;
	static final private String L3 = 	"Label Signup : { \n" +
										"	Label Signup : { registration; }}\n";									
	static final private String L4 = 	"Label Login : { \n" +
										"	login_page;\n" +
										"}";

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
	}

	@After
	public void tearDown() throws Exception {
		this.compiler = null;
		taskModule.reset();
	}
	
	@Test
	public void testParseSimpleGoodPath() 
	throws SyntaxErrorException, SemanticsErrorException, TaskModuleException {
		taskModule.addActivitySupport("registration");
		taskModule.addActivitySupport("forget_password_page");
		taskModule.addVariableSupport("x", false);
		
		Task task = compiler.parse(P1 + P5 + L1);
		assertTrue(task.getPreconditions().size() == 2);
		assertTrue(task.getTaskLayout().containsNode("Signup"));
		assertTrue(task.containsPreCondition("registration"));
		
		/*
		 * This is an example on how to use the task object produced from 
		 * the compiler.
		 */
		IPreCondition condition = task.getPreconditions().get("registration");
		assertTrue((Boolean)condition.check());
	}

	@Test 
	public void testParseComplexGoodPath() 
	throws SyntaxErrorException, SemanticsErrorException, TaskModuleException {
		taskModule.addActivitySupport("login_page");
		taskModule.addActivitySupport("forget_password_page");
		taskModule.addActivitySupport("recovering_questions");
		taskModule.addActivitySupport("password_recovering_email");
		taskModule.addActivitySupport("login_info");
		taskModule.addActivitySupport("login_confirm");
		
		try {
			taskModule.addVariableSupport("z", 3);
			taskModule.addVariableSupport("x", 8);
			taskModule.addVariableSupport("y", 2);
		} catch (TaskModuleException e) {
			e.printStackTrace();
			fail();
		}
		
		Task task = compiler.parse(P2 + P3 + L2);
		assertTrue(task.getPreconditions().size() == 6);
		assertTrue(task.getTaskLayout().containsNode("Email_to_recover_password"));
		assertTrue(task.containsPreCondition("forget_password_page"));
		
		/*
		 * This is an example on how to use the task object produced from 
		 * the compiler.
		 */
		IPreCondition condition = task.getPreconditions().get("login_page");
		assertTrue((Boolean)condition.check());
		
		condition = task.getPreconditions().get("forget_password_page");
		assertFalse((Boolean)condition.check());
		
		/*
		 * Testing the default condition assignment
		 */
		condition = task.getPreconditions().get("login_confirm");
		assertTrue((Boolean)condition.check());		
	}
	
	@Test(expected=SyntaxErrorException.class)
	public void testSyntaxBadPath() throws SyntaxErrorException, SemanticsErrorException {
		
		compiler.parse(P4 + L1);
	}
	
	@Test(expected=SemanticsErrorException.class)
	public void testSemanticBadPath1() throws SyntaxErrorException, SemanticsErrorException {
		
		/*
		 * nothing in the activities set
		 */
		compiler.parse(P1 + L1);
	}
	
	@Test(expected=SemanticsErrorException.class)
	public void testSemanticBadPath2() throws SyntaxErrorException, SemanticsErrorException {
		taskModule.addActivitySupport("registration");
		
		/*
		 * doubly defined precondition
		 */
		compiler.parse(P1 + P2 + P3 + P1 + L1);
	}
	
	@Test(expected=SemanticsErrorException.class)
	public void testSemanticBadPath3() throws SyntaxErrorException, SemanticsErrorException {
		taskModule.addActivitySupport("registration");
		
		/*
		 * doubly defined label
		 */
		compiler.parse(P1 + L3);
	}
	
	@Test(expected=SemanticsErrorException.class)
	public void testSemanticBadPath4() throws SyntaxErrorException, SemanticsErrorException {
		taskModule.addActivitySupport("login_page");

		/*
		 * unsupported variable
		 */
		compiler.parse(P2 + L4);
	}
}
