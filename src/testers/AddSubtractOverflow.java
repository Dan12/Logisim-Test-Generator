package testers;

import functions.FunctionDefinitions;
import functions.FunctionTester;

public class AddSubtractOverflow extends FunctionTester {
	
	// you have to create a new class in main to run the tests
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
				// The function to use
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
