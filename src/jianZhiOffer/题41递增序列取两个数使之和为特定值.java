package jianZhiOffer;
/*
 * ��������ĵ��������ǣ�{1, 3, 4, 6, 7, 9, 10, 13, 14}
 * ���ڸ��������ֵ���15
 */


public class ��41��������ȡ������ʹ֮��Ϊ�ض�ֵ {
	public static void main(String[] args) {
//		int[] dataArray = {1, 3, 4, 6, 7, 9, 10, 13, 14};
		int[] dataArray = {1, 2, 3, 4, 5, 6};
		TwoInt ti = getTwoInt (dataArray, 0, dataArray.length-1, 4);
		if (ti == null)
			System.out.println("�Ҳ�����Ӧ��������");
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
	 * ���ɴ�ӡ�����к�Ϊsum��������������
	 * ��������15�������
	 * 1 3 4 7
	 * 1 24
	 * 1 4 10
	 * �ȵ�
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
