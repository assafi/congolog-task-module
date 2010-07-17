/**
 * 
 */
package taskmodule.preconditions.integer;

/**
 * @author Assaf
 *
 */
public class IntPreCondition implements IIntPreCondition {

	private static final long serialVersionUID = 4972501920616082445L;
	
	private int value;
	
	@Override
	public Object check() {
		return value;
	}
	public IntPreCondition(int value) {
		this.value = value;
	}
}
