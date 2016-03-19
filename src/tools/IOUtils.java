package tools;

import java.util.Iterator;

/*
 * 这是自己写的一个用于读入输出的东东
 */
public class IOUtils {
	public static void print (int data) {
		System.out.println(data);
	}
	public static <T> void print (T data) {
		System.out.println(data.toString());
	}
	public static <T> void printLong (T[] data, int beginIndex, int endIndex) {
		int times = (endIndex-beginIndex)/10+1;
		int timesIndex = 0;
		for (timesIndex = 0; timesIndex < times-1; timesIndex ++){
			print(data, beginIndex+timesIndex*10, beginIndex+timesIndex*10+9);
		}
		print(data, beginIndex+timesIndex*10, endIndex);
	}
	public static <T> void print (T[] data) {
		print(data, 0, data.length-1);
	}
	public static <T> void print (T[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex <= endIndex; dataIndex ++) {
			System.out.print(data[dataIndex].toString());
		}
		System.out.println();
	}
	public static void print (short[] data) {
		print(data, 0, data.length-1);
	}
	public static void print (short[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.printf("%d\t", data[dataIndex]);
		}
		System.out.println(data[endIndex]);
	}
	public static void print (char[] data) {
		print(data, 0, data.length-1);
	}
	public static void print (char[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void print (int[] data) {
		print(data, 0, data.length-1);
	}
	public static void print (int[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void print (double[] data) {
		print(data, 0, data.length-1);
	}
	public static void print (double[] data, int beginIndex, int endIndex) {
		for (int dataIndex = beginIndex; dataIndex < endIndex; dataIndex ++) {
			System.out.print(data[dataIndex]+"\t");
		}
		System.out.println(data[endIndex]);
	}
	public static void printLong (String str) {
		int times = str.length()/20+1;
		int timesIndex;
		for (timesIndex = 0; timesIndex < times-1; timesIndex ++) {
			System.out.println(str.substring(timesIndex*20, timesIndex*20+20));
		}
		System.out.println(str.substring(timesIndex*20, str.length()));
	}
	public static <T> void print (Iterator<T> it) {
		while(it.hasNext()) {
			System.out.print(it.next().toString()+"\t");
		}
		System.out.println();
	}
}
