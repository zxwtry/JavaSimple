package sample;

import org.junit.Test;

public class SortSample {
	public static void main (String[] args) {
		Integer array[] = {3, 2, 4, 1, 0, 5};
//		String array[] = {"AAA","BBB","CCC","DDD"};
//		ArraysMySort.straightInsertionSort(array, 0, array.length-1, false);
//		ArraysMySort.straightInsertionSort(array, 1, 4, false);
//		ArraysMySort.shellSort(array, 0, array.length-1, true);
//		ArraysMySort.shellSort(array, 1, 4, true);
//		ArraysMySort.bubbleSort(array, 1, 4, false);
//		ArraysMySort.quickSort(array, 0, array.length - 1, true);
//		ArraysMySort.quickSort(array, 1, 6, true);
		ArraysMySort.quickSort(array, 0, array.length - 1, true);
		ArraysMySort.printArray(array);
	}
	static class ArraysMySort {
		//���������㷨˼��:ÿ�˽�һ��Ԫ��,���ڹؼ���ֵ�Ĵ�С���뵽��ǰ��������������С�
		//���������㷨��ֱ�Ӳ������򣬶��ַ����������ϣ������
		
		//ֱ�Ӳ�������straightInsertionSort
		//��������{1, 2, 3, 4, 5}     	�Ƚ�n-1         �Σ��ƶ�2(n-1)�Σ�ʱ�临�Ӷ�N
		//������{5, 4, 3, 2, 1}  	ÿ��	�Ƚ�i      �Σ��ƶ�i+2      �Σ� ʱ�临�Ӷ�N2
		//���������ȸ�������		         ÿ��	�Ƚ�(i+1)/2�Σ��ƶ�i/2      �Σ� ʱ�临�Ӷ�N2
		//�ռ临�Ӷ�1		�ȶ��ԣ�compareToû�еȺ��ȶ����еȺŲ��ȶ�
		public static <T extends Comparable <? super T>> void straightInsertionSort (T[] array, int low, int high, boolean isSortUp) {
			for (int i = low; i <= high; i ++) {	//n-1��ɨ�裬������ǰ����n-1����
				T temp = array[i];
				int j;
				for (j = i-1; j >= low && (isSortUp ? temp.compareTo(array[j]) < 0 : temp.compareTo(array[j]) > 0); j --) 
					array[j+1] = array[j];			//��ǰ��ϴ��Ԫ������ƶ�
				array[j+1] = temp;					//tempֵ�������λ��
			}
		}
		
		//���ַ���������bisectionSort
		//��������{1, 2, 3, 4, 5}     	�Ƚ�n-1         �Σ��ƶ�2(n-1)�Σ�ʱ�临�Ӷ�N
		//������{5, 4, 3, 2, 1}  	ÿ��	�Ƚ�i      �Σ��ƶ�i+2      �Σ� ʱ�临�Ӷ�N2
		//���������ȸ�������		         ÿ��	�Ƚ�(i+1)/2�Σ��ƶ�i/2      �Σ� ʱ�临�Ӷ�N2
		//�ռ临�Ӷ�1		�ȶ��ԣ�
		
		
		//ϣ������shellSort
		//��������{1, 2, 3, 4, 5}     	�Ƚ�n-1         �Σ��ƶ�2(n-1)�Σ�ʱ�临�Ӷ�N
		//������{5, 4, 3, 2, 1}  	ÿ��	�Ƚ�i      �Σ��ƶ�i+2      �Σ� ʱ�临�Ӷ�N2
		//���������ȸ�������		         ÿ��	�Ƚ�(i+1)/2�Σ��ƶ�i/2      �Σ� ʱ�临�Ӷ�N2
		//�ռ临�Ӷ�1		�ȶ��ԣ����ȶ�
		public static <T extends Comparable <? super T>> void shellSort (T[] array, int low, int high, boolean isSortUp) {
			for (int delta = (high - low + 1) / 2; delta > 0; delta /= 2) {		//�����ˣ���������ÿ�˼���
				for (int i = delta + low; i <= high; i ++) {			//һ�˷������飬ÿ��ֱ�Ӳ�������
					T temp = array[i];
					int j;
					for (j = i-delta; j >= low && (isSortUp ? temp.compareTo(array[j]) < 0 : temp.compareTo(array[j]) > 0); j -= delta) 
						array[j + delta] = array[j];					//ÿ��Ԫ�����deltaԶ
					array[j + delta] = temp;
				}
			}
		}
		
		
		//���ڽ����������㷨�����֣�ð������Ϳ�������
		
