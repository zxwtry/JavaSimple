/*
闲暇时，福尔摩斯和华生玩一个游戏：

在N张卡片上写有N个整数。两人轮流拿走一张卡片。
要求下一个人拿的数字一定是前一个人拿的数字的约数或倍数。
例如，某次福尔摩斯拿走的卡片上写着数字“6”，则接下来华生可以拿的数字包括：

1，2，3, 6，12，18，24 ....

当轮到某一方拿卡片时，没有满足要求的卡片可选，则该方为输方。

请你利用计算机的优势计算一下，在已知所有卡片上的数字和可选哪些数字的条件下，怎样选择才能保证必胜！

当选多个数字都可以必胜时，输出其中最小的数字。如果无论如何都会输，则输出-1。

输入数据为2行。第一行是若干空格分开的整数（每个整数介于1~50间），表示当前剩余的所有卡片。

第二行也是若干空格分开的整数，表示可以选的数字。当然，第二行的数字必须完全包含在第一行的数字中。

程序则输出必胜的招法！！

例如：

用户输入：

2 3 6
3 6

则程序应该输出：

3

再如：

用户输入：

1 2 2 3 3 4 5
3 4 5

则程序应该输出：

4
 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class 第六章井字棋研究_取卡问题 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader
				(new FileInputStream("c:\\data\\1.txt")));
		int[] a = getInt(br.readLine().trim());
		int[] b = getInt(br.readLine().trim());
		boolean[] isUsedA = new boolean[a.length];
		Vector<Integer> v = new Vector<Integer>();
		for (int i = 0; i < b.length; ++ i) {
			Arrays.fill(isUsedA, false);
			for (int j = 0; j < a.length; ++ j) {
				if (a[j] == b[i]) {
					isUsedA[j] = true;
					break;
				}
			}
			if (solve(a, isUsedA, b[i], 0)){
				v.add(b[i]);
			}
		}
		if (v.size() == 0) {
			System.out.println(-1);
		} else {
			int min = Integer.MAX_VALUE;
			Iterator<Integer> it = v.iterator();
			int temp;
			while (it.hasNext()) {
				temp = it.next();
				if (min > temp) {
					min = temp;
				}
			}
			System.out.println(min);
		}
		br.close();
	}
	
	private static boolean solve(int[] a, boolean[] isUsedA, int val, int times) {
		if (times+1 == a.length) {
			if ((times & 0x1) == 0) {
				//这里是指我对上次修改的判断，是否导致正确
				return true;
			} else {
				return false;
			}
		}
		boolean canItPlay = false;
		for (int i = 0; i < a.length; ++ i) {
			if (isUsedA[i])
				continue;
			if (judge(a[i], val))
				canItPlay ^= true;
			if (canItPlay)
				break;
		}
		if (!canItPlay) {
			if ((times & 0x1) == 0) {
				//这里指代的是对手将没有任何可以选择
				return true;
			} else {
				return false;
			}
		}
		
		if ((times & 0x1) == 0) {
			//接下来是对手的选择
			//对手的任何选择最终都要导向失败
			//否则的话，我的选择就是失败的。
			boolean isItWin = true;
			for (int i = 0; i < a.length; ++ i) {
				
				if (isUsedA[i] || !judge(a[i], val))    continue;
				isUsedA[i] = true;
				times ++;
					isItWin &= solve(a, isUsedA, a[i], times);
//					if (!isItWin) 
//						return false;
				times --;
				isUsedA[i] = false;
			}
			if (isItWin){
				return true;
			} else {
				return false;
			}
		} else {
			//接下来是我的选择
			//我的选择中，肯定要有一条路是可以让我赢。
			boolean isMyWin = false;
			for (int i = 0; i < a.length; ++ i) {
				
				if (isUsedA[i] || !judge(a[i], val))    continue;
				isUsedA[i] = true;
				times ++;
					isMyWin |= solve(a, isUsedA, a[i], times);
//					if (isMyWin)
//						return true;
				times --;
				isUsedA[i] = false;
			}
			if (isMyWin){
				return true;
			} else {
				return false;
			}
		}
	}

	private static boolean judge(int index, int val) {
		if (val % index == 0 || index % val == 0)
			return true;
		else 
			return false;
	}

	private static int[] getInt(String trim) {
		String[] spilt = trim.split(" ");
		int[] re = new int[spilt.length];
		for (int i = 0 ; i < spilt.length; ++ i) {
			re[i] = Integer.parseInt(spilt[i]);
		}
		return re;
	}
}
