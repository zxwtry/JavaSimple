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
		//插入排序算法思想:每趟将一个元素,按期关键字值的大小插入到它前面已排序的子序列。
		//插入排序算法有直接插入排序，二分法插入排序和希尔排序
		
		//直接插入排序straightInsertionSort
		//最好情况：{1, 2, 3, 4, 5}     	比较n-1         次，移动2(n-1)次，时间复杂度N
		//最坏情况：{5, 4, 3, 2, 1}  	每趟	比较i      次，移动i+2      次， 时间复杂度N2
		//随机情况：等概率下面		         每趟	比较(i+1)/2次，移动i/2      次， 时间复杂度N2
		//空间复杂度1		稳定性：compareTo没有等号稳定；有等号不稳定
		public static <T extends Comparable <? super T>> void straightInsertionSort (T[] array, int low, int high, boolean isSortUp) {
			for (int i = low; i <= high; i ++) {	//n-1趟扫描，依次向前插入n-1个数
				T temp = array[i];
				int j;
				for (j = i-1; j >= low && (isSortUp ? temp.compareTo(array[j]) < 0 : temp.compareTo(array[j]) > 0); j --) 
					array[j+1] = array[j];			//将前面较大的元素向后移动
				array[j+1] = temp;					//temp值到达插入位置
			}
		}
		
		//二分法插入排序bisectionSort
		//最好情况：{1, 2, 3, 4, 5}     	比较n-1         次，移动2(n-1)次，时间复杂度N
		//最坏情况：{5, 4, 3, 2, 1}  	每趟	比较i      次，移动i+2      次， 时间复杂度N2
		//随机情况：等概率下面		         每趟	比较(i+1)/2次，移动i/2      次， 时间复杂度N2
		//空间复杂度1		稳定性：
		
		
		//希尔排序shellSort
		//最好情况：{1, 2, 3, 4, 5}     	比较n-1         次，移动2(n-1)次，时间复杂度N
		//最坏情况：{5, 4, 3, 2, 1}  	每趟	比较i      次，移动i+2      次， 时间复杂度N2
		//随机情况：等概率下面		         每趟	比较(i+1)/2次，移动i/2      次， 时间复杂度N2
		//空间复杂度1		稳定性：不稳定
		public static <T extends Comparable <? super T>> void shellSort (T[] array, int low, int high, boolean isSortUp) {
			for (int delta = (high - low + 1) / 2; delta > 0; delta /= 2) {		//若干趟，控制增量每趟减半
				for (int i = delta + low; i <= high; i ++) {			//一趟分若干组，每组直接插入排序
					T temp = array[i];
					int j;
					for (j = i-delta; j >= low && (isSortUp ? temp.compareTo(array[j]) < 0 : temp.compareTo(array[j]) > 0); j -= delta) 
						array[j + delta] = array[j];					//每组元素相距delta远
					array[j + delta] = temp;
				}
			}
		}
		
		
		//基于交换的排序算法有两种：冒泡排序和快速排序
		
		//冒泡排序bubbleSort
		//最好情况：{1, 2, 3, 4, 5}  一趟成功 	比较n      次，移动0      次，时间复杂度N
		//最坏情况：{5, 4, 3, 2, 1} n-1趟成功	比较N2           次，移动N2    次， 时间复杂度N2
		//随机情况：等概率下面		      		比较N2           次，移动N2    次， 时间复杂度N2
		//空间复杂度1		稳定性：compareTo没有等号稳定；有等号不稳定
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
		
		//冒泡排序quickSort
		//最好情况：{1, 2, 3, 4, 5}  一趟成功 	比较n      次，移动0      次，时间复杂度N
		//最坏情况：{5, 4, 3, 2, 1} n-1趟成功	比较N2           次，移动N2    次， 时间复杂度N2
		//随机情况：等概率下面		      		比较N2           次，移动N2    次， 时间复杂度N2
		//空间复杂度1		稳定性：compareTo没有等号稳定；有等号不稳定
		public static <T extends Comparable <? super T>> void quickSort (T[] array, int low, int high, boolean isSortUp) {
			if (high - low < 1) return;
			T vot = array[low];			//标尺
			int lowTemp = low, highTemp = high;
			boolean direction = true;	//比较方向
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
					System.out.println("碰到奇数" + tmp);
				}
				tmp -= 3;
			}
	}
}
