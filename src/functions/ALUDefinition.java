package functions;

import utils.InOutFunction;
import utils.Utils;

public class ALUDefinition {

	// [A, B, op, Sa] -> [C, V]
	public static InOutFunction ALUFunc = (int[] inputs) -> {
		int op = inputs[2];
		if(op == 0 || op == 1) {
			// left shift logical
			int[] ipts = Utils.append(Utils.fromIndicies(inputs, 1, 3), 0);
			return Utils.append(FunctionDefinitions.LeftShift.operation(ipts), 0);
		} else if(op == 2 || op == 3) {
			// add
			int[] ipts = Utils.append(Utils.fromIndicies(inputs, 0, 1), 0);
			return FunctionDefinitions.AddSubV.operation(ipts);
		} else if(op == 4) {
			// right shift logic
			int[] ipts = Utils.append(Utils.fromIndicies(inputs, 1, 3), 0);
			return Utils.append(FunctionDefinitions.RightShift.operation(ipts), 0);
		} else if(op == 5) {
			// right shift arth
			int[] ipts = Utils.append(Utils.fromIndicies(inputs, 1, 3), 0);
			return Utils.append(FunctionDefinitions.RightShiftArth.operation(ipts), 0);
		} else if(op == 6 || op == 7) {
			// subtract
			int[] ipts = Utils.append(Utils.fromIndicies(inputs, 0, 1), 1);
			return FunctionDefinitions.AddSubV.operation(ipts);
		} else if(op == 8) {
			// and
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.AND.operation(ipts), 0);
		} else if(op == 9) {
			// neq
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.NEQ.operation(ipts), 0);
		} else if(op == 10) {
			// or
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.OR.operation(ipts), 0);
		} else if(op == 11) {
			// eq
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.EQ.operation(ipts), 0);
		} else if(op == 12) {
			// xor
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.XOR.operation(ipts), 0);
		} else if(op == 13) {
			// le
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.LE.operation(ipts), 0);
		} else if(op == 14) {
			// nor
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.NOR.operation(ipts), 0);
		} else if(op == 15) {
			// gt
			int[] ipts = Utils.fromIndicies(inputs, 0, 1);
			return Utils.append(FunctionDefinitions.GT.operation(ipts), 0);
		}
		return null;
	};
}
