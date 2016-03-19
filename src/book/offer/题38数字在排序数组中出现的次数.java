package book.offer;
/*
 * 输入排序数组{1, 2, 3, 3, 3, 3, 4, 5} 和数字3
 * 由于3在这个数组中出现4次， 因此输出4
 */
public class 题38数字在排序数组中出现的次数 {
	public static void main(String[] args) {
		int[] data = {1, 2, 3, 3, 3, 4, 4, 5};
		System.out.println(getTimesOfNum(data, 3));
	}
	private static int getTimesOfNum (int[] dataArray, int dataValue) {
		int beginIndex = getMin (dataArray, 0, dataArray.length-1, dataValue);
		int endIndex = getMax (dataArray, 0, dataArray.length-1, dataValue);
		return endIndex-beginIndex+1;
	}
	private static int getMax (int[] dataArray, int beginIndex, int endIndex, int dataValue) {
		int pivot = partition(dataArray, beginIndex, endIndex);
		if (dataArray[pivot] < dataValue)
			return getMax(dataArray, pivot+1, endIndex, dataValue);
		else if (dataArray[pivot] > dataValue)
			return getMax(dataArray, beginIndex, pivot-1, dataValue);
		if (pivot == dataArray.length-1)
			return pivot;
		else {
			if (dataArray[pivot+1] != dataValue)
				return pivot;
			else
				return getMax(dataArray, pivot+1, endIndex, dataValue);
		}
	}
	private static int getMin (int[] dataArray, int beginIndex, int endIndex, int dataValue) {
		int pivot = partition(dataArray, beginIndex, endIndex);
		if (dataArray[pivot] > dataValue)
			return getMin(dataArray, beginIndex, pivot-1, dataValue);
		else if (dataArray[pivot] < dataValue)
			return getMin(dataArray, pivot+1, endIndex, dataValue);
		
		if (pivot == 0)
			return 0;
		else {
			if (dataArray[pivot-1] != dataValue)
				return pivot;
			else
				return getMin(dataArray, beginIndex, pivot-1, dataValue);
		}
	}
	private static int partition (int[] dataArray, int beginIndex, int endIndex) {
		int middleIndex = (beginIndex+endIndex) >> 1;
		swap(dataArray, beginIndex, middleIndex);
		int pivotValue = dataArray[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex<endIndex && dataArray[endIndex]>=pivotValue)   --endIndex;
			dataArray[beginIndex] = dataArray[endIndex];
			while (beginIndex<endIndex && dataArray[beginIndex]<=pivotValue) ++beginIndex;
			dataArray[endIndex] = dataArray[beginIndex];
		}
		dataArray[beginIndex] = pivotValue;
		return beginIndex;
	}
	private static void swap (int[] dataArray, int index1, int index2) {
		int tmp = dataArray[index1];
		dataArray[index1] = dataArray[index2];
		dataArray[index2] = tmp;
	}
}
