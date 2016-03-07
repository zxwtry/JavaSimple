/*
有1个人，要把n匹马从A村运往B村。

初始时，人和马都在A村。每次骑1匹马牵1匹马，回来时骑1匹马。

已知每匹马从A村到B村需要的时间（数字越大越慢）
两匹马同行时只能迁就较慢者。

求所有马匹都运到B村的最小的运输时间（此时，人和马都在B村）。

程序首先输入一个整数n(n<100)，表示有n匹马。

接着是n行整数，表示马从A村到B村的所用的分钟数（小于1000）
程序输出：1个整数，表示所有马匹均运到B村的最小总耗时。

例如，

输入：
3
1
2
4
程序应输出：
7

输入：
4
1
4
2
5
程序应该输出：
12
 */


package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 第五章最短路径_求最小值 {
	private static int minTime = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		if (num == 0) {
			System.out.println("error input");
			return;
		}
		int[] arr = new int[num];
		boolean[] isA = new boolean [num];
		Arrays.fill(isA, true);
		for (int i = 0; i < num; ++ i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		quickSort(arr, 0, arr.length-1);
//		for (int i = 0; i < num; ++ i) {
//			System.out.print(arr[i] + " ");
//		}
		if (num == 1) {
			System.out.println(arr[0]);
			return;
		} else if (num == 2) {
			System.out.println(Math.max(arr[0], arr[1]));
			return;
		}
		findMinTime(arr, 0, isA, true);
		System.out.println(minTime);
		br.close();
	}
	private static void findMinTime(int[] arr, int timeCount, boolean[] isA, boolean isASide) {
		if (timeCount > minTime) {
			return ;
		}
		if (!isASide) {
			boolean temp = false;
			for (int i = 0; i < isA.length; ++ i)
				temp |= isA[i];
			if (!temp) {
				minTime = minTime > timeCount ? timeCount : minTime;
				return ;
			}
		}
		for (int i = 0; i < isA.length; ++ i) {
			if (isA[i] ^ isASide)
				continue;
			if (isASide) {
				for (int j = i+1; j < isA.length; ++ j) {
					if (isA[j] ^ isASide)
						continue;
					isA[i] = !isA[i];
					isA[j] = !isA[j];
					isASide = !isASide;
						findMinTime(arr, timeCount+Math.max(arr[i], arr[j]), isA, isASide);
					isA[i] = !isA[i];
					isA[j] = !isA[j];
					isASide = !isASide;
				}
			} else {
				isA[i] = !isA[i];
				isASide = !isASide;
					findMinTime(arr, timeCount+arr[i], isA, isASide);
				isA[i] = !isA[i];
				isASide = !isASide;
			}
		}
		return;
	}
	public static void quickSort (int[] data, int begin, int end) {
		if (begin < end) {
			int pivot = pivotIndex(data, begin ,end);
			quickSort(data, begin, pivot - 1);
			quickSort(data, pivot + 1, end);
		}
	}
	private static int pivotIndex(int[] data, int begin, int end) {
		int pivot = data[begin];
		while (begin < end) {
			while (begin<end && data[end]>=pivot)    -- end;
			data[begin] = data[end];
 			while (begin<end && data[begin]<=pivot)  ++ begin; 
 			data[end] = data[begin];
		}
		data[begin] = pivot;
		return begin;
	}
//	@Test
//	public void test(){
//		System.out.println(true^false);
//		System.out.println(true^true);
//	}
}
