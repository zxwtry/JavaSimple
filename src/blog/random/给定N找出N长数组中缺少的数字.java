package blog.random;
/*

给定一个n，比如是4，再给一个n位的数组，比如是0124，找出缺失的数字，就是3。

*/
public class 给定N找出N长数组中缺少的数字 {
	public static void main(String[] args) {
		System.out.println(getTheMissNum(new int[] {1, 2, 3, 4}));
		System.out.println(getTheMissNum(new int[] {0, 1, 2, 3}));
		System.out.println(getTheMissNum(new int[] {0, 2, 3, 4}));
	}
	static int getTheMissNum (int[] array) {
		if (array == null) {
			System.out.println("错误输入");
			return -1;	
		}
		final int len = array.length;
		int beginIndex = 0, endIndex = len - 1, middleIndex = (beginIndex + endIndex) >> 1;
		while (beginIndex < endIndex) {	
			if (array[beginIndex] != beginIndex)
				return beginIndex;
			if (array[endIndex] != endIndex + 1)
				return endIndex + 1;
			if (array[middleIndex] == middleIndex) {
				if (middleIndex == beginIndex)
					break;
				beginIndex = middleIndex;
			} else {
				if (middleIndex == endIndex)
					break;
				endIndex = middleIndex;
			}
			middleIndex = (beginIndex + endIndex) >> 1;
		}
		if (array[middleIndex] != middleIndex)
			return middleIndex;
		else
			return middleIndex + 1;
	}
}
