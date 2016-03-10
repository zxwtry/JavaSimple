package bolg.july;

/*

����һ���ַ�����Ҫ����ַ���ǰ������ɸ��ַ��ƶ����ַ�����β����
����ַ�����abcdef��ǰ���2���ַ�'a'��'b'�ƶ����ַ�����β����
ʹ��ԭ�ַ�������ַ�����cdefab������дһ��������ɴ˹��ܣ�
Ҫ��Գ���Ϊn���ַ���������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1)��

 */

public class ���֮��01��ת�ַ��� {
	public static void main(String[] args) {
		String s = "ABCDEFG";
		System.out.println(leftRotateString(s.toCharArray(), 4));
	}
	
	private static String leftRotateString(char[] c, int indexOfMove) {
		indexOfMove %= c.length;
		reverseString(c, 0, indexOfMove-1);
		reverseString(c, indexOfMove, c.length-1);
		reverseString(c, 0, c.length-1);
		return String.valueOf(c);
	}
	private static void reverseString(char[] c, int begin, int end) {
		while (begin < end) {
			char charTemp = c[begin];
			c[begin ++] = c[end];
			c[end --] = charTemp;
		}
	}
	
}
