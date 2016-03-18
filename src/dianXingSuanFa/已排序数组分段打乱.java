package dianXingSuanFa;

/*
 * 一个已经排序好的很大的数组(长度n)，现在给她划分成m段，每段长度最长为k，然后段内打乱，
 * 请设计一个算法对其进行重新排序时间复杂度小于O(n*lgk)
 * 
 * 补充：堆排序只使用了常数个辅助单元，空间复杂度O(1)
 * 		堆排序，(长度为n的数组)建堆时间为O(n)，之后有n-1次向下
 * 			   调整操作，每次调整的事件复杂度为O(h)，最好最坏平均的
 * 			   时间复杂度为n*lgn
 * 
 * 对每个段进行堆排序，时间复杂度是k*lgk，m段都相加得到n*lgk，符合要求
 */
public class 已排序数组分段打乱 {
	static class MinHeap {
		private int[] values;
		private int lastIndex;
		public MinHeap (int[] values) {
			init(values);
		}
		public void reheap () {
			reheapCore (0, values.length - 1);
		}
		public int getRootVale () {
			return values[0];
		}
		public void replaceRootValueWith (int newRootValue) {
			values[0] = newRootValue;
		}
		public void minimize () {
			if (lastIndex > 0) {
				this.replaceRootValueWith(values[lastIndex]);
				lastIndex --;
				this.reheapCore(0, lastIndex);
			}
		}
		private void init (int[] values) {
			int size = values.length;
			this.lastIndex = size - 1;
			this.values = new int[size];
			System.arraycopy(values, 0, this.values, 0, size);
			int lastIndex = size - 1;
			int lastRootIndex = getRootIndex (lastIndex);
			for (int rootIndex = lastRootIndex; rootIndex >= 0; rootIndex --) {
				reheapCore (rootIndex, lastIndex);
			}
		}
		private int getRootIndex (int lastIndex) {
			return (lastIndex - 1) >> 1;
		}
		private void reheapCore (int rootIndex, int lastIndex) {
			if (!(isValidIndex(rootIndex) && isValidIndex(lastIndex))) {
				System.out.println("invalid parameters");
				return;
			}
			int leftIndex = getLeftIndex(rootIndex);
			boolean done = false;
			while (!done && leftIndex <= lastIndex) {
				int rightIndex = getRightIndex (rootIndex);
				int smallerIndex = leftIndex;
				if (rightIndex <= lastIndex && values[rightIndex] < values[leftIndex]) {
					smallerIndex = rightIndex;
				}
				if (values[smallerIndex] < values[rootIndex]) {
					swap (values, smallerIndex, rootIndex);
					rootIndex = smallerIndex;
					leftIndex = getLeftIndex (rootIndex);
				} else {
					done = true;
				}
			}
		}
		private boolean isValidIndex (int index) {
			return index >= 0 && index < values.length;
		}
		private int getLeftIndex (int rootIndex) {
			return rootIndex << 1 + 1;
		}
		private int getRightIndex (int rootIndex) {
			return rootIndex << 1 + 2;
		}
		private void swap (int[] values, int index1, int index2) {
			if (index1 < 0 || index1 >= values.length || index1 < 0 || index1 >= values.length) {
				System.out.printf("index : %d %d is invalid index", index1, index2);
				System.exit(0);
			}
			int temp = values [index1];
			values [index1] = values [index2];
			values [index2] = temp;
		}
	}
	

	
	
	static class MyHeapSort {
		int[] dataArray;
		public MyHeapSort (int[] dataArray) {
			this.dataArray = dataArray;
			buildMaxHeap();
		}
		private void buildMaxHeap () {
			getSwapIndex (0, 2, 1);
			getParentIndex (0);
			swap (0, 1);
		}
		private int getSwapIndex (int rootIndex, int childLeftIndex, int childRightIndex) {
			int returnIndex = rootIndex;
			if (isMaxHeapCompare(childLeftIndex, returnIndex))
				returnIndex = childLeftIndex;
			if (isMaxHeapCompare(childRightIndex, returnIndex))
				returnIndex = childRightIndex;
			return returnIndex;
		}
		private boolean isMaxHeapCompare (int firstIndex, int secondIndex) {
			return dataArray[firstIndex] > dataArray[secondIndex];
		}
		private int getParentIndex (int index) {
			return (index -1) >> 1;
		}
		private void swap (int firstIndex, int secondIndex) {
			if (firstIndex == secondIndex)   return;
			int tempData = dataArray[firstIndex];
			dataArray[firstIndex] = dataArray[secondIndex];
			dataArray[secondIndex] = tempData;
		}
	}
	
