package blog.random;
/*


��ĿҲ���ѡ��������һ��Ӣ�ĵ��ʣ����ǿ����ü�д����ʽ��ʾ������international������i11l�� apple������a3e��
��ô����һ���ĵ��������˺ܶ�ĵ��ʡ��ٸ�һ����д����ô�����д�Ƿ�Ψһ��Ӧһ�����ʡ�


 */
public class ������д���� {
	
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
