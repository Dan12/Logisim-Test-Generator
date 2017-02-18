package testers;

import functions.FunctionDefinitions;
import functions.FunctionTester;
import special_vars.Iterate;
import special_vars.Iterate.Type;

public class AddTester extends FunctionTester {
	
	public AddTester() {
		super(
				"add",
				new String[]{"A","B","Cin","C", "V"},
				new int[]{32, 32, 1, 32, 1},
				3,
				FunctionDefinitions.Add
			);
	}
	
	@Override
	public String getTests() {
		newComment("The first thousand test cases iterate over all 2^x and 2^x-1 values of A and B");
		newComment("The rest are random.");
		newCase(new Iterate(Type.EXP_HEAD), new Iterate(Type.EXP_TAIL), new Iterate(Type.LINEAR));
		newCase(new Iterate(Type.EXP_TAIL), new Iterate(Type.EXP_TAIL), new Iterate(Type.LINEAR));
		randomCases(2000);
		return super.getTests();
	}
}
