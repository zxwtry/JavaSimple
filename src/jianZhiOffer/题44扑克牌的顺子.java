package jianZhiOffer;
/*
 * ���˿����г��5���ƣ��ж��ǲ���һ��˳�ӣ���5�����ǲ���������
 * ��������1-13����С�������������
 * �ܹ���13*4 + 2 = 54����
 */
public class ��44�˿��Ƶ�˳�� {
	public static void main(String[] args) {
		System.out.println(judge(new int[] {0, 1, 2, 3 ,3, 6, 7, 8}));
	}
	static boolean judge (int[] select) {
		quickSort(select, 0, select.length-1);
		int countOf0 = 0, indexOf0 = 0;
		while (indexOf0 < 2) {
			if (select[indexOf0] == 0) {
				countOf0 ++;
				indexOf0 ++;
			} else {
				break;
			}
		}
		int range = 0;
		for (int i = indexOf0; i < select.length-1; i ++) {
			if (select[i+1] == select[i])
				return false;
			range += select[i+1] - select[i] - 1;
		}
		return countOf0 >= range;
	}
	private static void quickSort (int[] dataArray, int beginIndex, int endIndex ) {
		if (beginIndex > endIndex)   return;
		int pivot = partition (dataArray, beginIndex, endIndex);
		quickSort (dataArray, beginIndex, pivot-1);
		quickSort (dataArray, pivot+1, endIndex);
	}
	private static int partition (int[] dataArray, int beginIndex, int endIndex) {
		int pivotData = dataArray[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex<endIndex && dataArray[endIndex]>=pivotData)   --endIndex;
			dataArray[beginIndex] = dataArray[endIndex];
			while (beginIndex<endIndex && dataArray[beginIndex]<=pivotData) ++beginIndex;
			dataArray[endIndex] = dataArray[beginIndex];
		}
		dataArray[beginIndex] = pivotData;
		return beginIndex;
	}
}
