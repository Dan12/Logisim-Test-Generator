package special_vars;

import utils.Utils;

public class Iterate implements SpecialVariable {
	Type type;
	long max;
	
	long current;
	
	public Iterate(Type type) {
		this.type = type;
		
		this.reset();
	}
	
	@Override
	public void setSize(int size) {
		this.max = Utils.maxUnsigned(size);
	}
	
	public boolean hasNext() {
		return this.current <= this.max;
	}
	
	public void reset() {
		if(this.type == Type.EXP_TAIL) {
			this.current = 2;
		} else {
			this.current = 0;
		}
	}
	
	public void updateValue() {
		if(this.type == Type.LINEAR) {
			this.current++;
		} else {
			if(this.current == 0) {
				this.current = 1;
			} else {
				this.current *= 2;
			}
		}
	}
	
	@Override
	public int getValue() {
		if(this.type == Type.EXP_TAIL) {
			return (int) (this.current-1);
		}
		return (int) this.current;
	}
	
	public enum Type {
		LINEAR, EXP_HEAD, EXP_TAIL
	}

}
