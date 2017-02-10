package special_vars;

public class Const implements SpecialVariable {
	
	int value;

	public Const(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
	
	@Override
	public void setSize(int size) {
		// could do size assertion
	}

}