		//ð������bubbleSort
		//��������{1, 2, 3, 4, 5}  һ�˳ɹ� 	�Ƚ�n      �Σ��ƶ�0      �Σ�ʱ�临�Ӷ�N
		//������{5, 4, 3, 2, 1} n-1�˳ɹ�	�Ƚ�N2           �Σ��ƶ�N2    �Σ� ʱ�临�Ӷ�N2
		//���������ȸ�������		      		�Ƚ�N2           �Σ��ƶ�N2    �Σ� ʱ�临�Ӷ�N2
		//�ռ临�Ӷ�1		�ȶ��ԣ�compareToû�еȺ��ȶ����еȺŲ��ȶ�
		public static <T extends Comparable <? super T>> void bubbleSort (T[] array, int low, int high, boolean isSortUp) {
			boolean isChanged = true;
			for (int i = low + 1; i <= high && isChanged; i ++) {
				isChanged = false;
				for (int j = low; j <= high - i + low; j ++)
					if (isSortUp ? array[j].compareTo(array[j+1]) > 0 : array[j].compareTo(array[j+1]) < 0) {
						T temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
						isChanged = true;
					}
			}
		}
		
		//ð������quickSort
		//��������{1, 2, 3, 4, 5}  һ�˳ɹ� 	�Ƚ�n      �Σ��ƶ�0      �Σ�ʱ�临�Ӷ�N
		//������{5, 4, 3, 2, 1} n-1�˳ɹ�	�Ƚ�N2           �Σ��ƶ�N2    �Σ� ʱ�临�Ӷ�N2
		//���������ȸ�������		      		�Ƚ�N2           �Σ��ƶ�N2    �Σ� ʱ�临�Ӷ�N2
		//�ռ临�Ӷ�1		�ȶ��ԣ�compareToû�еȺ��ȶ����еȺŲ��ȶ�
		public static <T extends Comparable <? super T>> void quickSort (T[] array, int low, int high, boolean isSortUp) {
			if (high - low < 1) return;
			T vot = array[low];			//���
			int lowTemp = low, highTemp = high;
			boolean direction = true;	//�ȽϷ���
L1:			while (lowTemp < highTemp) {
				if (direction) {
					for (int i = highTemp; i > lowTemp; i --) {
						if (isSortUp ? array[i].compareTo(vot) <= 0 : array[i].compareTo(vot) >= 0) {
							array[lowTemp ++] = array[i];
							highTemp = i;
							direction = !direction;
							continue L1;
						}//end if
					}//end for
					highTemp = lowTemp;
				} else {
					for (int i = lowTemp; i < highTemp; i ++) {
						if (isSortUp ? array[i].compareTo(vot) >= 0 : array[i].compareTo(vot) <= 0) {
							array[highTemp --] = array[i];
							lowTemp = i;
							direction = !direction;
							continue L1;
						}//end if
					}//end for
					lowTemp = highTemp;
				}//end else
			}//end while
			array[lowTemp] = vot;
			quickSort(array, low, lowTemp - 1, isSortUp);
			quickSort(array, lowTemp + 1, high, isSortUp);
		}
		
		
		public static <T extends Comparable <? super T>> void printArray (T[] array) {
			for (int i = 0; i < array.length - 1; i ++) {
				System.out.print(array[i]+"\t");
			}
			System.out.println(array[array.length - 1]);
		}
	}
	
	@Test
	public void testContinue () {
			int tmp = 10;
LTestCont: 	while (tmp > 0) {
				System.out.println(tmp);
				if (tmp -- % 2 == 0) {
					continue LTestCont;
				} else {
					System.out.println("��������" + tmp);
				}
				tmp -= 3;
			}
	}
}
