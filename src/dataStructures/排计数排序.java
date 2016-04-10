package dataStructures;

public class ÅÅ¼ÆÊýÅÅÐò {
	public static void main(String[] args) {
		int a[]={100,93,97,92,96,99,92,89,93,97,90,94,92,95};
		int b[] = countSort(a);
		for (int i : b) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	static int[] countSort(int[] a) {
		int[] b = new int[a.length];
		int max = a[0], min = a[0];
		for(int i : a) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		int k = max - min + 1;
		int c[] = new int[k];
		for (int i = 0; i < a.length; i ++) {
			c[a[i] - min] += 1;
		}
		for (int i = 1; i < c.length; i ++) {
			c[i] += c[i-1];
		}
		for (int i = a.length - 1; i >= 0; i --) {
			b[--c[a[i] - min]] = a[i];
		}
		return b;
	}
}
