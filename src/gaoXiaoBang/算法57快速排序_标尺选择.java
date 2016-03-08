package gaoXiaoBang;


/*


问题
标尺选择
快速排序的标尺选择对排序速度很有影响。
假如每次选的标尺都是偏一端，则排序就很吃力了。
请考虑完全正序和逆序的情况。
怎样选标尺才能尽量消除影响呢？

 */


public class 算法57快速排序_标尺选择 {
	public static void main(String[] args) {
		final int[] data = {6, 5, 4, 3, 2, 1};
		quickSort(data, 0, data.length-1);
		for (int i = 0; i < data.length; ++ i) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
	private static void quickSort(int[] data, int begin, int end) {
		if (begin > end) return;
		int pivot = partition(data, begin, end);
		quickSort(data, begin, pivot-1);
		quickSort(data, pivot+1, end);
	}
	private static int partition(int[] data, int begin, int end) {
		//这样的pivot就是随机
		int pivotIndex = begin + (int)(Math.random()*(end-begin));
		int pivot = data[pivotIndex];

		int tempBeginData = data[pivotIndex];
		data[pivotIndex] = data[begin];
		data[begin] = tempBeginData;
		
		while (begin < end) {
			while (begin<end && data[end]>=pivot)   --end;
			data[begin] = data[end];
			while (begin<end && data[begin]<=pivot)  ++ begin;
			data[end] = data[begin];
		}
		data[begin] = pivot;
		return begin;
	}
}
