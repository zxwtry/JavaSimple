package javaSrc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArraysSort {
	public static void main(String[] args) {
		int[] a = {2, 4, 6, 8, 1, 3, 5, 7 , 9, 0};
		Arrays.sort(a);
		tools.IOUtils.printAnArray(a);
		A[] b = new A[10];
		for (int i = 0 ;i < b.length; i ++)
			b[i] = new A(i+1);
		tools.IOUtils.printAnArray(b);
		A c = new A(100);
		System.out.println("====");
		System.out.println(c.toString());
		System.out.println("====");
		tools.IOUtils.printAnLongString(c.toString());
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(5);
		ar.add(4);
		ar.add(3);
		ar.add(2);
		ar.add(1);
		ar.add(0);
		ar.add(6);
		ar.add(7);
		ar.add(8);
		ar.add(9);
		Iterator<Integer> it = ar.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		Collections.sort(ar, Collections.reverseOrder());
		it = ar.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
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
			int i;
			for (i = 0; i < data.length-1; i ++) {
				st.append(data[i] + "\t");
			}
			st.append(data[i]+"\n");
			return st.toString();
		}
	}
}
