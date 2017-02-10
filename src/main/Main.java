package main;

import functions.AddSubtractOverflow;
import functions.LeftShift;

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
