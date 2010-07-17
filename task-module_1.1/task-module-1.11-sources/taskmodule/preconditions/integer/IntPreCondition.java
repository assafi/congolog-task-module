/**
 * 
 */
package taskmodule.preconditions.integer;

/**
 * @author Assaf
 *
 */
public class IntPreCondition implements IIntPreCondition {

	private int value;
	
	@Override
	public Object check() {
		return value;
	}
	public IntPreCondition(int value) {
		this.value = value;
	}
}
