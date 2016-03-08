package jianZhiOffer;
/*
 * 对这种问题，需要注意一定要检验
 * 
 * 从快排的角度来看,会改变data的原先顺序
 * 从对消的角度来看
 */
public class 题29数组中出现次数超过一半的数字 {
	public static void main(String[] args) {
//		int[] data = {1, 4, 7, 9, 8, 7, 5, 3, 2};	//这个数据很神奇，会让我的快排进入死循环
		/*
		 * 对这个快排会出现死循环的分析：
		 * 这只是出现在有两个相同的元素前提下
		 * 如果在partition方法中，进行的比较是< 和 > 那毫无疑问，很容易出现死循环
		 * 解决办法同样十分简单，就是改成 <= 和 >=
		 * 这点一定要谨记
		 */
//		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//		quickSort(data, 0, data.length-1);
//		for(int a : data)
//			System.out.printf("%d ", a);
//		System.out.println();
		
		//以上是对quickSort的复习
		//已知有数据
//		int[] data = {1, 2, 3, 2, 2, 2, 2, 5, 4, 2};
		int[] data = {1, 1, 1, 1, 0, 0, 0, 0, 0};		//这组数据很奇怪，出现StackOverFlow；；是程序的问题,已经修复
//		int[] data = {0, 0, 0, 0, 0, 0, 0, 0, 0};		
//		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};		
			/*
			 * 栈溢出的解释：
			 * 错在代码进行了内嵌调用，但在方法内部出现（data， 0， data.length-1）的错误
			 */
		System.out.println(getTimesMoreThanHalf(data, 0, data.length -1));
		System.out.println(getTimesMoreThanHalf2(data, 0, data.length -1));
		//data中共有10个数字，其中2出现6次
		//需要定位出位于(0+data.length())/2，找到那一个数据即可
		//
	}
	public static int partition (int[] data, int beginIndex, int endIndex) {
		int rootData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && data[endIndex] >= rootData)   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex < endIndex && data[beginIndex] <= rootData) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = rootData;
		return beginIndex;
	}
	public static void quickSort (int[] data, int beginIndex, int endIndex) {
		if (data == null || data.length <=0 || beginIndex >= endIndex)  return;
		int pivot = specialForHalfPartition(data, beginIndex, endIndex);
		quickSort(data, beginIndex, pivot-1);
		quickSort(data, pivot+1, endIndex);
	}
	public static int getTimesMoreThanHalf (int[] data, int beginIndex, int endIndex) {
		//在特殊数据的条件下，会出现栈溢出
		//修改之后和getTimesMortThanHalf2是一样的
		if (data == null || data.length <= 0 || beginIndex > endIndex)   return Integer.MAX_VALUE;
		int pivot = specialForHalfPartition (data, beginIndex, endIndex);
		if (pivot > (data.length>>1))
			return getTimesMoreThanHalf (data, beginIndex, pivot-1);
		else if (pivot < (data.length>>1))
			return getTimesMoreThanHalf (data, pivot+1, endIndex);
		else 
			return checkIfReal(data, pivot) ? data[pivot] : Integer.MAX_VALUE;
	}
	public static int specialForHalfPartition (int[] data, int beginIndex, int endIndex) {
		int ramdonIndex = (int)(Math.random()*(endIndex-beginIndex)) + beginIndex;
		swap(data, beginIndex, ramdonIndex);
		int rootData = data[beginIndex];
		while (beginIndex < endIndex) {
			while (beginIndex < endIndex && data[endIndex] >= rootData)   --endIndex;
			data[beginIndex] = data[endIndex];
			while (beginIndex < endIndex && data[beginIndex] <= rootData) ++beginIndex;
			data[endIndex] = data[beginIndex];
		}
		data[beginIndex] = rootData;
		return beginIndex;
	}
	public static int getTimesMoreThanHalf2 (int[] data, int beginIndex, int endIndex) {
		//这个是书中的程序，对于{1, 1, 1, 1, 0, 0, 0, 0, 0};不会栈溢出
		if (data == null || data.length <= 0)   return Integer.MAX_VALUE;
		if (beginIndex > endIndex )   return Integer.MIN_VALUE;
		int middle = ((beginIndex + endIndex) >> 1);
		int index = specialForHalfPartition (data, beginIndex, endIndex);
		while (index != middle ) {
			if (index > middle) {
				endIndex = index - 1;
				index = specialForHalfPartition (data, beginIndex, endIndex);
			} else {
				beginIndex = index + 1;
				index = specialForHalfPartition (data, beginIndex, endIndex);
			}
		}
		int result = data[middle];
		return checkIfReal(data, middle) ? result : Integer.MAX_VALUE;
	}
	private static void swap (int[] data ,int index1, int index2) {
		int tmp = data[index1];
		data[index1] = data[index2];
		data[index2] = tmp;
	}
	private static boolean checkIfReal (int[] data, int middleValueIndex) {
		int dataValue = data[middleValueIndex];
		int times = 0;
		for (int i = 0; i < data.length; i ++) {
			if (data[i] == dataValue)
				times ++;
		}
		return times > ( data.length >> 1 );
	}
}
