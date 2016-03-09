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
	//返回子串t在主串s第pos个字符之后的位置
	//若不存在，则返回0
	private static int indexKMP2 (char[] s, char[] t, int pos) {
		int i = pos;
		int j = i;
		int[] next = getNext2(t);
		while (i <= s[0] && j <= t[0]) {
			if (0 == j || s[i] == t[j]) {
				i ++;
				j ++;
			} else {
				j = next[j];
			}
		}
		if (j < t[0]) {
			return i-t[0];
		} else {
			return 0;
		}
	}
	private static int[] getNext2 (char[] t) {
		int j = 0;
		int i = 1;
		int[] next = new int[t.length];
		next[1] = 0;
		while (i < t[0]) {
			if (0 == j || t[i] == t[j]) {
				i ++;
				j ++;
				if (t[i] == t[j])
					next[i] = next[j];
				else
					next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	public static void main(String[] args) {
		char[] s = " abcabaaabaabcac".toCharArray();
		s[0] = (char)15;
		char[] t = " abaabcac".toCharArray();
		t[0] = (char)8;
		System.out.println(indexKMP2(s, t, 1));
	}
}
