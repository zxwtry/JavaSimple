package book.offer;
/*
 * ����Partition�����м��㣬��Ҫ�ı�ԭ����O(N)
 * �ʺ��ں������ݵļ��㷽��O(NlogK)
 */
public class ��30��С��K���� {
	public static void main(String[] args) {
		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//		int[] data = {1, 8, 1, 6, 1, 4, 3, 2, 1};
		/*
		 * ʹ��{1, 8, 1, 6, 1, 4, 3, 2, 1};ͬ�������������ѭ�������
		 * ��ô�ж�?
		 * ���ֵ��������29�е�ĳ����̴������ƣ�������һ����ݹ�ķ����У����и�ֵ��ʱ��ʹ����0, data.length-1֮���ֵ
		 * �����Ĵ���һ��Ҫ���⣬���������
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
	
	//�ʺϴ��������ݵ����
	//����˼����ǣ��ȴ���һ����СΪK�������������洢��С��K�����֣����Ž����滻
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
