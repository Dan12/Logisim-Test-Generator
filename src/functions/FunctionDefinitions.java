package functions;

import utils.InOutFunction;

public class FunctionDefinitions {
	
	// [A, B, Cin] -> [Sum, V]
		public static InOutFunction Add = (int[] inputs) -> {
			int a = inputs[0];
			int b = inputs[1];
			int cin = inputs[2];
			int sum = a + b + cin;
			int v = ((a >= 0 && b >= 0 && sum < 0) || (a < 0 && b < 0 && sum >= 0) ? 1 : 0);
			
			return new int[]{sum, v};
		};

	// Add Subtract function definition:
	// [A, B, Subtract] -> [result, v]
	public static InOutFunction AddSubV = (int[] inputs) -> {
		int result;
		int v;
		int a = inputs[0];
		int b = inputs[1];
		if(inputs[2] == 0) {
			result = a + b;
			v = ((a>= 0 && b >= 0 && result < 0) || (a < 0 && b < 0 && result >= 0) ? 1 : 0);
		} else {
			result = a - b;
			v = ((a>= 0 && b < 0 && result < 0) || (a < 0 && b >= 0 && result >= 0) ? 1 : 0);
		}
		
		return new int[]{result, v};
	};
	
	// [B, Sa, Cin] -> [result]
	public static InOutFunction LeftShift = (int[] inputs) -> {
		int result = inputs[0] << inputs[1];
		
		result |= (int) (inputs[2] == 1 ? (Math.pow(2,inputs[1]) - 1) : 0);
		
		return new int[]{result};
	};
	
	// [B, Sa, Cin] -> [result]
	public static InOutFunction RightShift = (int[] inputs) -> {
		int result = inputs[0] >>> inputs[1];
		
		result |= (int) (inputs[2] == 1 ? (Math.pow(2,32-inputs[1]) - 1) : 0);
		
		return new int[]{result};
	};
	
	// [B, Sa] -> [result]
	public static InOutFunction RightShiftArth = (int[] inputs) -> {
		return new int[]{inputs[0] >> inputs[1]};
	};
	
	// [A, B] -> [result]
	public static InOutFunction OR = (int[] inputs) -> { return new int[]{inputs[0] | inputs[1]}; };
	
	// [A, B] -> [result]
	public static InOutFunction AND = (int[] inputs) -> { return new int[]{inputs[0] & inputs[1]}; };
	
	// [A, B] -> [result]
	public static InOutFunction XOR = (int[] inputs) -> { return new int[]{inputs[0] ^ inputs[1]}; };
	
	// [A, B] -> [result]
	public static InOutFunction NOR = (int[] inputs) -> { return new int[]{~(inputs[0] | inputs[1])}; };
	
	// [A, B] -> [result]
	public static InOutFunction EQ = (int[] inputs) -> { return new int[]{(inputs[0] == inputs[1] ? 1 : 0)}; };

	// [A, B] -> [result]
	public static InOutFunction NEQ = (int[] inputs) -> { return new int[]{(inputs[0] != inputs[1] ? 1 : 0)}; };
	
	// [A] -> [result]
	public static InOutFunction GT = (int[] inputs) -> { return new int[]{(inputs[0] > 0 ? 1 : 0)}; };
	
	// [A] -> [result]
	public static InOutFunction LE = (int[] inputs) -> { return new int[]{(inputs[0] <= 0 ? 1 : 0)}; };
}
