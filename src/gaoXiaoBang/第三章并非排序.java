/*

�����ɵ�Ԫ�����������ǰ5��Ԫ�ء�

���磺23��15��26��38��33��22��19��17��21��35��47��2��18�� ...

��Ȼ������Զ����е�Ԫ������Ȼ���ҳ�����5��Ԫ�أ���������ʵ���������˲���Ҫ�Ķ���Ĺ�����

���Ԫ�ؽ϶࣬ʵ����ȫ�����Ȼ���˷���Դ��������ֻҪǰ5��Ԫ�أ������ź�����Ҳûʲô�ô���

����ϸ���һ�½ⷨ���ܹ��ܿ�ȫ����
g
 */

package gaoXiaoBang;

public class �����²������� {
	public static void main(String[] args) {
		int[] arrayInt = {23, 15, 26, 38, 33, 22, 19, 17, 21, 35, 47, 2, 18};
		int[] ans = getMaxFiveInt(arrayInt, 13);
		for (int i = 0; i < ans.length; i ++)
			System.out.println(ans[i]);
	}
	private static int[] getMaxFiveInt(int[] arrayInt, int MaxNum) {
		if (MaxNum <= 0) MaxNum = 1;
		else if (MaxNum > arrayInt.length) MaxNum = arrayInt.length;
		int[] ans = new int[MaxNum];
		for (int i = 0; i < MaxNum; i ++) {
			ans[i] = Integer.MIN_VALUE;
		}
		int arrayIntTemp;
		for (int i = 0; i < arrayInt.length; i ++) {
			arrayIntTemp = arrayInt[i];
			if (arrayIntTemp > ans[MaxNum - 1]) {
				insertIntoAns(arrayIntTemp, ans);
			}
		}
		return ans;
	}
	private static void insertIntoAns(int arrayIntTemp, int[] ans) {
		if (arrayIntTemp <= ans[ans.length - 1])	return;
		int ansPosition = ans.length;
		while (-- ansPosition >= 0) 
			if (ans[ansPosition] >= arrayIntTemp) {
				if (ansPosition != ans.length - 1)
					ans[ansPosition + 1] = arrayIntTemp;
				break;
			} else if (ansPosition != ans.length - 1) 
				ans[ansPosition + 1] = ans[ansPosition];
		if (ansPosition == -1)
			ans[0] = arrayIntTemp;
	}
}
