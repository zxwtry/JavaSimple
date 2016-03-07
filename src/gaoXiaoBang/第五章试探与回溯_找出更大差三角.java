/*
仔细观察下面的数字组成的三角形：

   3
 1 4
5 6 2

看出什么特征吗？
首先，它包含了1~6的连续整数。
重要的是：每个数字都是其下方相邻的两个数字的差（当然是大数减去小数）
满足这样特征的三角形，称为：差三角。

你的任务是找出1~15的整数组成的一个更大的差三角。其形如：

    ?
   4 ?
  ? ? ?
 ? ? ? ?
? ? ? ? ?


	1
	
 */


package gaoXiaoBang;

import java.util.Arrays;


public class 第五章试探与回溯_找出更大差三角 {
	static int[] range = new int[16];
	public static void main(String[] args) {
		boolean[] locArr = new boolean[16];		//位置
		Arrays.fill(locArr, false);
		locArr[2] = true;
		boolean[] valUsed = new boolean[16];		//值
		Arrays.fill(valUsed, false);
		valUsed[4] = true;
		
		int[] arr = new int[16];					//所求
		arr[0] = 15;
		arr[2] = 4;
		
		System.out.println(sort(arr, locArr, valUsed));
		
		for (int i = 1; i < 16; ++ i) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
 	}
	public static boolean sort(int[] arr, boolean[] locArr, boolean[] valUsed) {
		boolean isAlways = true;
		for (int i = 1; i < 11; ++ i) {
			if (locArr[i] && locArr[i+range[i]] && locArr[i+range[i]+1]) {
				if (arr[i] == Math.abs(arr[i+range[i]] - arr[i+range[i]+1])) {
					isAlways &= true;
				} else {
					return false;
				}
			} else {
				isAlways = false;
			}
		}
		if (isAlways)    return true;
		for (int i = 1; i < 16; ++ i) { //值
			if (i == 4)    continue;
			if (!valUsed[i]) {
				valUsed[i] = true;
					int locIndex = 1;
					while(locArr[locIndex])
						locIndex ++;
					locArr[locIndex] = true;
						arr[locIndex] = i;
//						if (locArr[locIndex] && (locArr[locIndex+range[locIndex]] 
//								|| locArr[locIndex+range[locIndex]+1])) {
//							
//						}
						if(sort(arr, locArr, valUsed)){
							return true;
						}
					locArr[locIndex] = false;
				valUsed[i] = false;
			}
		}
		return false;
	}
	
//	@Test
//	public void test () {
//		int i = 0;
//		for (test2(1); i < 5 && tests(1); ++ i, test2(2)) {
//			System.out.println(i);
//		}
//		
//	}
//	private void test2(int k){
//		if (k == 1)
//		System.out.println("DDD");
//		else 
//			System.out.println("FFF");
//	}
//	private boolean tests(int k) {
//		switch(k) {
//		case 0:
//			System.out.println("AAA");
//			break;
//		case 1:
//			System.out.println("BBB");
//			break;
//		case 2:
//			System.out.println("CCC");
//			break;
//		}
//		return true;
//	}
	
	static {
		range[0] = 0;
		for (int i = 1; i < 16; ++ i) {
			range[i] = (int)(Math.sqrt(2*i+0.25)+0.5-0.0000001);
		}
	}
	
//	@Test
//	public void suzi() {
//	} 
	
}
