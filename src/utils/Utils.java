package utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import functions.FunctionTester;

public class Utils {
	private static Random rand = new Random();
	private static String FILE_NAME = "test_vector.txt";
	
	public static long maxUnsigned(int bitLength) {
		return (long) (Math.pow(2, bitLength) - 1);
	}
	
	public static void randomTests(FunctionTester func, int num){
		for(int i = 0; i < num; i++) {
			int[] inputs = new int[func.getIOPair().inputSize];
			for(int j = 0; j < inputs.length; j++) {
				inputs[j] = randInt(maxUnsigned(func.getIOPair().labelSizes[j]));
			}
			func.newCase(inputs);
		}
	}
	
	public static int randInt(long max) {
		return (int) ((long) (rand.nextDouble()*(max+1)));
	}
	
	public static String makeTestCase(IOPair ioPair) {
		String ret = "";
		for(int i = 0; i < ioPair.inputs.length; i++) {
			ret += ioPair.inputs[i] + " ";
		}
		for(int i = 0; i < ioPair.outputs.length; i++) {
			ret += ioPair.outputs[i] + " ";
		}
		return ret.substring(0, ret.length()-1)+"\n";
	}
	
	public static void writeToFile(FunctionTester func) {
		try{
		    PrintWriter writer = new PrintWriter(func.getName() + "_" + Utils.FILE_NAME, "UTF-8");
		    writer.println(func.getTests());
		    writer.close();
		} catch (IOException e) {
		   System.out.println("Write error");
		}
	}
	
	public static String makeHeader(IOPair ioPair) {
		String ret = "";
		for(int i = 0; i < ioPair.labelNames.length; i++) {
		    ret += ioPair.labelNames[i];
		    if(ioPair.labelSizes[i] > 1) {
		      ret += "["+ioPair.labelSizes[i]+"]";
		    }
			if(i < ioPair.labelSizes.length - 1)
				ret += " ";
		}
		return ret+"\n";
	}
}
