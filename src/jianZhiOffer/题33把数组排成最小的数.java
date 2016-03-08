package jianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3, 32, 321}
 * 则打印出这3个数字能排成的最小数字
 */
public class 题33把数组排成最小的数 {
	public static void main(String[] args) {
//		int[] data = {9, 7, 5, 3, 1, 2, 4, 6, 8};
//		int[] data = {59, 57, 55, 53, 51, 52, 54, 56, 58};
		int[] data = {3208, 320, 3200, 3201};
		quickSort(data, 0, data.length-1);
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < data.length; i ++) {
			st.append(data[i]);
		}
		System.out.println(st.toString());
		Arrays.sort(data);
		for (int i = 0; i < data.length; i ++) {
			System.out.printf("%d ",data[i]);
		}
		System.out.println();
	}
	static void quickSort (int[] data, int beginIndex, int endIndex) {
		if (data == null || beginIndex > endIndex)   return;
		int pivot = partition(data, beginIndex, endIndex);
		quickSort(data, beginIndex, pivot-1);
		quickSort(data, pivot+1, endIndex);
	}
	static int partition (int[] data, int beginIndex, int endIndex) {
		int pivotData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex<endIndex && compare(pivotData,data[endIndex]))   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex<endIndex && compare(data[beginIndex],pivotData)) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = pivotData;
		return beginIndex;
	}
	static boolean compare (int data1, int data2) {
		String str1 = String.valueOf(data1)+String.valueOf(data2);
		String str2 = String.valueOf(data2)+String.valueOf(data1);
		return str1.compareTo(str2) <= 0;
 	}
}
