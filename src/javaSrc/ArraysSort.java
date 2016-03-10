package javaSrc;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		int[] a = {2, 4, 6, 8, 1, 3, 5, 7 , 9, 0};
		Arrays.sort(a);
		tools.IOUtils.printAnArray(a);
		A[] b = new A[10];
		for (int i = 0 ;i < b.length; i ++)
			b[i] = new A(i+1);
		tools.IOUtils.printAnArray(b);
	}
	static class A {
		int[] data ;
		public A (int n) {
			data = new int[n];
			for (int i = 0 ; i < n ; i ++ ) 
				data[i] = i*i;
		}
		@Override
		public String toString () {
			StringBuilder st = new StringBuilder ();
			for (int i = 0; i < data.length; i ++) {
				st.append(data[i] + "\t");
			}
			return st.toString();
		}
	}
}
