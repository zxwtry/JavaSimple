package blog.random;
/*


��һ���������飬�����п�����������������0����������Ԫ�صľ���ֵ��С������


 */
public class ��A12�����������о���ֵ��С���� {
	public static void main(String[] args) {
		int[] dataArray = {-10, -5, -2, 7, 15, 50};
//		int[] dataArray = {-10, 0, 1};
//		int[] dataArray = {0, 1, 2, 3, 4, 5};
		System.out.println(getTheMinAbs2(dataArray));
	}
	static int getTheMinAbs2 (int[] dataArray) {
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		int beginIndex = 0, endIndex = dataArray.length - 1, middleIndex = (beginIndex + endIndex) >> 1;
		while (beginIndex < endIndex) {
			if (dataArray[beginIndex] >= 0)
				return dataArray[beginIndex];
			if (dataArray[endIndex] <= 0)
				return dataArray[endIndex];
			if (dataArray[middleIndex] == 0)
				return 0;
			else if (dataArray[middleIndex] > 0) {
				if (middleIndex > 0 && dataArray[middleIndex - 1] <= 0) {
					if (Math.abs(dataArray[middleIndex]) > Math.abs(dataArray[middleIndex - 1]))
						return dataArray[middleIndex -1];
					else
						return dataArray[middleIndex];
				}
				endIndex = middleIndex;
			} else {
				if (middleIndex < dataArray.length - 1 && dataArray[middleIndex + 1] <= 0) {
					if (Math.abs(dataArray[middleIndex]) > Math.abs(dataArray[middleIndex + 1]))
						return dataArray[middleIndex + 1];
					else
						return dataArray[middleIndex];
				}
				beginIndex = middleIndex;
			}
			middleIndex = (beginIndex + endIndex) >> 1;
		}
		return dataArray[middleIndex];
	}
	static int getTheMinAbs (int[] dataArray) {
		//�������ʲ��ö��ַ�
		//�ⷽ������Ĵ����Ǵ��
		if (dataArray == null) {
			System.out.println("input is null");
			System.exit(0);
		}
		int beginIndex = 0, endIndex = dataArray.length - 1, middleIndex = (beginIndex + endIndex) >> 1;
		boolean isLeftDown = false, isRightUp = false;
		while (beginIndex < endIndex) {
			isLeftDown = false; isRightUp = false;
			if (middleIndex > 0) {
				if (dataArray[middleIndex - 1] * dataArray[middleIndex] <= 0) {
					if (Math.abs(dataArray[middleIndex - 1]) < Math.abs(dataArray[middleIndex]))
						return dataArray[middleIndex - 1];
					else
						return dataArray[middleIndex];
				}
				isLeftDown = Math.abs(dataArray[middleIndex - 1]) > Math.abs(dataArray[middleIndex]);
			}
			if (middleIndex < dataArray.length - 1) {
				if (dataArray[middleIndex + 1] * dataArray[middleIndex] <= 0) {
					if (Math.abs(dataArray[middleIndex + 1]) < Math.abs(dataArray[middleIndex]))
						return dataArray[middleIndex + 1];
					else
						return dataArray[middleIndex];
				}
				isRightUp = Math.abs(dataArray[middleIndex + 1]) > Math.abs(dataArray[middleIndex]);
			}
			if (isLeftDown && isRightUp)
				return dataArray[middleIndex];
			else if (isLeftDown && ! isRightUp)
				beginIndex = middleIndex;
			else if (isRightUp && ! isLeftDown)
				endIndex = middleIndex;
			else
				break;
		}
		if (isLeftDown)
			return dataArray[endIndex];
		if (isRightUp)
			return dataArray[beginIndex];
		return dataArray[middleIndex];
	}
}
