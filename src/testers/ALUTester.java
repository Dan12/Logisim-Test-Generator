package testers;

import functions.ALUDefinition;
import functions.FunctionTester;
import special_vars.Const;
import special_vars.Iterate;
import special_vars.Iterate.Type;

public class ALUTester extends FunctionTester {
	
	public ALUTester() {
		super(
				"alu",
				new String[]{"A","B","Op","Sa", "C", "V"},
				new int[]{32, 32, 4, 5, 32, 1},
				4,
				ALUDefinition.ALUFunc
			);
	}
	
	@Override
	public String getTests() {
		newCase(0b0, 0b1, 0b0, 0b1);
		newCase(0b101001011, 0b1, 0b1, 0b10);
		
		newCase(
				new Const(0b10),
				new Const(0b110),
				new Iterate(Type.LINEAR),
				new Const(0b10)
				);
		
		return super.getTests();
	}

}
