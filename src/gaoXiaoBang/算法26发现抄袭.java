package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
发现抄袭
随着电子与信息技术的飞速发展，
写文章变得越来越容易（因为可以拷贝粘贴）。
为了防止文章中过度的抄袭现象，发扬原创精神，
本程序意在能发现A文章（a.txt中）
是否抄袭了B文章（b.txt中）。

我们规定：有20个连续相同的字符，就有抄袭的嫌疑。
程序对a.txt, b.txt的内容进行比对，
发现a.txt中貌似抄袭的所有位置。要
求列出疑似抄袭的内容、该
内容在a.txt中的位置（第几个字符）
、该内容在b.txt中位置。

注意：如果A文把B文中的同一句话在A文中多次使用，
只要找到第一个位置即可。
当雷同内容超过20个字符，只列出最开始的20个字符，
并不计算为多处。
本程序只适用于文章不是很大的情况，
对于长达几百兆的文章则需要更复杂的处理技巧，不
是本程序的需求范围。
 */

public class 算法26发现抄袭 {
	public static void main(String[] args) throws Exception{
		BufferedReader bra = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\a.txt")));
		BufferedReader brb = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\b.txt")));
		StringBuilder sta= new StringBuilder();
		StringBuilder stb= new StringBuilder();
		while (true) {
			String temp = bra.readLine();
			if (temp  == null)   break;
			stb.append(temp);
		}
		while (true) {
			String temp = brb.readLine();
			if (temp  == null)   break;
			stb.append(temp);
		}
		bra.close();
		brb.close();
		if ( findTheCopy(sta.toString(), stb.toString()) ) {
			
		} else {
			System.out.println("没有抄袭");
		}
	}

	private static boolean findTheCopy(String sta, String stb) {
		char[] staChar = sta.toCharArray();
		for (int i = 0; i < staChar.length-20; ++ i) {
			kmp(String.valueOf(staChar, i, 20), stb);
		}
		return false;
	}

	private static boolean kmp(String st1, String stb) {
		char[] st1C = st1.toCharArray();
		char[] st2C = stb.toCharArray();
		for (int i = 0; i < st2C.length; ++ i) {
			boolean isMatch = true;
			int j = 0;
			for (j = 0; j < st1C.length; ++ j) {
				isMatch &= ( st1C[i] == st2C[j] );
				if (!isMatch) {
					j = 0;
					i -= (j+1);
				}
			}
			if (j == st1C.length) {
				System.out.println(st1);
				return true;
			}
		}
		return false;
	}
}
