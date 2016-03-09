package jianZhiOffer;
/*
 * 例如给出的递增序列是：{1, 3, 4, 6, 7, 9, 10, 13, 14}
 * 现在给定的数字的是15
 */


public class 题41递增序列取两个数使之和为特定值 {
	public static void main(String[] args) {
//		int[] dataArray = {1, 3, 4, 6, 7, 9, 10, 13, 14};
		int[] dataArray = {1, 2, 3, 4, 5, 6};
		TwoInt ti = getTwoInt (dataArray, 0, dataArray.length-1, 4);
		if (ti == null)
			System.out.println("找不到对应的两个数");
		else
			System.out.println(dataArray[ti.int1]+"   "+dataArray[ti.int2]);
		findAllSubArray (dataArray, 15);
	}
	static class TwoInt {
		int int1, int2;
		public TwoInt () {}
		public TwoInt (int int1, int int2) {
			this.int1 = int1;
			this.int2 = int2;
		}
	}
	private static TwoInt getTwoInt (int[] dataArray, int preIndex, int postIndex, final int sum) {
		if (dataArray == null || preIndex >= postIndex)   return null;
		TwoInt ti = new TwoInt(preIndex, postIndex);
		if (dataArray[preIndex]+dataArray[postIndex] == sum) {
			return ti;
		} else if (dataArray[preIndex]+dataArray[postIndex] > sum){
			return getTwoInt (dataArray, preIndex, postIndex-1, sum);
		} else {
			return getTwoInt (dataArray, preIndex+1, postIndex, sum);
		}
	}
	
	/*
	 * 换成打印出所有和为sum的连续正数序列
	 * 例如输入15，则输出
	 * 1 3 4 7
	 * 1 24
	 * 1 4 10
	 * 等等
	 */
	private static void findAllSubArray (int[] dataArray, final int sum) {
		int beginIndex = 0, endIndex = 1;
		int currentSum = dataArray[beginIndex]+dataArray[endIndex];
		while (endIndex-beginIndex > 0 && endIndex < dataArray.length) {
			if (currentSum == sum) {
				printAnArray(dataArray, beginIndex, endIndex);
				endIndex ++;
				if (endIndex == dataArray.length)
					break;
				currentSum += dataArray[endIndex];
			}else if (currentSum > sum) {
				currentSum -= dataArray[beginIndex];
				beginIndex ++;
			} else {
				endIndex ++;
				currentSum += dataArray[endIndex];
			}
		}
	}
	private static void printAnArray (int[] dataArray, int beginIndex, int endIndex) {
		if (beginIndex > endIndex)   return;
		for (int index = beginIndex; index <= endIndex; index ++) {
			System.out.printf("%d\t", dataArray[index]);
		}
		System.out.println();
	}
}
