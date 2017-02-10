package special_vars;

import utils.Utils;

public class Rand implements SpecialVariable {
	
	long max;
	
	@Override
	public void setSize(int size) {
		this.max = Utils.maxUnsigned(size);
	}
	
	@Override
	public int getValue() {
		return Utils.randInt(this.max);
	}
}
