package taskmodule.conglogcompiler;

public interface ICompilerErrorReporter {
	
	public boolean hadErrors();
	
	public String errorReport();
	
	public void reportError(String error);

	public void clean();
}
