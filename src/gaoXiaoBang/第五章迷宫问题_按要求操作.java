/*
С��������һ������Ӳ�ҡ�����Ϸ��

���Ϸ����ų�һ�ŵ�����Ӳ�ҡ������� * ��ʾ���棬�� o ��ʾ���棨��Сд��ĸ�������㣩��

���磬���������ǣ�**oo***oooo
���ͬʱ��ת��ߵ�����Ӳ�ң����Ϊ��oooo***oooo

����С���������ǣ������֪�˳�ʼ״̬��Ҫ�ﵽ��Ŀ��״̬��
ÿ��ֻ��ͬʱ��ת���ڵ�����Ӳ�ң���ô���ض��ľ��棬����Ҫ�������ٴ��أ�
����Լ�����ѷ������ڵ�����Ӳ�ҽ���һ����������ôҪ��
�������룺
���еȳ����ַ������ֱ��ʾ��ʼ״̬��Ҫ�ﵽ��Ŀ��״̬��ÿ�еĳ���<1000

���������
һ����������ʾ��С��������

���磺
�û����룺
**********
o****o****

����Ӧ�������
5

�����磺
�û����룺
*o**o***o***
*o***o**o***

����Ӧ�������
1
 */


package gaoXiaoBang;

public class �������Թ�����_��Ҫ����� {
	private static int countSave = Integer.MAX_VALUE;
	//��*��Ϊtrue��o��Ϊfalse
	public static void main(String[] args) {
//		String s0 = "**********";
//		String s1 = "o****o****";
		String s0 = "*o**o***o***";
		String s1 = "*o***o**o***";
		boolean[][] a = fromStarToBoolean(s0, s1);
//		for (int i = 0 ; i < a[0].length; ++ i) {
//			System.out.println(a[0][i] + " " + a[1][i]);
//		}
		int indexBegin = 0, indexEnd = a[0].length-1;
		while(indexBegin <= indexEnd) {
			if(a[0][indexBegin] == a[1][indexBegin])
				indexBegin ++;
			else
				break;
		}
		while(indexBegin <= indexEnd) {
			if(a[0][indexEnd] == a[1][indexEnd])
				indexEnd --;
			else
				break;
		}
//		System.out.println(indexBegin+" "+indexEnd);
		myTravel(a, 0, indexEnd, 0);
		System.out.println(countSave);
	}
	private static void myTravel(boolean[][] a, int indexBegin,
			int indexEnd, int count) {
		if (count >= countSave)        return;
		int index1 = indexBegin, index2 = indexEnd;
		while(index1 < index2) {
			if (a[0][index1] == a[1][index1]) 
				++ index1;
			else 
				break;
		}
		while(index2 > index1) {
			if (a[0][index2] == a[1][index2])
				-- index2;
			else
				break;
		}
		if (index1 >= index2) {
			if(countSave > count)
				countSave = count;
			return;
		}
		a[1][index1] = !a[1][index1];
		a[1][index1+1] = !a[1][index1+1];
		++ count;
			myTravel(a, index1, index2, count);
		-- count;
		a[1][index1] = !a[1][index1];
		a[1][index1+1] = !a[1][index1+1];
		
		a[1][index2] = !a[1][index2];
		a[1][index2-1] = !a[1][index2-1];
		++ count;
			myTravel(a, index1, index2, count);
		-- count;
		a[1][index2] = !a[1][index2];
		a[1][index2-1] = !a[1][index2-1];
	}
	private static boolean[][] fromStarToBoolean(String s0, String s1) {
		int sLen = s0.length();
		if (sLen != s1.length() || sLen <= 0) {
			System.out.println("�û����벻��ȷ");
			System.exit(0);
		}
		boolean[][] re = new boolean[2][];
		re[0] = new boolean[sLen];
		re[1] = new boolean[sLen];
		char[] s0Char = s0.toCharArray();
		char[] s1Char = s1.toCharArray();
		for (int i = 0; i < sLen; ++ i) {
			re[0][i] =  s0Char[i] == '*'; 
			re[1][i] =  s1Char[i] == '*'; 
		}
		return re;
	}
}
