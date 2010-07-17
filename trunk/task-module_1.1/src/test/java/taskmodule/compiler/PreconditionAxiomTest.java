/**
 * 
 */
package taskmodule.compiler;

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
import taskmodule.task.Task;



/**
 * @author Assaf
 *
 */
public class PreconditionAxiomTest {

	static private String stmtSection = "\nLabel A : { registration; }";
	
	static private ITaskModule taskModule = TaskModule.getInstance();
	
	static private ConGlogCompiler compiler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		taskModule.addActivitySupport("registration");
		taskModule.addActivitySupport("login");
		taskModule.addActivitySupport("session");
		taskModule.addActivitySupport("training_program");
		taskModule.addVariableSupport("x", 10); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		taskModule.reset();
	}

	@Before
	public void setUp() throws Exception {
		compiler = new ConGlogCompiler();
	}

	@After
	public void tearDown() throws Exception {
		compiler = null;
	}
	
	@Test
	public void SimpleBooleanTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = true ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleOrBooleanTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = true || false ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleAndBooleanTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = true && false ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertFalse((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleNotBooleanTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = not false ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleEqIntegerTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = (3 = 3) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleNeqIntegerTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = (3 != 3) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertFalse((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test
	public void SimpleRelationIntegerTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = (3 > 3) ;" +
						"Precondition-axioms(login) = (3 >= 3) ;" +
						"Precondition-axioms(session) = (3 < 4) ;" +
						"Precondition-axioms(training_program) = (3 <= 2) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 4);
		Assert.assertFalse((Boolean)task.getPreconditions().get("registration").check());
		Assert.assertTrue((Boolean)task.getPreconditions().get("login").check());
		Assert.assertTrue((Boolean)task.getPreconditions().get("session").check());
		Assert.assertFalse((Boolean)task.getPreconditions().get("training_program").check());
	}
	
	@Test
	public void SimpleAddMulDevMinModIntegerTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = (3 - 2 > 3) ;" +
						"Precondition-axioms(login) = (3 * 5 >= 3) ;" +
						"Precondition-axioms(session) = (3 * -1 < 4) ;" +
						"Precondition-axioms(training_program) = (3 <= 2 / 2) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 4);
		Assert.assertFalse((Boolean)task.getPreconditions().get("registration").check());
		Assert.assertTrue((Boolean)task.getPreconditions().get("login").check());
		Assert.assertTrue((Boolean)task.getPreconditions().get("session").check());
		Assert.assertFalse((Boolean)task.getPreconditions().get("training_program").check());
	}
	
	@Test
	public void SimpleVarIntegerTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException {
		String paLine = "Precondition-axioms(registration) = (x > 3) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
		taskModule.varChanged("x", 1);
		Assert.assertFalse((Boolean)task.getPreconditions().get("registration").check());
	}
	
	@Test(expected=SemanticsErrorException.class)
	public void BoolIntVarMixTest() 
	throws TaskModuleException, SyntaxErrorException, SemanticsErrorException{
		String paLine = "Precondition-axioms(registration) = (x = true) ;";
		Task task = compiler.parse(paLine + stmtSection);
		Assert.assertTrue(task.getPreconditions().size() == 1);
		Assert.assertTrue((Boolean)task.getPreconditions().get("registration").check());
	}
}
