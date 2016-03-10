package javaSrc;

import java.util.Arrays;

import tools.IOUtils;

public class ArraysSort {
	public static void main(String[] args) {
		int[] a = {2, 4, 6, 8, 1, 3, 5, 7 , 9, 0};
		Arrays.sort(a);
		IOUtils.printAnArray(a);
	}
}
