package functions;

import java.util.ArrayList;

import special_vars.Iterate;
import special_vars.SpecialVariable;
import utils.IOPair;
import utils.InOutFunction;
import utils.Utils;

public abstract class FunctionTester {
	
	private IOPair ioPair;
	private InOutFunction func;
	private String name;
	private StringBuilder testBuilder;
	
	public FunctionTester(String name, String[] labelNames, int[] labelSize, int inputSize, InOutFunction func) {
		this.name = name;
		
		this.ioPair = new IOPair(labelNames, labelSize, inputSize);
		
		this.func = func;
		
		this.testBuilder = new StringBuilder();
		this.testBuilder.append(Utils.makeHeader(ioPair));
		
		Utils.writeToFile(this);
	}

	void apply() {
		this.ioPair.setOutputs(this.func.operation(this.ioPair.inputs));
	}
	
	public String getName() {
		return this.name;
	}
	
	public IOPair getIOPair() {
		return this.ioPair;
	}
	
	public String getTests() {
		return this.testBuilder.toString();
	}
	
	public void randomCases(int num) {
		Utils.randomTests(this, num);
	}
	
	public void newCase(int... inputs) {
		this.getIOPair().setInputs(inputs);
		this.apply();
		this.testBuilder.append(Utils.makeTestCase(this.getIOPair()));
	}
	
	// only meant for one or more variables to be iterable
	public void newCase(SpecialVariable... vars) {
		ArrayList<Iterate> iterateOn = new ArrayList<Iterate>();
		for(int i = 0; i < vars.length; i++) {
			vars[i].setSize(this.getIOPair().getSize(i));
			if(vars[i] instanceof Iterate) {
				iterateOn.add((Iterate) vars[i]);
			}
		}
		if(iterateOn.size() == 0) {
			throw new Error("nothing to iterate on");
		}
		
		while(iterateOn.get(iterateOn.size() - 1).hasNext()) {
			int[] inputs = new int[vars.length];
			for(int i = 0; i < inputs.length; i++) {
				inputs[i] = vars[i].getValue();
			}
			newCase(inputs);
			
			iterateOn.get(0).updateValue();
			for(int i = 0; i < iterateOn.size() - 1; i++) {
				if(!iterateOn.get(i).hasNext()) {
					iterateOn.get(i).reset();
					iterateOn.get(i+1).updateValue();
				}
			}
		}
	}
}
