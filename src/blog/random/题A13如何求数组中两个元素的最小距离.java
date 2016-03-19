package blog.random;
/*
数组中有重复元素， 给出两个数n1和n2，求这两个数字在数组中所出现位置的最小距离
例如{4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 9, 8}中，4和8的最小距离是2
 */
public class 题A13如何求数组中两个元素的最小距离 {
	public static void main(String[] args) {
		int[] dataArray = {4, 5, 6, 4, 7, 4, 6, 4, 7, 9, 4, 8, 5, 6, 4, 3, 9, 8};
		System.out.println(getMinDistance(dataArray, 4, 8));
	}
	static int getMinDistance (int[] dataArray, int data1, int data2) {
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		final int len = dataArray.length;
		int index1 = -1, index2 = -1, minDis = Integer.MAX_VALUE;
		for (int index = 0; index < len; index ++) {
			if (dataArray[index] == data1) {
				index1 = index;
				if (index2 >= 0)
					minDis = Math.min(minDis, Math.abs(index2 - index1));
			}
			if (dataArray[index] == data2) {
				index2 = index;
				if (index1 >= 0)
					minDis = Math.min(minDis, Math.abs(index2 - index1));
			}
		}
		return minDis;
	}
}
