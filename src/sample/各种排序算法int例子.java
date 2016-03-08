package sample;

public class 各种排序算法int例子 {
	public static void main(String[] args) {
		int[] data = {9,8,7,6,5,4,3,2,1};
		mySort.quickSort(data, 0, data.length-1);
		for (int i = 0; i < data.length; ++ i) {
			System.out.print(data[i]+" ");
		}
	}
	static class mySort {
		public static void quickSort(int[] data, int begin, int end) {
			if (begin >= end)   return;
			int pivot = partition(data, begin, end);
			quickSort(data, begin, pivot-1);
			quickSort(data, pivot+1, end);
		}
		private static int partition(int[] data, int begin, int end) {
			int pivotVal = data[begin];
			while (begin < end) {
				while (begin<end && data[end]>=pivotVal)   --end;
				data[begin] = data[end];
				while (begin<end && data[begin]<=pivotVal) ++begin;
				data[end] = data[begin];
			}
			data[begin] = pivotVal;
			return begin;
		}
	}
}
