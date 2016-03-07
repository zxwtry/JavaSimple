package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
���ֳ�Ϯ
���ŵ�������Ϣ�����ķ��ٷ�չ��
д���±��Խ��Խ���ף���Ϊ���Կ���ճ������
Ϊ�˷�ֹ�����й��ȵĳ�Ϯ���󣬷���ԭ������
�����������ܷ���A���£�a.txt�У�
�Ƿ�Ϯ��B���£�b.txt�У���

���ǹ涨����20��������ͬ���ַ������г�Ϯ�����ɡ�
�����a.txt, b.txt�����ݽ��бȶԣ�
����a.txt��ò�Ƴ�Ϯ������λ�á�Ҫ
���г����Ƴ�Ϯ�����ݡ���
������a.txt�е�λ�ã��ڼ����ַ���
����������b.txt��λ�á�

ע�⣺���A�İ�B���е�ͬһ�仰��A���ж��ʹ�ã�
ֻҪ�ҵ���һ��λ�ü��ɡ�
����ͬ���ݳ���20���ַ���ֻ�г��ʼ��20���ַ���
��������Ϊ�ദ��
������ֻ���������²��Ǻܴ�������
���ڳ��Ｘ���׵���������Ҫ�����ӵĴ����ɣ���
�Ǳ����������Χ��
 */

public class �㷨26���ֳ�Ϯ {
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
			System.out.println("û�г�Ϯ");
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
