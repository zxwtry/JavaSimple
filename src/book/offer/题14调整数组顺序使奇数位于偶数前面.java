package book.offer;

/*

 */

public class ��14��������˳��ʹ����λ��ż��ǰ�� {
	public static void main(String[] args) {
		int[] data = {1,4,7,9,0,6,3,2,5,8};
		oddBeforeEven(data);
		for (int i = 0; i < data.length; ++ i) {
			System.out.printf("%d\t", data[i]);
		}
	}
	private static void oddBeforeEven (int[] data) {
		if (data == null || data.length <= 1)   return;
		int beginIndex = 0, endIndex = data.length-1;
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && !MyCompareOdd(data[beginIndex]))
				beginIndex ++;
			while (beginIndex < endIndex && MyCompareOdd(data[endIndex]))
				endIndex --;
			if (beginIndex < endIndex) {
				int temp = data[beginIndex];
				data[beginIndex] = data[endIndex];
				data[endIndex] = temp;
			}
		}
	}
	private static boolean MyCompareOdd(int data) {
		return (data&0x1) == 1;
	}
}
