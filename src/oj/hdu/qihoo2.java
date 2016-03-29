package oj.hdu;

import java.util.Scanner;

public class qihoo2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m, n;
		int locIndex;
		char ex;
		while(in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();
			if (n == 0) {
				continue;
			}
			char[] c = in.next().trim().toCharArray();
			for(int i = 0; i < m; i ++) {
				locIndex = in.nextInt();
				ex = in.next().trim().charAt(0);
				c[locIndex-1] = ex;
				char[] tmp = c.clone();
				System.out.println(f(tmp));
			}
		}
		in.close();
	}
	static int f(char[] c) {
		int count = 0;
		int len = c.length;
		for(int index = 0; index < len-1; index ++) {
			
			if (c[index] == c[index+1] && c[index] == '.') {
				char[] tmp = new char[c.length-1];
				System.arraycopy(c, 0, tmp, 0, index+1);
				if (c.length - index - 2 > 0)
					System.arraycopy(c, index+2, tmp, index+1, c.length-index-2);
				count ++;
				c = tmp;
				len --;
				index  = 0;
			}
		}
		return count;
	}
}
