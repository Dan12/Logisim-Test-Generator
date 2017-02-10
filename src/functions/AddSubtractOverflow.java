package functions;

public class AddSubtractOverflow extends FunctionTester {
	
	public AddSubtractOverflow() {
		super(
				// Test vector name
				"add_subtract",
				
				// Circuit inputs and outputs
				// Important: inputs must come before outputs
				new String[]{"a","b","subtract","C", "V"},
				
				// Circuit variable sizes
				new int[]{32, 32, 1, 32, 1},
				
				// number of inputs
				3,
				FunctionDefinitions.AddSubV
			);
	}
	
	@Override
	public String getTests() {
		// Put all test cases here
		randomCases(1000);
		
		return super.getTests();
	}

}
