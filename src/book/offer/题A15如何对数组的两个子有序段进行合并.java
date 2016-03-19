package book.offer;
/*

数组dataArray 从0到mid-1是升序的，从mid到len-1也是有序的
进行合并，要求空间复杂度O(1)

 */
public class 题A15如何对数组的两个子有序段进行合并 {
	//一般使用归并排序，但这里不能使用
	public static void main(String[] args) {
		int[] dataArray = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		mergeResort1 (dataArray, 5);
		for (int i : dataArray)
			System.out.printf("%d ", i);
		System.out.println();
	}
	static void findRightPlaceForMid (int[] dataArray, int mid) {
		if (dataArray == null || mid < 0 || mid >= dataArray.length) {
			System.out.println("illegal input");
			return;
		}
		final int len = dataArray.length;
		int dataTemp;
		for (int index2 = mid; index2 < len - 1; index2 ++) {
			if (dataArray[index2 + 1] < dataArray[index2]) {
				dataTemp = dataArray[index2];
				dataArray[index2] = dataArray[index2 + 1];
				dataArray[index2 + 1] = dataTemp;
			}
		}
	}
	static void mergeResort1 (int[] dataArray, int mid) {
		int dataTemp;
		for (int index = 0; index <= mid - 1; index ++) {
			if (dataArray[mid] < dataArray[index]) {
				dataTemp = dataArray[index];
				dataArray[index] = dataArray[mid];
				dataArray[mid] = dataTemp;
				findRightPlaceForMid(dataArray, mid);
			}
		}
	}
}
