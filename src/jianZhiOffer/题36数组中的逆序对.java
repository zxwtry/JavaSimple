package jianZhiOffer;
/*
 * �������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * {7, 5, 6, 4}һ����5������ԣ��ֱ���(7,6) (7,5) (7,4) (6,4) (5,4)
 */
public class ��36�����е������ {
	public static void main(String[] args) {
		int[] data = {7, 5, 6, 4};
		System.out.println(inversePairs(data, 0, data.length-1));
	}
	public static void mergeSortDivide (int[] data, int beginIndex, int endIndex) {
		if (data == null || beginIndex >= endIndex)   return;
		int mid = (beginIndex+endIndex) >> 1;
		mergeSortDivide(data, beginIndex, mid);
		mergeSortDivide(data, mid+1, endIndex);
	}
	public static int inversePairs (int[] data, int beginIndex, int endIndex) {
		if (data == null || beginIndex > endIndex)   return 0;
		int[] copy = new int[endIndex-beginIndex+1];
		System.arraycopy(data, beginIndex, copy, 0, endIndex-beginIndex+1);
		int count = inversePairs(data, copy, 0, copy.length-1);
		return count;
	}
	private static int inversePairs (int[] data, int[] copy, int beginIndex, int endIndex) {
		if (beginIndex == endIndex) {
			copy[beginIndex] = data[beginIndex];
			return 0;
		}
		int length = (endIndex - beginIndex) >> 1;
		int left = inversePairs (copy, data, beginIndex, beginIndex+length);
		int right = inversePairs (copy, data, beginIndex+length+1, endIndex);
		//i��ʼ��Ϊǰ������һ�����ֵ��±�
		int i = beginIndex + length;
		//j��ʼ��Ϊ�������һ�����ֵ��±�
		int j = endIndex;
		int indexCopy = endIndex;
		int count = 0;
		while (i >= beginIndex && j >= beginIndex+length+1) {
			if (data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j-beginIndex-length;
			} else {
				copy[indexCopy--] = data[j--];
			}
		}
		for (; i >= beginIndex; -- i) 
			copy[indexCopy--] = data[i];
		for (; j >= beginIndex+length+1; --j)
			copy[indexCopy--] = data[j];
		return left+right+count;
	}
}