package jianZhiOffer;
/*
 * ���������⣬��Ҫע��һ��Ҫ����
 * 
 * �ӿ��ŵĽǶ�����,��ı�data��ԭ��˳��
 * �Ӷ����ĽǶ�����
 */
public class ��29�����г��ִ�������һ������� {
	public static void main(String[] args) {
//		int[] data = {1, 4, 7, 9, 8, 7, 5, 3, 2};	//������ݺ����棬�����ҵĿ��Ž�����ѭ��
		/*
		 * ��������Ż������ѭ���ķ�����
		 * ��ֻ�ǳ�������������ͬ��Ԫ��ǰ����
		 * �����partition�����У����еıȽ���< �� > �Ǻ������ʣ������׳�����ѭ��
		 * ����취ͬ��ʮ�ּ򵥣����Ǹĳ� <= �� >=
		 * ���һ��Ҫ����
		 */
//		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//		quickSort(data, 0, data.length-1);
//		for(int a : data)
//			System.out.printf("%d ", a);
//		System.out.println();
		
		//�����Ƕ�quickSort�ĸ�ϰ
		//��֪������
//		int[] data = {1, 2, 3, 2, 2, 2, 2, 5, 4, 2};
		int[] data = {1, 1, 1, 1, 0, 0, 0, 0, 0};		//�������ݺ���֣�����StackOverFlow�����ǳ��������,�Ѿ��޸�
//		int[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0};		
//		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};		
			/*
			 * ջ����Ľ��ͣ�
			 * ���ڴ����������Ƕ���ã����ڷ����ڲ����֣�data�� 0�� data.length-1���Ĵ���
			 */
		System.out.println(getTimesMoreThanHalf(data, 0, data.length -1));
		System.out.println(getTimesMoreThanHalf2(data, 0, data.length -1));
		//data�й���10�����֣�����2����6��
		//��Ҫ��λ��λ��(0+data.length())/2���ҵ���һ�����ݼ���
		//
	}
	public static int partition (int[] data, int beginIndex, int endIndex) {
		int rootData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && data[endIndex] >= rootData)   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex < endIndex && data[beginIndex] <= rootData) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = rootData;
		return beginIndex;
	}
	public static void quickSort (int[] data, int beginIndex, int endIndex) {
		if (data == null || data.length <=0 || beginIndex >= endIndex)  return;
		int pivot = specialForHalfPartition(data, beginIndex, endIndex);
		quickSort(data, beginIndex, pivot-1);
		quickSort(data, pivot+1, endIndex);
	}
	public static int getTimesMoreThanHalf (int[] data, int beginIndex, int endIndex) {
		//���������ݵ������£������ջ���
		//�޸�֮���getTimesMortThanHalf2��һ����
		if (data == null || data.length <= 0 || beginIndex > endIndex)   return Integer.MAX_VALUE;
		int pivot = specialForHalfPartition (data, beginIndex, endIndex);
		if (pivot > (data.length>>1))
			return getTimesMoreThanHalf (data, beginIndex, pivot-1);
		else if (pivot < (data.length>>1))
			return getTimesMoreThanHalf (data, pivot+1, endIndex);
		else 
			return checkIfReal(data, pivot) ? data[pivot] : Integer.MAX_VALUE;
	}
	public static int specialForHalfPartition (int[] data, int beginIndex, int endIndex) {
		int ramdonIndex = (int)(Math.random()*(endIndex-beginIndex)) + beginIndex;
		swap(data, beginIndex, ramdonIndex);
		int rootData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && data[endIndex] >= rootData)   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex < endIndex && data[beginIndex] <= rootData) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = rootData;
		return beginIndex;
	}
	public static int getTimesMoreThanHalf2 (int[] data, int beginIndex, int endIndex) {
		//��������еĳ��򣬶���{1, 1, 1, 1, 0, 0, 0, 0, 0};����ջ���
		if (data == null || data.length <= 0)   return Integer.MAX_VALUE;
		if (beginIndex > endIndex )   return Integer.MIN_VALUE;
		int middle = ((beginIndex + endIndex) >> 1);
		int index = specialForHalfPartition (data, beginIndex, endIndex);
		while (index != middle ) {
			if (index > middle) {
				endIndex = index - 1;
				index = specialForHalfPartition (data, beginIndex, endIndex);
			} else {
				beginIndex = index + 1;
				index = specialForHalfPartition (data, beginIndex, endIndex);
			}
		}
		int result = data[middle];
		return checkIfReal(data, middle) ? result : Integer.MAX_VALUE;
	}
	private static void swap (int[] data ,int index1, int index2) {
		int tmp = data[index1];
		data[index1] = data[index2];
		data[index2] = tmp;
	}
	private static boolean checkIfReal (int[] data, int middleValueIndex) {
		int dataValue = data[middleValueIndex];
		int times = 0;
		for (int i = 0; i < data.length; i ++) {
			if (data[i] == dataValue)
				times ++;
		}
		return times > ( data.length >> 1 );
	}
}
