/*
小明正在玩一个“翻硬币”的游戏。

桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。

比如，可能情形是：**oo***oooo
如果同时翻转左边的两个硬币，则变为：oooo***oooo

现在小明的问题是：如果已知了初始状态和要达到的目标状态，
每次只能同时翻转相邻的两个硬币，那么对特定的局面，最少要翻动多少次呢？
我们约定：把翻动相邻的两个硬币叫做一步操作，那么要求：
程序输入：
两行等长的字符串，分别表示初始状态和要达到的目标状态。每行的长度<1000

程序输出：
一个整数，表示最小操作步数

例如：
用户输入：
**********
o****o****

程序应该输出：
5

再例如：
用户输入：
*o**o***o***
*o***o**o***

程序应该输出：
1
 */


package gaoXiaoBang;

public class 第五章迷宫问题_按要求操作 {
	private static int countSave = Integer.MAX_VALUE;
	//将*设为true，o设为false
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
			System.out.println("用户输入不正确");
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
