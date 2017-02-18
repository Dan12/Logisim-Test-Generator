package testers;

import functions.ALUDefinition;
import functions.FunctionTester;
import special_vars.Iterate;
import special_vars.Iterate.Type;
import special_vars.Rand;

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
		newComment("The first thousand test cases test every opcode on every 2^x and 2^x-1 value for A and B");
		newComment("The rest are random but designed to hit every opcode 100 times");
		newComment("");
		newComment("test every single op code on A's head inputs");
		newCase(
				new Iterate(Type.EXP_HEAD),
				new Rand(),
				new Iterate(Type.LINEAR),
				new Rand()
			);
		
		newComment("test every single op code on A's tail inputs");
		newCase(
				new Iterate(Type.EXP_TAIL),
				new Rand(),
				new Iterate(Type.LINEAR),
				new Rand()
			);
		
		newComment("test every single op code on B's head inputs");
		newCase(
				new Rand(),
				new Iterate(Type.EXP_HEAD),
				new Iterate(Type.LINEAR),
				new Rand()
			);
		
		newComment("test every single op code on B's tail inputs");
		newCase(
				new Rand(),
				new Iterate(Type.EXP_TAIL),
				new Iterate(Type.LINEAR),
				new Rand()
			);
		
		newComment("test every single possible op code on random inputs 100 times");
		for(int i = 0; i < 100; i++) {
			newCase(
					new Rand(),
					new Rand(),
					new Iterate(Type.LINEAR),
					new Rand()
				);
		}
		
		newComment("1000 random tests");
		randomCases(1000);
		
		return super.getTests();
	}

}
