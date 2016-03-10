package bolg.july;

/*

给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。

 */

public class 编程之法01旋转字符串 {
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
