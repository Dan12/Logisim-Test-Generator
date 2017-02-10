package testers;

import functions.FunctionDefinitions;
import functions.FunctionTester;
import special_vars.Const;
import special_vars.Iterate;
import special_vars.Iterate.Type;

public class LeftShift extends FunctionTester {
	
	public LeftShift() {
		super(
				"left_shift",
				new String[]{"B","Sa","Cin","C"},
				new int[]{32, 5, 1, 32},
				3,
				FunctionDefinitions.LeftShift
			);
	}

	@Override
	public String getTests() {
		newCase(0b1101101, 0b0, 0b0);
		newCase(0b1101101, 0b1, 0b0);
		newCase(0b1101101, 0b1, 0b1);
		newCase(0b1101101, 0b0, 0b1);
		newCase(0b1101101, 0b10, 0b0);
		newCase(0b1101101, 0b11, 0b0);
		newCase(0b1101101, 0b100, 0b1);
		newCase(0b1101101, 0b101, 0b1);
		newCase(0b1101101, 0b1000, 0b0);
		newCase(0b1101101, 0b10001, 0b0);
		newCase(0b1101101, 0b10110, 0b1);
		newCase(0b1101101, 0b01101, 0b1);
		newCase(0b10010101, 0b1011, 0b1);
		
		newCase(
				new Const(0b10011110101),
				new Iterate(Type.EXP_HEAD),
				new Iterate(Type.LINEAR)
			);
		
		randomCases(1000);
		
		return super.getTests();
	}
}
