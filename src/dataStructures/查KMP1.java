package dataStructures;
/*
 * KMP算法是对模式串进行分析之后做出的改进
 * 会有一个next数组用于存储当模式串在这个位置匹配失败之后进行的操作
 * 
 */
public class 查KMP1 {
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
	static int indexKMP (char[] s, char[] t) {
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
	public static int indexKMP2 (char[] s, char[] t, int pos) {
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
	public static int findFirstIndex (char[] s, char[] t) {
		return 0;
	}
	public static void main(String[] args) {
		char[] s = " abcabaaabaabcac".toCharArray();
		s[0] = (char)15;
		char[] t = " abaabcac".toCharArray();
		t[0] = (char)8;
		int[] next = getNext2(t);
		myprinf(next, 0, next.length-1);
		next = getNext4("abaabcac");
		myprinf(next, 0, "abaabcac".length()-1);
	}
	static int[] getNext3(String str) {
		char[] t = str.toCharArray();
		int[] next = new int[t.length];
		int length = t.length;
		int i = 0, j;
		next[0] = -1;
		for (j = 1; j < length; j ++) {
			i = next[j-1];
			while (i>=0 && t[j] != t[j+1]) {
				i = t[i];
			}
			if (t[j] == t[i+1])
				next[j] = i+1;
			else
				next[j] = -1;
		}
		return next;
	}
	//KMP中的核心算法，获得记录跳转状态的next数组
    public static int[] getNext4(String sub) {
                int[] a = new int[sub.length()];
               char[] c = sub.toCharArray();
                int length=sub.length();
                int i,j;
                a[0] = -1;
                i = 0;
               for(j=1;j<length;j++) {
                   i = a[j - 1];
                   while(i>=0&&c[j]!=c[i+1]) {
                       i = a[i];    
                   }
                  if(c[j]==c[i+1]) {
                      a[j] = i+1;
                  }
                  else {
                      a[j] = -1;
                  }
               }
               return a;
           }
	public static void myprinf (char[] c, int beginIndex, int endIndex) {
		System.out.println("======================================");
		for (int i = beginIndex; i <= endIndex; i ++) {
			System.out.printf("%d\t",i);
		}
		System.out.println();
		for (int i = beginIndex; i <= endIndex; i ++) {
			System.out.printf("%c\t",c[i]);
		}
		System.out.println();
	}
	private static void myprinf (int[] c, int beginIndex, int endIndex) {
		System.out.println("======================================");
		for (int i = beginIndex; i <= endIndex; i ++) {
			System.out.printf("%d\t",i);
		}
		System.out.println();
		for (int i = beginIndex; i <= endIndex; i ++) {
			System.out.printf("%d\t",c[i]);
		}
		System.out.println();
	}
}