package book.offer;
/*
��������  a = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
�����������Ԫ��֮��Ϊ1�� ����������9�� ���������е�һ�γ��ֵ�λ���±���8
 */
public class ��A14��ָ�������������е�һ�γ��ֵ�λ�� {
	public static void main(String[] args) {
		int[] dataArray = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
		System.out.println(getFirstAppearIndex(dataArray, 8));
	}
	static int getFirstAppearIndex (int[] dataArray, int data) {
		//����ȥ��
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		final int len = dataArray.length;
		int index = 0;
		while (index < len) {
			if (dataArray[index] == data)
				return index;
			else
				index += Math.abs(data - dataArray[index]);
		}
		System.out.println("Not Found ! return -1 ");
		return -1;
	}
}
