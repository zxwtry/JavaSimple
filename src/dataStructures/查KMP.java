package dataStructures;
/*
 * KMP算法是对模式串进行分析之后做出的改进
 * 会有一个next数组用于存储当模式串在这个位置匹配失败之后进行的操作
 * 
 */
public class 查KMP {
	private static int[] getNext(char[] c) {
		int[] next = new int[c.length];
		int j = 0, i = 0;
		next[0] = -1;
		while (i < c.length-1) {
			if (-1 == j || c[i] == c[j]) {
				i ++; j ++;
				next[i] = j;
//				if (c[i] == c[j])
//					next[i] = next[j];
//				else
//					next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	private static int indexKMP (char[] s, char[] t) {
		if (s == null || t == null || s.length < t.length) 
			return -1;
		int i = -1, j = 0;
		int[] next = getNext(t);
		while (i < s.length && j < t.length) {
			if (-1 == j || s[i] == t[j]) {
				++ i; ++ j;
			} else {
				j = next[j];
			}
			if (j >= t.length)
				return i - t.length;
			else 
				return -1;
		}
		return -1;
	}
	public static void main(String[] args) {
		String s = "abcabaaabaabcac";
		String t = "abaabcac";
		System.out.println(indexKMP(s.toCharArray(), t.toCharArray()));
	}
}
