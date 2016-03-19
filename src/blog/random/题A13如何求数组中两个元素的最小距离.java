package blog.random;
/*
���������ظ�Ԫ�أ� ����������n1��n2����������������������������λ�õ���С����
����{4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 9, 8}�У�4��8����С������2
 */
public class ��A13���������������Ԫ�ص���С���� {
	public static void main(String[] args) {
		int[] dataArray = {4, 5, 6, 4, 7, 4, 6, 4, 7, 9, 4, 8, 5, 6, 4, 3, 9, 8};
		System.out.println(getMinDistance(dataArray, 4, 8));
	}
	static int getMinDistance (int[] dataArray, int data1, int data2) {
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		final int len = dataArray.length;
		int index1 = -1, index2 = -1, minDis = Integer.MAX_VALUE;
		for (int index = 0; index < len; index ++) {
			if (dataArray[index] == data1) {
				index1 = index;
				if (index2 >= 0)
					minDis = Math.min(minDis, Math.abs(index2 - index1));
			}
			if (dataArray[index] == data2) {
				index2 = index;
				if (index1 >= 0)
					minDis = Math.min(minDis, Math.abs(index2 - index1));
			}
		}
		return minDis;
	}
}
