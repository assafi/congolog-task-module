package taskmodule;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import taskmodule.Acceptance.AllTMAcceptanceTests;
import taskmodule.DataModel.AllDataModelTests;
import taskmodule.compiler.AllCompilerTests;
import taskmodule.experiment.AllExperimentTests;
import taskmodule.task.AllTaskTests;


@RunWith(Suite.class)
@SuiteClasses( { 
	AllCompilerTests.class,
	AllTaskTests.class,
	AllExperimentTests.class,
	AllDataModelTests.class,
	AllExperimentTests.class,
	AllTMAcceptanceTests.class
})
public class AllTasksModuleTests {

}
