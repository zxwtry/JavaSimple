package book.offer;

public class 题10二进制中1的个数 {
	private static int numOf1Method1 (int data) {
		int count = 0;
		while (data != 0) {
			if ((data & 0x1) != 0)
				count ++;
			data = data >>> 1;
		}
		return count;
	}
	private static int numOf1Method2 (int data) {
		int count = 0;
		while (data != 0) {
			count ++;
			data = ((data-1) & data);
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(numOf1Method1(8));
		System.out.println(numOf1Method1(-1));
		System.out.println(numOf1Method2(8));
		System.out.println(numOf1Method2(-1));
	}
}
