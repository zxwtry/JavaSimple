/*
��1���ˣ�Ҫ��nƥ���A������B�塣

��ʼʱ���˺�����A�塣ÿ����1ƥ��ǣ1ƥ������ʱ��1ƥ��

��֪ÿƥ���A�嵽B����Ҫ��ʱ�䣨����Խ��Խ����
��ƥ��ͬ��ʱֻ��Ǩ�ͽ����ߡ�

��������ƥ���˵�B�����С������ʱ�䣨��ʱ���˺�����B�壩��

������������һ������n(n<100)����ʾ��nƥ��

������n����������ʾ���A�嵽B������õķ�������С��1000��
���������1����������ʾ������ƥ���˵�B�����С�ܺ�ʱ��

���磬

���룺
3
1
2
4
����Ӧ�����
7

���룺
4
1
4
2
5
����Ӧ�������
12
 */


package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ���������·��_����Сֵ {
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
