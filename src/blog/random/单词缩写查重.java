package blog.random;
/*


题目也不难。假设对于一个英文单词，我们可以用简写的形式表示，比如international，就是i11l， apple，就是a3e。
那么给你一个文档，包含了很多的单词。再给一个缩写，那么这个缩写是否唯一对应一个单词。


 */
public class 单词缩写查重 {
	public static void main(String[] args) {
		String[] str1 = {"international", "apple", "apple", "internbtional"};
		String str2 = "i11l", str3 = "a3e";
		System.out.println(isOnlyOne(str1, str2));
		System.out.println(isOnlyOne(str1, str3));
		
	}
	static boolean isOnlyOne (String[] strDoc, String strAbbr) {
		int strLen = Integer.parseInt(strAbbr.substring(1, strAbbr.length()-1)) + 2;
		char pre = strAbbr.charAt(0), pos = strAbbr.charAt(strAbbr.length()-1);
		boolean isExist = false;
		for (int index = 0; index < strDoc.length; index ++) {
			if (strLen == strDoc[index].length() && pre == strDoc[index].charAt(0) && pos == strDoc[index].charAt(strLen-1)) {
				if (isExist)
					return false;
				else
					isExist = true;
			}
		}
		return true;
	}
}
