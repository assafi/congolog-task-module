/**
 * 
 */
package taskmodule.preconditions.bool;

/**
 * @author Assaf
 *
 */
public class BoolPreCondition implements IBoolPreCondition {

	private static final long serialVersionUID = -675853637196399946L;
	
	private boolean value;
	
	@Override
	public Object check() {
		return value;
	}

	public BoolPreCondition(boolean value) {
		this.value = value;
	}
}
