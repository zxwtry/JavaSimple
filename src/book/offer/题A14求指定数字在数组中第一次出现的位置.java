package book.offer;
/*
给定数组  a = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
这个数组相邻元素之差为1， 给定的数字9， 它在数组中第一次出现的位置下标是8
 */
public class 题A14求指定数字在数组中第一次出现的位置 {
	public static void main(String[] args) {
		int[] dataArray = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
		System.out.println(getFirstAppearIndex(dataArray, 8));
	}
	static int getFirstAppearIndex (int[] dataArray, int data) {
		//跳着去找
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		final int len = dataArray.length;
		int index = 0;
		while (index < len) {
			if (dataArray[index] == data)
				return index;
			else
				index += Math.abs(data - dataArray[index]);
		}
		System.out.println("Not Found ! return -1 ");
		return -1;
	}
}
