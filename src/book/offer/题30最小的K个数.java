package book.offer;
/*
 * 基于Partition来进行计算，需要改变原数组O(N)
 * 适合于海量数据的计算方法O(NlogK)
 */
public class 题30最小的K个数 {
	public static void main(String[] args) {
		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//		int[] data = {1, 8, 1, 6, 1, 4, 3, 2, 1};
		/*
		 * 使用{1, 8, 1, 6, 1, 4, 3, 2, 1};同样会出现陷入死循环的情况
		 * 怎么判断?
		 * 出现的问题和题29中的某个编程错误类似，都是在一个会递归的方法中，进行赋值的时候使用了0, data.length-1之类的值
		 * 这样的错误，一定要避免，否则后患无穷
		 */
		int[] re = getMinK(data, 0, data.length-1, 4);
		int[] re2 = getMinKLarge(data, 0, data.length-1, 4);
		for (int index = 0; index < re.length; index ++) {
			System.out.printf("%d ", re[index]);
		}
		System.out.println();
		for (int index = 0; index < re2.length; index ++) {
			System.out.printf("%d ", re2[index]);
		}
		System.out.println();
	}
	public static int[] getMinK (final int[] data, int beginIndex, int endIndex, final int K) {
		if (data == null || data.length <= 0 || beginIndex > endIndex || K <= 0)
			return null;
		int pivot = partition(data, 0 ,data.length-1);
		while (pivot != K-1) {
			if (pivot > K-1)   pivot = partition(data, beginIndex, pivot-1);
			else pivot = partition(data, pivot+1, endIndex);
		}
		int[] minK = new int[K];
		for (int index = 0; index < K; index ++) {
			minK[index] = data[index];
		}
		return minK;
	}
	private static int partition (int[] data, int beginIndex, int endIndex) {
		int randomIndex = (int)((Math.random())*(endIndex-beginIndex)) + beginIndex;
		swap (data, randomIndex, beginIndex);
		int pivotData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && data[endIndex] >= pivotData)   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex < endIndex && data[beginIndex] <= pivotData) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = pivotData;
		return beginIndex;
	}
	private static void swap (int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	//适合处理海量数据的情况
	//核心思想就是，先创建一个大小为K的数据容器来存储最小的K个数字，接着进行替换
	static class MinK {
	    int[] data;
	    int count ;
	    int maxIndex;
		public MinK(int K) {
			data = new int[K];
			count = 0;
		}
		public void add(int dataD) {
			if (count == 0) {
				data[count] = dataD;
				maxIndex = count;
				count ++;
				return;
			}
			if (count < data.length) {
				data[count] = dataD;
				if (dataD > data[maxIndex])
					maxIndex = count;
				count ++;
			} else {
				if (dataD < data[maxIndex])
					data[maxIndex] = dataD;
				for (int i = 0; i < data.length ; ++ i) {
					if (data[i] > data[maxIndex])
						maxIndex = i;
				}
			}
		}
	}
	public static int[] getMinKLarge (int[] data, int beginIndex, int endIndex, int K) {
		MinK mk = new MinK(K);
		for (int i = beginIndex ; i<= endIndex ;i ++) {
			mk.add(data[i]);
		}
		return mk.data;
	}
}
