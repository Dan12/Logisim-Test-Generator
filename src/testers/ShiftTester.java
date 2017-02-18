package testers;

import functions.FunctionDefinitions;
import functions.FunctionTester;
import special_vars.Const;
import special_vars.Iterate;
import special_vars.Iterate.Type;
import special_vars.Rand;

public class ShiftTester extends FunctionTester {
	public ShiftTester() {
		super(
				"shifter",
				new String[]{"B", "Sa", "Cin", "Rs", "C"},
				new int[]{32, 5, 1, 1, 32},
				4,
				FunctionDefinitions.RightShift
			);
	}
	
	@Override
	public String getTests() {
		newCase(
				new Iterate(Type.EXP_HEAD),
				new Rand(),
				new Const(0),
				new Const(1)
			);
		
		newCase(
				new Const(-124124),
				new Iterate(Type.LINEAR),
				new Const(0),
				new Const(1)
			);
		
		return super.getTests();
	}
}
