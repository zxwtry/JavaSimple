package book.jianZhiOffer;

import java.util.HashMap;

/*
 * ���룺"abaccdeff"
 * �����b
 */
public class ��35��һ��ֻ����һ�ε��ַ� {
	public static void main(String[] args) {
		System.out.println(getTheFirstOnceChar("abaccdeff"));
		System.out.println(getTheFirstOnceChar("a"));
		System.out.println(getTheFirstOnceChar("abcdefgfedcba"));
	}
	//��Java��char��ռ16λ�ģ���Ȼ��������ȫ��char��ֵΪHashMap��key
	//�������ã� 0 - 25    26 - 51 
	//        'A'-'Z'    ��a��-'z'
	private static char getTheFirstOnceChar(String str) {
		//boolean ���false˵��ֻ��һ��	���true˵������������������
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i ++) {
			if (map.containsKey(c[i]))
				map.put(c[i], true);
			else
				map.put(c[i], false);
		}
		char cre = (char)0, tmp;
		for (int i = 0; i < 52; i ++) {
			tmp = fromIntToChar(i);
			if (map.containsKey(tmp))
				if (!map.get(tmp)) {
					cre = tmp;
					break;
				}
		}
		return cre;
	}
	static int fromCharToInt (char c) {
		if (c>'Z')
			return 26 + 'z' - c;
		
		else
			return c - 'A';
	}
	static char fromIntToChar (int i) {
		if (i > 25) 
			return (char)(i-26+'a');
		else
			return (char)(i+'A');
	}
}
