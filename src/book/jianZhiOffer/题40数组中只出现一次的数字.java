package book.jianZhiOffer;
/*
 * 一个数组中除了两个数字之外，其他的数字都出现两次，找出这两个只出现一次的数字。
 * 要求：事件O(N) 空间O(1)
 * 书上的方法是：
 * 先逐位异或的到一个总的结果是一个不为0的int数字记为intSign
 * 从intSign中得到第一个不为0的位所在位置：
 * 转化为一个循环得到一个int 数
 * 这种方法非常高效，非常值得学习
 */
public class 题40数组中只出现一次的数字 {
	public static void main(String[] args) {
		int[] dataArray = {2, 4, 3, 6, 3, 2, 5, 5};
		TwoInt ti = splitIntoTwoIntArray(dataArray);
		System.out.println(ti.answer1 + "   " + ti.answer2);
	}
	private static int getSplitInt (int[] dataArray) {
		if (dataArray == null)
			return Integer.MIN_VALUE;
		int intSign = dataArray[0];
		for (int dataIndex = 1; dataIndex < dataArray.length; dataIndex ++) {
			intSign ^= dataArray[dataIndex];
		}
		int splitInt = 1;
		while ((intSign & 0x1) == 0) {
			splitInt = splitInt << 1;
			intSign = intSign >> 1;
		}
		return splitInt;
	}
	private static TwoInt splitIntoTwoIntArray (int[] dataArray) {
		TwoInt ti = new TwoInt ();
		int splitInt = getSplitInt(dataArray);
		for (int dataIndex = 0; dataIndex < dataArray.length; dataIndex ++) {
			if ((dataArray[dataIndex] & splitInt ) == splitInt) {
				ti.answer1 ^= dataArray[dataIndex];
			} else {
				ti.answer2 ^= dataArray[dataIndex];
			}
		}
		return ti;
	}
	static class TwoInt {
		int answer1;
		int answer2;
	}
}
