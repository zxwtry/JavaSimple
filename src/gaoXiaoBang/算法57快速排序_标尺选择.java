package gaoXiaoBang;


/*


����
���ѡ��
��������ı��ѡ��������ٶȺ���Ӱ�졣
����ÿ��ѡ�ı�߶���ƫһ�ˣ�������ͺܳ����ˡ�
�뿼����ȫ���������������
����ѡ��߲��ܾ�������Ӱ���أ�

 */


public class �㷨57��������_���ѡ�� {
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
		//������pivot�������
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
