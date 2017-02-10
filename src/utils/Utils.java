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
	
	// Array extenders
	// TODO
	public static int[] append(int[] source, int... elements) {
		int[] ret = new int[source.length+elements.length];
		System.arraycopy(source, 0, ret, 0, source.length);
		System.arraycopy(elements, 0, ret, source.length, elements.length);
		return ret;
	}
	
	public static int[] subset(int[] source, int start, int finish) {
		int[] ret = new int[finish-start];
		System.arraycopy(source, start, ret, 0, ret.length);
		return ret;
	}
	
	public static int[] fromIndicies(int[] source, int... indicies) {
		int[] ret = new int[indicies.length];
		for(int i = 0; i < indicies.length; i++) {
			ret[i] = source[indicies[i]];
		}
		return ret;
	}
	
}
