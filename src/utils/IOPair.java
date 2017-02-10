package utils;

public class IOPair {
	String[] labelNames;
	int[] labelSizes;
	
	int inputSize;
	public int[] inputs;
	public int[] outputs;
	
	public IOPair(String[] names, int[] sizes, int inputSize) {
		this.labelNames = names;
		this.labelSizes = sizes;
		this.inputSize = inputSize;

		if(this.labelNames.length != this.labelSizes.length || this.inputSize > this.labelNames.length) {
			throw new Error("Incompatible variables");
		}
		
		this.inputs = new int[this.inputSize];
		this.outputs = new int[this.labelNames.length-this.inputSize];
	}
	
	public void setInputs(int... inputs) {
		if(inputs.length == this.inputs.length) {
			this.inputs = inputs;
		} else {
			throw new Error("Inputs is not the right length");
		}
	}
	
	public int getSize(int i) {
		return this.labelSizes[i];
	}
	
	public void setOutputs(int... outputs) {
		if(outputs.length == this.outputs.length) {
			this.outputs = outputs;
		} else {
			throw new Error("Outputs is not the right length");
		}
	}
}
