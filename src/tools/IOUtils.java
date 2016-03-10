package tools;
/*
 * 这是自己写的一个用于读入输出的东东
 */
public class IOUtils <T>{
	public static void printAnNumber (int data) {
		System.out.println(data);
	}
	public static <T> void printAnObject (T data) {
		System.out.println(data.toString());
	}
	public static <T> void printAnArrayTenALine (T[] data, int beginIndex, int endIndex) {
		int times = (endIndex-beginIndex)/10+1;
		int timesIndex = 0;
		for (timesIndex = 0; timesIndex < times-1; timesIndex ++){
			printAnArray(data, beginIndex+timesIndex*10, beginIndex+timesIndex*10+9);
		}
		printAnArray(data, beginIndex+timesIndex*10, endIndex);
	}
	public static <T> void printAnArray (T[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static <T> void printAnArray (T[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex].toString());
		}
		System.out.println();
	}
	public static void printAnArray (short[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (short[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.printf("%d\t", data[dataIndex]);
		}
		System.out.println(data[endIndex]);
	}
	public static void printAnArray (char[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (char[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void printAnArray (int[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (int[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void printAnArray (double[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (double[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void printAnLongString (String str) {
		int times = str.length()/20+1;
		int timesIndex;
		for (timesIndex = 0; timesIndex < times-1; timesIndex ++) {
			System.out.println(str.substring(timesIndex*20, timesIndex*20+19));
		}
		System.out.println(str.substring(timesIndex*20, str.length()-1));
	}
}
