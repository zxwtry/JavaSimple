package jianZhiOffer;

/*
{3, 4, 5, 1, 2}��{1, 2, 3, 4, 5}��һ����ת�����������Сֵ��1
 */

public class ��08��ת�������С���� {
	public static void main(String[] args) throws Exception{
//		final int[] data = {3, 4, 5, 1, 2};
		final int[] data = {1, 0, 1, 1, 1};
		System.out.println(getMin(data));
	}
	private static int getMin (int[] data) throws Exception{
		if (data == null)
			throw new Exception("��ָ��û������");
		int beginIndex = 0, endIndex = data.length-1, midIndex = beginIndex;
		while (data[beginIndex] >= data[endIndex]) {
			if (endIndex - beginIndex == 1) {
				midIndex = endIndex;
				break;
			}
			midIndex = (beginIndex + endIndex) >> 1;
			
			if (data[beginIndex] == data[endIndex] &&
					data[midIndex] == data[beginIndex])
				return minInOrder(data, beginIndex, endIndex);
			
			if (data[midIndex] >= data[beginIndex]) 
				beginIndex = midIndex;
			else if (data[midIndex] <= data[endIndex])
				endIndex = midIndex;
		}
		return data[midIndex];
	}
	private static int minInOrder(int[] data, int beginIndex, int endIndex) {
		int result = data[beginIndex];
		for (int index = beginIndex; index <= endIndex; ++ index) {
			if (result > data[index])
				result = data[index];
		}
		return result;
	}
}
