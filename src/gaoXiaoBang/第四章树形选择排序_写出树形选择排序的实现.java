/*
һ����ԣ����ǲ���ֱ��ʹ������ѡ������ʵ�ʹ����С���Ϊ���ַ�����Ҫ����Ĵ洢�ռ���������
���������򷽷���ʧΪ��ϰ�߼������ĺû��᣻ͬʱ��Ҳ�Ƕ�����˼��Ļ�����
��д������ѡ�������ʵ�֡�
ע�⣺
1. ���εı�δ��ʹ�������Ķ�����������ȫ�������ĸ��ڵ��뺢�ӽڵ������й̶���ϵ��������Ϳ����ˡ�
2. ���ڵ��������δ���Ѱ����ֵ��Դ�����鷳���ɲ����������Ľڵ��в�Ҫ�洢ֵ��ֻ������������Ԫ����ţ�
 */

/*
 
 ������2��n�η�����������������
 �������鴴�����ڵ�
 ѡ��֮����������
 
 */

package gaoXiaoBang;

import java.util.Arrays;

public class ����������ѡ������_д������ѡ�������ʵ�� {
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
