package book.jianZhiOffer;

import java.util.HashMap;

/*
 * 输入："abaccdeff"
 * 输出：b
 */
public class 题35第一个只出现一次的字符 {
	public static void main(String[] args) {
		System.out.println(getTheFirstOnceChar("abaccdeff"));
		System.out.println(getTheFirstOnceChar("a"));
		System.out.println(getTheFirstOnceChar("abcdefgfedcba"));
	}
	//在Java中char是占16位的，显然不能设置全部char的值为HashMap的key
	//这样处置： 0 - 25    26 - 51 
	//        'A'-'Z'    ‘a’-'z'
	private static char getTheFirstOnceChar(String str) {
		//boolean 如果false说明只有一个	如果true说明有两个或两个以上
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
