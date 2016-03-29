package oj.nowCoder;

import java.util.Scanner;

public class 华为密码验证合格程序 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			System.out.println(getAns(in.nextLine()));
		}
		in.close();
	}

	private static String getAns(String nextLine) {
		boolean is = true;
		char[] c = nextLine.trim().toCharArray();
		if (c.length <= 8)
			return "NG";
		boolean bXiao = false, bDa = false, bShu = false, bO = false;
		for (char h : c) {
			if (h >= 'A' && h <= 'Z')
				bDa = true;
			else if (h >= 'a' && h <= 'z')
				bXiao = true;
			else if (h >= '0' && h <= '9')
				bShu = true;
			else
				bO = true;
		}
		int  count = 0;
		if(bXiao)
			count++;
		if(bDa)
			count++;
		if(bShu)
			count++;
		if(bO)
			count++;
		if (count < 3) {
			return "NG";
		}
		final int len = c.length;
		int in1 = 0;
		for (int sho = 3; sho <= c.length; sho ++) {
			for (; in1 < len-2; in1 ++) {
				// begin in1   end in1+sho-1
				
				
				for (int index = in1+1; index < len-2; index ++) {
					// begin index   end  index + sho -1
					boolean isM = true;
					for (int i = 0; i < sho; i ++) {
						isM &= (c[in1+i] == c[index+i]);
						if (!isM)
							break;
					}
					if (isM) {
						return "NG";
					}
				}
			}
		}
		if (is)
		return "OK";
		return "NG";
	}
}
