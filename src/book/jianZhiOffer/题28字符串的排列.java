package book.jianZhiOffer;

import java.util.Arrays;

import org.junit.Test;

/*
 * 树如一个字符串，打印该字符串中字符的所有佩列。
 * 
 */
public class 题28字符串的排列 {
	public static void main(String[] args) {
		String s = "ABC";
//		String s = "啊不才的额非个";
//		System.out.println(s.toCharArray().length);
//		permutation(s.toCharArray());
//		someMayAbsentPermutation(s.toCharArray());
		permutation(s.toCharArray());
	}
	static void permutation (char[] c) {
		if (c == null || c.length <= 0)   return;
		permutation(c, 0);
	}
	private static void permutation (char[] c, int index) {
		if (index == c.length)   System.out.println(String.valueOf(c));
		else {
			for (int travelIndex = index; travelIndex < c.length; travelIndex ++) {
				char tmp = c[travelIndex];
				c[travelIndex] = c[index];
				c[index] = tmp;
					permutation (c, index+1);
				tmp = c[travelIndex];
				c[travelIndex] = c[index];
				c[index] = tmp;
			}
		}
	}
	static void someMayAbsentPermutation (char[] c) {
		boolean[] isParticipated = new boolean[c.length];
		Arrays.fill(isParticipated, false);
		startAbsentPermutation(c, isParticipated , 0);
	}
	private static void startAbsentPermutation (char[] c, boolean[] isParticipated, int affectedNum) {
		if (affectedNum >= c.length)   return;
		for (int selectNum = 1; selectNum <= c.length; selectNum ++) {
			startAbsentPermutation(c, isParticipated, affectedNum, selectNum);
		}
	}
	private static void startAbsentPermutation(char[] c, boolean[] isParticipated, int affectedNum, int selectNum) {
		/*
		 *;/
		 */
		if (affectedNum == selectNum) {
			//这里完全不关心这个String是否已经被输出过
			//达到这个条件就是输出，然后返回
			//进行输出工作
			StringBuilder st = new StringBuilder();
			for (int charIndex = 0;charIndex < c.length; charIndex ++) {
				st.append(c[charIndex]);
			}
			System.out.println(st.toString());
			return;
		} else if ( affectedNum > selectNum) {
			//一般不会运行到这
			return;
		}
		//找出全部可以进行选择的选项
		
				
	}
	
	@Test
	public void testSelectMFromN () {
//		char[]c = {'A', 'B', 'C'};
//		boolean[] isUsed = new boolean[c.length];
//		Arrays.fill(isUsed, true);
//		isUsed[0] = false;
//		StringBuilder st = new StringBuilder();
//		perm (c, isUsed, 0, 2, st);
		myCombine(4, 2, new int[2], 0);
	}
 	public void myCombine (final int N, final int M, int[] m, int mIndex) {
 		if (mIndex == M) {
 			for (int a : m)
 				System.out.printf("%d\t", a);
 			System.out.println();
 			return;
 		}
 		for (int travelMIndex = mIndex; travelMIndex < M; travelMIndex ++) {
 			m[travelMIndex] = travelMIndex;
 			myCombine(N, M, m, mIndex+1);
 		}
 	}
	public void testSelectMFromN (char[] c, int M, int N) {
		//N表示有N个选型：0, 1, 2 ... N-1
		//M表示需要从中选出M个数
		//根据理论有：n! / (m! * (n-m)!) 个选择
		//需要把这些选择统统输出
		//根据博文   http://blog.csdn.net/qiaofangjie/article/details/8088968
		//得到响应的代码
//		perm(c, 0);
		int[] index = new int[M];
		combine(c, index, N, M, N);
	}
 	public void perm (char[] c, boolean[] isUsed, int k, int expectedK, StringBuilder st) {
 		//这是排列的代码
 		//只有被标记为true的字符才能够被用于排列
 		if (k == expectedK-1)
 			System.out.println(st.toString());
 		else {
 			for (int i = k; i < c.length; ++ i) {
 				if (isUsed[i]) {
	 				swap(c, i, k);
	 				st.append(c[i]);
	 				perm(c, isUsed, k+1, expectedK-1, st);
	 				st.deleteCharAt(k);
	 				swap(c, i, k);
 				}
 			}
 		}
 	}
 	private void combine (char[] c, int index[] , int k, int m, int size) {
 		for (int i = size-1; i >= k-1; -- i) {
 			index[k-1] = i;
 			if (k > 1)
 				combine(c, index, k-1, m, i);
 			else {
 				for (int j = 0; j < m; ++ j)
 					System.out.print(c[index[i]]);
 				System.out.println();
 			}
 		}
 	}
 	private void swap (char[] c, int i, int k) {
 		char tmp = c[i];
 		c[i] = c[k];
 		c[k] = tmp;
 	}
 	
 	//只是想功能实现，可以通过创建一个新的char数组来完成代码编写
 	@Test
 	public void createANewCharArray () {
 		char[] c = {'A', 'B', 'C', 'D', 'E'};
 		boolean[] isUsed = {false, true, true, false, true};   //已经被使用过的就不能再使用了
 		StringBuilder st = new StringBuilder();
 		for (int i = 0; i < c.length; i ++ ) {
 			if (! isUsed[i])	st.append(c[i]);
 		}
 		createANewCharArray(st.toString().toCharArray(), 0);
 		System.out.println("================");
 		doNotCreateANewCharArray(c, isUsed, 2, 0, 0);
 	}
 	public void createANewCharArray(char[] c, int index) {
 		if (index == c.length)   
 			System.out.println(String.valueOf(c));
 		for (int travelIndex = index; travelIndex < c.length; travelIndex ++) {
 			swap(c, index, travelIndex);
 			createANewCharArray(c, index+1);
 			swap(c, index, travelIndex);
 		}
 	}
 	public void doNotCreateANewCharArray (char[] c,final boolean[] isUsed, int isUsedFalseAmount, int indexIsUsedFalse, int indexInC) {
 		if (isUsedFalseAmount == indexInC) {
 			StringBuilder st = new StringBuilder ();
 			for (int i = 0; i < c.length; i ++) {
 				if (! isUsed[i]) {
 					st.append(c[i]);
 				}
 			}
 			System.out.println(st.toString());
 			return;
 		}
 		if (isUsed[indexInC]) {
 			doNotCreateANewCharArray(c, isUsed, isUsedFalseAmount, indexIsUsedFalse, indexInC+1);
 			return;
 		}
 			
 		for (int travelIndex = indexInC; travelIndex < c.length; travelIndex ++) {
 			if (! isUsed[travelIndex]) {
 				swap(c, travelIndex, indexInC);
 				doNotCreateANewCharArray(c, isUsed, isUsedFalseAmount, indexIsUsedFalse + 1, indexInC+1);
 				swap(c, travelIndex, indexInC);
 			} else {
 				
 			}
 		}
 	}
 	
}
