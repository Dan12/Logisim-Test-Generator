package main;

import testers.ALUTester;
import testers.AddSubtractOverflow;
import testers.LeftShift;

public class Main {	
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.runMethod();
	}
	
	public void runMethod() {
		new LeftShift();
		new AddSubtractOverflow();
		new ALUTester();
	}

}
