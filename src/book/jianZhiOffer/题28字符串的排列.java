package book.jianZhiOffer;

import java.util.Arrays;

import org.junit.Test;

/*
 * ����һ���ַ�������ӡ���ַ������ַ����������С�
 * 
 */
public class ��28�ַ��������� {
	public static void main(String[] args) {
		String s = "ABC";
//		String s = "�����ŵĶ�Ǹ�";
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
			//������ȫ���������String�Ƿ��Ѿ��������
			//�ﵽ����������������Ȼ�󷵻�
			//�����������
			StringBuilder st = new StringBuilder();
			for (int charIndex = 0;charIndex < c.length; charIndex ++) {
				st.append(c[charIndex]);
			}
			System.out.println(st.toString());
			return;
		} else if ( affectedNum > selectNum) {
			//һ�㲻�����е���
			return;
		}
		//�ҳ�ȫ�����Խ���ѡ���ѡ��
		
				
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
		//N��ʾ��N��ѡ�ͣ�0, 1, 2 ... N-1
		//M��ʾ��Ҫ����ѡ��M����
		//���������У�n! / (m! * (n-m)!) ��ѡ��
		//��Ҫ����Щѡ��ͳͳ���
		//���ݲ���   http://blog.csdn.net/qiaofangjie/article/details/8088968
		//�õ���Ӧ�Ĵ���
//		perm(c, 0);
		int[] index = new int[M];
		combine(c, index, N, M, N);
	}
 	public void perm (char[] c, boolean[] isUsed, int k, int expectedK, StringBuilder st) {
 		//�������еĴ���
 		//ֻ�б����Ϊtrue���ַ����ܹ�����������
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
 	
 	//ֻ���빦��ʵ�֣�����ͨ������һ���µ�char��������ɴ����д
 	@Test
 	public void createANewCharArray () {
 		char[] c = {'A', 'B', 'C', 'D', 'E'};
 		boolean[] isUsed = {false, true, true, false, true};   //�Ѿ���ʹ�ù��ľͲ�����ʹ����
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
