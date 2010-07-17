package taskmodule.compiler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { 
	PreconditionAxiomTest.class,
	TaskLabelTestCase.class,
	CompilerTestCase.class
})
public class AllCompilerTests {

}

