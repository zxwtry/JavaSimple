/*
低关键字优先的基数排序算法很有创新。

请对整数序列进行排序。

随机产生1000个整数，其中整数的范围0~9999

可以用十进制的每个位为关键字。排序时使用十个动态数组为临时空间，进行分配和收集。

采用低关键字优先的基数排序完成对整数序列的排序任务。

注意体会仅仅依靠分配、收集的手段即可完成排序。
 */

package gaoXiaoBang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 第四章链式基数排序_对整数序列进行排序 {
	//在视频中使用的是LinkedList，现在使用的是ArrayList，差别不大。
	public static void main(String[] args) {
		myLSD my = new myLSD();
		my.genRandom(1000, 0, 9999, 1);
	}
	static class myLSD {
		public myLSD(){}
		public void genRandom(int num, int begin, int end, int range) {
			List<int[]> list = new ArrayList<int[]>();
			for (int i = 0; i < num; ++ i) {
				list.add(getEach((((int)(Math.random()*(end-begin+range)))/range)*range+begin, 4, 10));
			}
			List<int[]> ans = oneOfLSD(oneOfLSD(oneOfLSD(oneOfLSD(list, 3, 10), 2, 10), 1, 10), 0, 10);
			Iterator<int[]> it = ans.iterator();
			while(it.hasNext()) {
				int[] tmp = it.next();
				System.out.printf("%d %d %d %d \n",tmp[0],tmp[1],tmp[2],tmp[3]);
			}
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private List<int[]> oneOfLSD(List<int[]> list, int weiShu, int jinZhi) {
			List[] tmp = new List[jinZhi];
			for (int i = 0; i < jinZhi; ++ i) {
				tmp[i] = new ArrayList<int[]>();
			}
			Iterator<int[]> it = list.iterator();
			while (it.hasNext()) {
				int[] itTemp = it.next();
				tmp[itTemp[weiShu]].add(itTemp);
				it.remove();
			}
			for (int i = 0; i < jinZhi; ++ i) {
				Iterator<int[]> itTemp = tmp[i].iterator();
				while(itTemp.hasNext()) {
					list.add(itTemp.next());
				}
			}
			return list;
		}
		private int[] getEach(int data, int weiShu, int jinZhi) {
			int[] re = new int[weiShu];
			for (int i = weiShu-1; i >= 0; -- i) {
				re[i] = data%jinZhi;
				data = data/jinZhi;
			}
			return re;
		}
	}
}
