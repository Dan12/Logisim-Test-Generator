package main;

import testers.ALUTester;
import testers.AddSubtractOverflow;
import testers.AddTester;
import testers.LeftShift;
import testers.ShiftTester;

public class Main {	
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.runMethod();
	}
	
	public void runMethod() {
		new LeftShift();
		new AddSubtractOverflow();
		new ALUTester();
		new ShiftTester();
		new AddTester();
	}

}
