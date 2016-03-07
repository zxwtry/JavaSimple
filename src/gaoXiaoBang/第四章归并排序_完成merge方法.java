/*
�ڹ��������У����Դ������ݽ��������ʱ�����������Ƿ��������еġ�

��ʱ����������ҪһЩ��Ų�ļ��ɡ�һ����ʹ��һ����ʱ������ռ䱣���м������ź����Ժ��ٿ�����ԭ�������顣

����Ĵ����ǲ��õݹ��˼����еݹ�����ġ������merge������

// ��data�����е� [a,b) ��������ݽ��й鲢����
// ���������[a,b)�����ݴ�����������״̬
static void mergeSort(int[] data, int a,int b)
{
if (a >= b) return;

int mid=(a+b)/2;

mergeSort(a,mid);
mergeSort(mid+1,b);

merge(a,mid,b);

// data�е�����, [low,mid), [mid,high) �����δ��鲢���ݡ��鲢��[low,high) ��������
static void merge(int[] data, int low,int mid,int high) {
	int[] tmp = new int[high-low];
}
 */


package gaoXiaoBang;

public class �����¹鲢����_���merge���� {
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
