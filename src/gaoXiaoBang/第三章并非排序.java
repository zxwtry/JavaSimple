/*

在若干的元素中求出最大的前5个元素。

比如：23，15，26，38，33，22，19，17，21，35，47，2，18， ...

当然，你可以对所有的元素排序，然后找出最大的5个元素，但这样做实际上是做了不必要的多余的工作。

如果元素较多，实现完全排序必然很浪费资源，而我们只要前5个元素，其它排好了序，也没什么用处！

请仔细设计一下解法，能够避开全排序。
g
 */

package gaoXiaoBang;

public class 第三章并非排序 {
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
