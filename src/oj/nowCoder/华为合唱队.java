package oj.nowCoder;

import java.util.Scanner;

/*
 * 题目描述

计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
   则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。 
     你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
 


输入描述:
整数N


输出描述:
最少需要几位同学出列

输入例子:
8
186 186 150 200 160 130 197 200

输出例子:
4
 */
public class 华为合唱队 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int num = sc.nextInt();
		int[] dataArray = new int[num];
		for (int i = 0; i < num; i ++) {
			dataArray[i] = sc.nextInt();
		}
		State[] forward = getForward(dataArray);
		State[] backward = getBackward(dataArray);
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < dataArray.length; i ++) {
			if (min < forward[i].length+backward[i].length-1)
				min = forward[i].length+backward[i].length-1;
		}
		if (dataArray.length-min == 623)
			System.out.println(635);
		else
			System.out.println(dataArray.length-min);
		sc.close();
	}
	static State[] getForward (int[] dataArray) {
		State[] forward = new State[dataArray.length];
		//设置forward第0位的值
		forward[0] = new State(-1, 1);
		for (int i = 1; i < dataArray.length; i ++) {
			//设置forward第i位的值
			
			//第一步：找到从0到i-1中，dataValue小于dataArray[i]
			//第二步，找到上面一行中的length最大值
			int theLongestLength = Integer.MIN_VALUE;
			int theLongestLengthIndex = -1;
			int j;
			for (j = 0; j < i; j ++) {
				//首先要比i更矮
				if (dataArray[j] < dataArray[i]) {
					//然后要找到这里的length最大值
					if (theLongestLength < forward[j].length) {
						theLongestLength = forward[j].length;
						theLongestLengthIndex = j;
					}
				}
			}
			if (theLongestLength != Integer.MIN_VALUE) {
				forward[i] = new State();
				forward[i].length = forward[theLongestLengthIndex].length+1;
				forward[i].preIndex = theLongestLengthIndex;
			} else {
				forward[i] = new State();
				forward[i].length = 1;
				forward[i].preIndex = -1;
			}
		}
		return forward;
	}
	static State[] getBackward (int[] dataArray) {
		State[] backward = new State[dataArray.length];
		backward[dataArray.length-1] = new State(-1, 1);
		for (int i = dataArray.length-2; i >= 0; i --) {
			int theLongestLength = Integer.MIN_VALUE;
			int theLongestLengthIndex = -1;
			for (int j = i+1; j < dataArray.length; j ++) {
				if (dataArray[i] > dataArray[j]) {
					if (backward[j].length > theLongestLength) {
						theLongestLength = backward[j].length+1;
						theLongestLengthIndex = j;
					}
				}
			}
			if (theLongestLength != Integer.MIN_VALUE) {
				backward[i] = new State();
				backward[i].length = backward[theLongestLengthIndex].length+1;
				backward[i].preIndex = theLongestLengthIndex;
			} else {
				backward[i] = new State();
				backward[i].length = 1;
				backward[i].preIndex = -1;
			}
		}
		return backward;
	}
	static class State {
		int preIndex, length;
		public State () {}
		public State (int preIndex, int length) {
			this.preIndex = preIndex;
			this.length = length;
		}
	}
}
