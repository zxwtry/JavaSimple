/*
一般而言，我们不会直接使用树形选择排序到实际工程中。因为这种方法需要额外的存储空间来建树。
但这种排序方法不失为练习逻辑能力的好机会；同时它也是堆排序思想的基础。
请写出树形选择排序的实现。
注意：
1. 树形的表达，未必使用真正的二叉树来表达，完全二叉树的父节点与孩子节点的序号有固定关系。用数组就可以了。
2. 根节点输出后，如何处理？寻找其值来源？很麻烦！可不可以在树的节点中不要存储值，只存待排序数组的元素序号？
 */

/*
 
 待排是2的n次方，不足用无穷大代替
 两两分组创建父节点
 选出之后设成无穷大
 
 */

package gaoXiaoBang;

import java.util.Arrays;

public class 第四章树形选择排序_写出树形选择排序的实现 {
	public static void main (String[] args) {
		int[] data =  {4,6,7,8,9,0,10,11,12,1,13,3,14,15,5,16,2};
		new TreeSel(data);
		for (int i = data.length-1; i >= 0; --i) {
			System.out.print(data[i]+"\t");
		}
	}
	static class TreeSel {
		private int[] dataSave, data ;
		private int changeIndex = Integer.MIN_VALUE;
		public TreeSel(int[] data){
			int lenFin = (int)Math.pow(2, (int)(Math.log10(data.length)/Math.log10(2))+2);
		    this.data = new int[lenFin-1];
		    System.arraycopy(data, 0, this.data, lenFin/2-1, data.length);
			Arrays.fill(this.data, data.length+lenFin/2-1, lenFin-1, Integer.MAX_VALUE);
			dataSave = data;
			afterSorted();
		}
		private void afterSorted(){
			for (int i = 0; i < dataSave.length; ++ i) {
				dataSave[i] = getMin();
			}
		}
		private int getMin(){
			if (changeIndex == Integer.MIN_VALUE) {
				for (int i = data.length-2; i > 0; i -= 2) {
					data[i/2] = Math.min(data[i], data[i+1]);
				}
			} else {
				while(changeIndex > 0) {
					changeIndex = (changeIndex+1)/2-1;
					data[changeIndex] = Math.min(data[(changeIndex+1)*2], data[(changeIndex+1)*2-1]);
				}
			}
			int dataSaveIndex = 0;
			while (dataSaveIndex < data.length/2) {
				dataSaveIndex = (data[dataSaveIndex*2+1] == data[dataSaveIndex] ? dataSaveIndex*2+1 : dataSaveIndex*2+2);
			}
			changeIndex = dataSaveIndex;
			data[dataSaveIndex] = Integer.MAX_VALUE;
			return data[0];
		}
//		private void show() {
//			for (int i = 0; i <data.length; ++ i) {
//				System.out.print(i+":"+this.data[i]+"\t");
//			}
//			System.out.println();
//		}
	}
}
