package gaoXiaoBang;

/*

问题
取最小值
选择排序中需要选出最小的元素。
它使用的是擂台赛的方法获得最小元素。
现在假设要同时获得最小和次小元素（赛出：冠军和亚军），该如何操作？

 */


public class 算法56简单选择排序_取最小值 {
	public static void main(String[] args) {
		int[] data = {1, 6, 4, 2, 3, 7, 5};
		MaxTwo max = selectSort(data, 0, data.length-1);
		if (max == null) {
			System.out.println("输入数据有误");
		} else if (max.firstIndex == max.secondIndex) {
			System.out.println("只找到一个是："+data[max.firstIndex]);
		} else {
			System.out.println(data[max.firstIndex]+" "+data[max.secondIndex]);
		}
	}
	
	private static MaxTwo selectSort(int[] data, int begin, int end) {
		if (begin > end || data == null)   return null;
		if (begin == end) {
			return new MaxTwo(begin, end);
		}
		MaxTwo ansReturn = new MaxTwo(begin, begin+1);
		for (int index = begin; index <= end; ++ index) {
			if (data[ansReturn.firstIndex] < data[index]) {
				ansReturn.firstIndex = index;
			}
			if (data[ansReturn.secondIndex] < data[index] && 
					index != ansReturn.firstIndex) {
				ansReturn.secondIndex = index;
			}
		}
		return ansReturn;
	}
	
	static class MaxTwo {
		int firstIndex, secondIndex;
		public MaxTwo () {}
		public MaxTwo (int firstIndex, int secondIndex) {
			this.firstIndex = firstIndex;
			this.secondIndex = secondIndex;
		}
	}
}
