package book.offer;

import org.junit.Test;

/*
 * �������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * {7, 5, 6, 4}һ����5������ԣ��ֱ���(7,6) (7,5) (7,4) (6,4) (5,4)
 */
public class ��36�����е������ {
	public static void main(String[] args) {
		int[] data = {7, 5, 6, 4};
		System.out.println(inversePairs(data, 0, data.length-1));
	}
	public static void mergeSortDivide (int[] data, int beginIndex, int endIndex) {
		if (data == null || beginIndex >= endIndex)   return;
		int mid = (beginIndex+endIndex) >> 1;
		mergeSortDivide(data, beginIndex, mid);
		mergeSortDivide(data, mid+1, endIndex);
	}
	public static int inversePairs (int[] data, int beginIndex, int endIndex) {
		if (data == null || beginIndex > endIndex)   return 0;
		int[] copy = new int[endIndex-beginIndex+1];
		System.arraycopy(data, beginIndex, copy, 0, endIndex-beginIndex+1);
		int count = inversePairs(data, copy, 0, copy.length-1);
		return count;
	}
	private static int inversePairs (int[] data, int[] copy, int beginIndex, int endIndex) {
		if (beginIndex == endIndex) {
			copy[beginIndex] = data[beginIndex];
			return 0;
		}
		int length = (endIndex - beginIndex) >> 1;
		int left = inversePairs (copy, data, beginIndex, beginIndex+length);
		int right = inversePairs (copy, data, beginIndex+length+1, endIndex);
		//i��ʼ��Ϊǰ������һ�����ֵ��±�
		int i = beginIndex + length;
		//j��ʼ��Ϊ�������һ�����ֵ��±�
		int j = endIndex;
		int indexCopy = endIndex;
		int count = 0;
		while (i >= beginIndex && j >= beginIndex+length+1) {
			if (data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j-beginIndex-length;
			} else {
				copy[indexCopy--] = data[j--];
			}
		}
		for (; i >= beginIndex; -- i) 
			copy[indexCopy--] = data[i];
		for (; j >= beginIndex+length+1; --j)
			copy[indexCopy--] = data[j];
		return left+right+count;
	}
	
	@Test
	public void testMergeSort () {
		int[] dataArray1 = {1, 2, 3, 4, 5};
		int[] dataArray2 = {0, 0, 3, 4, 50, 51, 52};
		int[] result = mergeSort(dataArray1, 0, dataArray1.length-1, dataArray2, 0, dataArray2.length-1);
		for (int a : result)
			System.out.print(a + "\t");
		System.out.println();
	}
	//��дһ���鲢����
	public static int[] mergeSort (int[] dataArray1, int beginIndex1, int endIndex1,
								     int[] dataArray2, int beginIndex2, int endIndex2) {
		//��С��������
		if (dataArray1 == null)
			return dataArray2;
		if (dataArray2 == null)
			return dataArray1;
		int[] returnArray = new int[dataArray1.length + dataArray2.length];
		int array1Index = beginIndex1, array2Index = beginIndex2, returnIndex = 0;
		while (array1Index<=endIndex1 && dataArray2[beginIndex2] > dataArray1[array1Index]) {
			returnArray[returnIndex ++] = dataArray1[array1Index ++];
		}
		while (array2Index<=endIndex2 && dataArray1[beginIndex1] > dataArray2[array2Index]) {
			returnArray[returnIndex ++] = dataArray2[array2Index ++];
		}
		while (array1Index<=endIndex1 && array2Index<=endIndex2) {
			if (dataArray1[array1Index] < dataArray2[array2Index]) {
				returnArray[returnIndex++] = dataArray1[array1Index ++];
			} else {
				returnArray[returnIndex++] = dataArray2[array2Index ++];
			}
		}
		while (array1Index <= endIndex1) {
			returnArray[returnIndex++] = dataArray1[array1Index ++];
		}
		while (array2Index <= endIndex2) {
			returnArray[returnIndex++] = dataArray2[array2Index ++];
		}
		return returnArray;
	}
	//����Ե�˼����ǹ鲢����
	public static void findInverseNum (int[] dataArray) {
		
	}
}






























