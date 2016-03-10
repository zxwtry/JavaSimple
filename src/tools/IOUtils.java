package tools;
/*
 * 这是自己写的一个用于读入输出的东东
 */
public class IOUtils <T>{
	public static <T> void printAnArrayTenALine (T[] data, int beginIndex, int endIndex) {
		int times = (endIndex-beginIndex)/10+1;
		for (int timesIndex = 0; timesIndex < times; timesIndex ++){
			
		}
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
	public static <T> void printAnArray (int[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static <T> void printAnArray (int[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println();
	}
	public static <T> void printAnArray (double[] data) {
		printAnArray(data, 0, data.length-1);
	}
	public static <T> void printAnArray (double[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println();
	}
}
