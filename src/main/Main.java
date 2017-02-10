package main;

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
	}

}
