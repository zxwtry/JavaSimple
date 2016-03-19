package book.offer;
/*


����������
	����dataArray[N]��1~N-1��N-1��������������У�����ĳ�������ظ�һ�Ρ�
	дһ���������ҳ��ظ����Ǹ���


 */
public class ��A09����ҳ�������Ψһ���ظ�Ԫ�� {
	public static void main(String[] args) {
		int[] dataArray = {1, 2, 3, 7, 7, 6, 5, 4};
		System.out.println(getTheDouNum4(dataArray));
		for (int i : dataArray)
			System.out.printf("%d ", i);
	}
	static int getTheDouNum4 (int[] dataArray) {
		//����һ�ַǳ�����Ľⷨ
		int index1 = 0, index2 = 0;
		do {
			index1 = dataArray[dataArray[index1]];
			index2 = dataArray[index2];
		} while (index1 != index2);
		index1 = 0;
		do {
			index1 = dataArray[index1];
			index2 = dataArray[index2];
		} while (index1 != index2);
		return index1;
	}
	static int getTheDouNum3 (int[] dataArray) {
		final int len = dataArray.length;
		for (int index = 0; index < len; index ++) {
			if (dataArray[index] > 0)
				dataArray[dataArray[index]] = - dataArray[dataArray[index]];
			else
				dataArray[-dataArray[index]] = - dataArray[-dataArray[index]];
		}
		int result = Integer.MIN_VALUE;
		for (int index = 0; index < len; index ++) {
			if (dataArray[index] > 0)
				result = index;
			else
				dataArray[index] = - dataArray[index];
		}
		return result;
	}
	static int getTheDouNum2 (int[] dataArray) {
		final int len = dataArray.length;
		int sum = 0;
		for (int index = 0; index < len - 1; index ++) {
			sum ^= index + 1;
			sum ^= dataArray[index];
		}
		sum ^= dataArray[len - 1];
		return sum;
	}
	static int getTheDouNum1 (int[] dataArray) {
		final int len = dataArray.length;
		int sum1 = 0, sum2 = 0;
		for (int index = 0; index < len-1; index ++) {
			sum1 += index + 1;
			sum2 += dataArray[index];
		}
		sum2 += dataArray[len-1];
		return sum2 - sum1;
	}
}
