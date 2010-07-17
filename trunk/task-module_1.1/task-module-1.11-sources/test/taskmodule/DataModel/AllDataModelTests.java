package taskmodule.DataModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( {
	DataObjectTest.class,
	DataModelTest.class
})
public class AllDataModelTests {
}
