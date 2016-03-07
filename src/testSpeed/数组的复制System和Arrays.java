package testSpeed;


/*
System.arraycopy()比Arrays.copyOf快多了
 */


import java.util.Arrays;

public class 数组的复制System和Arrays {
	public static void main(String[] args) {
		int[] src = new int[10000];
		for (int i = 0 ; i < src.length; ++ i) {
			src[i] = i;
		}
		int[] des = new int[10000];
		long times = System.currentTimeMillis();
		for (int i = 0; i < 10000; ++ i) {
			System.arraycopy(src, 0, des, 0, 10000);
		}
		System.out.println(System.currentTimeMillis()-times);
		
		times = System.currentTimeMillis();
		for (int i = 0; i < 10000; ++ i) {
			des = Arrays.copyOf(src, 10000);
		}
		System.out.println(System.currentTimeMillis()-times);
		
		}
}
