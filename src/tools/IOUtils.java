package tools;
/*
 * 这是自己写的一个用于读入输出的东东
 */
public class IOUtils <T>{
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
			System.out.print(data[dataIndex].toString()+"\t");
		}
		System.out.println();
	}
	public static void printAnArray (int[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (int[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println();
	}
	public static void printAnArray (double[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static void printAnArray (double[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println();
	}
}
