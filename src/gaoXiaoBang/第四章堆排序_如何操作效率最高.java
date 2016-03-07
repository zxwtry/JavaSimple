/*
 堆的特征是每个节点的值不大于其孩子节点的值。

假设现在有一个已经建好的堆。

这时，需要把一个新元素加入进来，

同时仍然保持着堆的性质，该如何操作效率最高？
 */

package gaoXiaoBang;

public class 第四章堆排序_如何操作效率最高 {
	public static void main (String[] args) {
//		int[] data = {1,3,4,5,6,2,7,8,0,9};
		int[] data = {12,3,6,8,5,19,20,16,4,2,7,13,9,11};
		myHeap my = new myHeap(data);
//		my.heapSort(data);
		my.addAnEle(99, 0);
	}
	static class myHeap {
		private int[] dataSave;
		public myHeap(int[] data){
			dataSave = data;
		}
		public int[] addAnEle(int data, int index) {
			for (int i = dataSave.length/2; i >= 0; -- i) {
				heapOne(dataSave, dataSave.length, i);
			}
			int[] dataReturn = new int[dataSave.length + 1];
			System.arraycopy(dataSave, 0, dataReturn, 1, dataSave.length);
			dataReturn[0] = data;
			show(dataReturn);
			heapOne(dataReturn, dataReturn.length, 0);
			show(dataReturn);
			return dataReturn;
		}
		public void heapSort() {
			for (int i = dataSave.length/2; i >= 0; -- i) {
				heapOne(dataSave, dataSave.length, i);
			}
			int index = dataSave.length;
			while (index > 0) {
				System.out.print(dataSave[0]+" ");
				dataSave[0] = dataSave[index-1];
				-- index;
				heapOne(dataSave, index, 0);
			}
			System.out.println();
		}
		private void heapOne(int[] data, int index, int key) {
			int k1 = 2*key + 1;
			int k2 = 2*key + 2;
			if (k1>=index && k2>=index)    return;
			
			int a1 = k1 < index ? data[k1] : Integer.MAX_VALUE;
			int a2 = k2 < index ? data[k2] : Integer.MAX_VALUE;
			
			if (data[key]<a1 && data[key]<a2)    return;
			
			if (a1 < a2) {
				data[key] = data[k1] ^ data[key];
				data[k1]  = data[k1] ^ data[key];
				data[key] = data[k1] ^ data[key];
				heapOne(data, index, k1);
			} else {
				data[key] = data[k2] ^ data[key];
				data[k2]  = data[k2] ^ data[key];
				data[key] = data[k2] ^ data[key];
				heapOne(data, index, k2);
			}
		}
		private void show(int[] data) {
			for (int i = 0; i < data.length; ++ i)    System.out.print(data[i]+" ");
			System.out.println();
		}
	}
}
