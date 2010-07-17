/**
 * 
 */
package taskmodule.conglogcompiler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Assaf
 *
 */
public class CompilerErrorReporter implements ICompilerErrorReporter {

	private List<String> errors = new ArrayList<String>();
	
	@Override
	public String errorReport() {
		
		if (!hadErrors()) {
			return "Compilation successful";
		}
		String report = "Compilation encountered the following errors: \n" +
						"--------------------------------------------\n";
		
		for (String error : errors) {
			report += "*) " + error + "\n";
		}
		return report;
	}

	@Override
	public boolean hadErrors() {
		return !errors.isEmpty();
	}

	@Override
	public void reportError(String error) {
		errors.add(error);
	}

	@Override
	public void clean() {
		errors.clear();
	}
}
