/*
在工程问题中，当对大量数据进行排序的时候，数据往往是放在数组中的。

这时进行排序需要一些腾挪的技巧。一般是使用一个临时的数组空间保存中间结果，排好序以后，再拷贝回原来的数组。

下面的代码是采用递归的思想进行递归排序的。请完成merge方法。

// 对data数组中的 [a,b) 区间的数据进行归并排序，
// 排序结束后，[a,b)间数据处于升序有序状态
static void mergeSort(int[] data, int a,int b)
{
if (a >= b) return;

int mid=(a+b)/2;

mergeSort(a,mid);
mergeSort(mid+1,b);

merge(a,mid,b);

// data中的数据, [low,mid), [mid,high) 是两段待归并数据。归并后，[low,high) 整体有序
static void merge(int[] data, int low,int mid,int high) {
	int[] tmp = new int[high-low];
}
 */


package gaoXiaoBang;

public class 第四章归并排序_完成merge方法 {
	public static void main(String[] args) {
		int[] data = {1,3,5,7,2,4,6,8};
//		int[] data = {1,2,3,4,5,6,7,8};
		mergeSort(data,0,8);
		for (int i = data.length-1; i >= 0; --i)
			System.out.print(data[i]);
	}
	static void mergeSort(int[] data, int a, int b) {
		if (a >= b) return;
		int mid = (a+b)/2;
		mergeSort(data, a, mid);
		mergeSort(data, mid+1, b);
		merge(data, a, mid, b);
	}
	static void merge(int[] data, int low, int mid, int high) {
		int[] dataTemp = new int[high-low];
		int index = 0,midSave = mid,lowSave = low;
		while (low<midSave && mid<high) {
			dataTemp[index++] = (data[low] <= data[mid] ? data[low++] : data[mid++]);
		}
//		while (low < midSave)   dataTemp[index++]=data[low++];
//		while (mid < high)      dataTemp[index++]=data[mid++];
		if (low != midSave) {
			System.arraycopy(data, low, dataTemp, index, midSave-low);
		} else if (mid != high) {
			System.arraycopy(data, mid, dataTemp, index, high-mid);
		}
		System.arraycopy(dataTemp, 0, data, lowSave, high-lowSave);
	}
}
