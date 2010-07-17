/**
 * 
 */
package taskmodule.preconditions.bool;

/**
 * @author Assaf
 *
 */
public class BoolPreCondition implements IBoolPreCondition {

	private boolean value;
	
	@Override
	public Object check() {
		return value;
	}

	public BoolPreCondition(boolean value) {
		this.value = value;
	}
}