	public static void main(String[] args) {
//		int[][] array = {{9, 7, 8},
//						 {0, 3, 2, 1},
//						 {4, 5, 6}};
//		
	}
	
	static class MyHeap1 {
		private int[] dataArray;
		private int endValuableIndex;
		public MyHeap1 (int[] dataArray) {
			this.dataArray = dataArray;
			this.endValuableIndex = dataArray.length - 1;
			buildMaxHeap5();
		}
		void buildMaxHeap () {
			int alertRootIndex, rootDataValue, alertIndex;
			for (int rootIndex = (endValuableIndex-1) >> 1; rootIndex >= 0; rootIndex --) {
				alertRootIndex = rootIndex;
				rootDataValue = dataArray[alertRootIndex];
				for (alertIndex = (rootIndex << 1) + 1; alertIndex <= endValuableIndex; alertIndex = (alertIndex << 1) + 1) {
					if (alertIndex < endValuableIndex && dataArray[alertIndex] < dataArray[alertIndex + 1])
						alertIndex ++;
					if (rootDataValue < dataArray[alertIndex]) {
						dataArray[alertRootIndex] = dataArray[alertIndex];
						alertRootIndex = alertIndex;
					} else break;
				}
				dataArray[alertRootIndex] = rootDataValue;
			}
		}
		void buildMaxHeap2 () {
			int rootDataValue, alertIndex, alertRootIndex;
			for ( int rootIndex = (endValuableIndex-1) >> 1; rootIndex >= 0; rootIndex --) {
				alertRootIndex = rootIndex;
				rootDataValue = dataArray[alertRootIndex];
				for (alertIndex = (rootIndex << 1) + 1; alertIndex <= endValuableIndex; alertIndex = (alertIndex << 1) + 1) {
					if (alertIndex < endValuableIndex && dataArray[alertIndex] < dataArray[alertIndex + 1])
						alertIndex ++;
					if (rootDataValue < dataArray[alertIndex]) {
						dataArray[alertRootIndex] = dataArray[alertIndex];
						alertRootIndex = alertIndex;
					} else break;
					dataArray[alertRootIndex] = rootDataValue;
				}
			}
		}
		void buildMaxHeap3 () {
			int rootIndex, rootValue, alertRootIndex, alertTravelIndex;
			for (rootIndex = (endValuableIndex - 1) >> 1; rootIndex >= 0; rootIndex --) {
				alertRootIndex = rootIndex;
				rootValue = dataArray[alertRootIndex];
				for (alertTravelIndex = (alertRootIndex << 1) + 1; alertTravelIndex <= endValuableIndex; alertTravelIndex = (alertTravelIndex << 1) + 1) {
					if (alertTravelIndex < endValuableIndex && dataArray[alertTravelIndex] < dataArray[alertTravelIndex + 1])
						alertTravelIndex ++;
					if (rootValue < dataArray[alertTravelIndex]) {
						dataArray[alertRootIndex] = dataArray[alertTravelIndex];
						alertRootIndex = alertTravelIndex;
					} else break;
				}
				dataArray[alertRootIndex] = rootValue;
			}
		}
		void buildMaxHeap4 () {
			int rootIndex, rootValue, alertRootIndex, alertTravelIndex;
			for (rootIndex = (endValuableIndex - 1) >> 1; rootIndex >= 0; rootIndex --) {
				rootValue = dataArray[rootIndex];
				alertRootIndex = rootIndex;
				for (alertTravelIndex = (alertRootIndex << 1) + 1; alertTravelIndex <= endValuableIndex; alertTravelIndex = (alertTravelIndex << 1) + 1) {
					if (alertTravelIndex < endValuableIndex && dataArray[alertTravelIndex] < dataArray[alertTravelIndex + 1])
						alertTravelIndex ++;
					if (rootValue < dataArray[alertTravelIndex]) {
						dataArray[alertRootIndex] = dataArray[alertTravelIndex];
						alertRootIndex = alertTravelIndex;
					} else break;
				}
				dataArray[alertRootIndex] = rootValue;
			}
		}
		void buildMaxHeap5 () {
			int rootIndex, rootValue, alertRootIndex, alertTravelIndex;
			//	 非叶子节点	暂存数据		rootIndex分身	依规则进行
			for (rootIndex = (endValuableIndex - 1) >> 1; rootIndex >= 0; rootIndex --) {
				rootValue = dataArray[rootIndex];
				alertRootIndex = rootIndex;
				for (alertTravelIndex = (alertRootIndex << 1) + 1; alertTravelIndex <= endValuableIndex; alertTravelIndex = (alertTravelIndex << 1) + 1) {
					if (alertTravelIndex < endValuableIndex && dataArray[alertTravelIndex] < dataArray[alertTravelIndex  + 1])
						alertTravelIndex ++;
					if (rootValue < dataArray[alertTravelIndex]) {
						dataArray[alertRootIndex] = dataArray[alertTravelIndex];
						alertRootIndex = alertTravelIndex;
					} else break;
				}
				dataArray[alertRootIndex] = rootValue;
			}
		}
		public void addElementToMaxHeap (int dataValue) {
			//直接添加到末尾，树从下到上进行调整
			if (endValuableIndex >= dataArray.length - 1) {
				ensureMemory(1);
			}
			dataArray[++ endValuableIndex] = dataValue;
			int travelIndex, siblingIndex, parentIndex;
			for (travelIndex = endValuableIndex; travelIndex > 0;) {
				parentIndex = (travelIndex - 1) >> 1;
				siblingIndex = travelIndex + ((travelIndex & 0x1) == 1 ? 1 : -1);
				if (dataArray[siblingIndex] < dataArray[travelIndex])
					siblingIndex = travelIndex;
				if (dataArray[siblingIndex] > dataArray[parentIndex])
					swap (siblingIndex, parentIndex);
				else break;
				travelIndex = parentIndex;
			}
		}
		public void addArrayToMaxHeap (int[] dataValueArray) {
			for (int index = dataValueArray.length - 1; index >= 0; index --) {
				this.addElementToMaxHeap(dataValueArray[index]);
			}
		}
		public int peekElement () {
			if (endValuableIndex >= 0)
				return dataArray[0];
			System.out.println("堆已经没有数据了");
			return Integer.MIN_VALUE;
		}
		public int popElement () {
			if (endValuableIndex >= 0) {
				int returnValue = dataArray[0];
				dataArray[0] = dataArray[endValuableIndex];
				endValuableIndex --;
				adjustDownTreeFromIndex (0);
				return returnValue;
			}
			System.out.println("堆已经没有数据了");
			return Integer.MIN_VALUE;
		}
		private void adjustDownTreeFromIndex (int index) {
			int rootValue = dataArray[index], rootIndex = index, travelIndex;
			for (travelIndex = (index << 1) + 1; travelIndex <= endValuableIndex; travelIndex = (travelIndex << 1) + 1) {
				if (travelIndex < endValuableIndex && dataArray[travelIndex] < dataArray[travelIndex + 1])
					travelIndex ++;
				if (rootValue < dataArray[travelIndex]) {
					dataArray[rootIndex] = dataArray[travelIndex];
					rootIndex = travelIndex;
				} else break;
					
			}
			dataArray[rootIndex] = rootValue;
		}
		private void ensureMemory (int needIndexAmount) {
			final int realNowLength = dataArray.length > needIndexAmount ? dataArray.length << 1 : dataArray.length + needIndexAmount;
			int[] dataArrayNow = new int[realNowLength];
			if (dataArrayNow == null || dataArrayNow.length != realNowLength)
				throw new OutOfMemoryError("无法再申请内存");
			System.arraycopy(dataArray, 0, dataArrayNow, 0, dataArray.length);
			dataArray = dataArrayNow;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void showDataArray () {
			for (int index = 0; index <= endValuableIndex; index ++)
				System.out.printf("%d ", dataArray[index]);
			System.out.println();
		}
		private void swap (int firstIndex, int secondIndex) {
			int dataArrayTempValue = dataArray[firstIndex];
			dataArray[firstIndex] = dataArray[secondIndex];
			dataArray[secondIndex] = dataArrayTempValue;
		}
	}
}
