/*
��ϸ�۲������������ɵ������Σ�

   3
 1 4
5 6 2

����ʲô������
���ȣ���������1~6������������
��Ҫ���ǣ�ÿ�����ֶ������·����ڵ��������ֵĲ��Ȼ�Ǵ�����ȥС����
�������������������Σ���Ϊ�������ǡ�

����������ҳ�1~15��������ɵ�һ������Ĳ����ǡ������磺

    ?
   4 ?
  ? ? ?
 ? ? ? ?
? ? ? ? ?


	1
	
 */


package gaoXiaoBang;

import java.util.Arrays;


public class ��������̽�����_�ҳ���������� {
	static int[] range = new int[16];
	public static void main(String[] args) {
		boolean[] locArr = new boolean[16];		//λ��
		Arrays.fill(locArr, false);
		locArr[2] = true;
		boolean[] valUsed = new boolean[16];		//ֵ
		Arrays.fill(valUsed, false);
		valUsed[4] = true;
		
		int[] arr = new int[16];					//����
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
		for (int i = 1; i < 16; ++ i) { //ֵ
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
