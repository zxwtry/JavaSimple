package book.offer;
/*
 * 数中有正也有负
 * 时间复杂度O(N)
 */
public class 题31连续数组的最大和 {
	public static void main(String[] args) {
		int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(getMaxSubSum(data, 0, data.length-1));
	}
	private static int getMaxSubSum (int[] data, int beginIndex, int endIndex) {
		State[] state = new State[endIndex-beginIndex+1];
		state[0] = new State(-1, data[beginIndex]);
		for (int dataIndex = beginIndex+1; dataIndex <= endIndex; dataIndex ++) {
			if (state[dataIndex-beginIndex-1].maxSum >= 0) {
				state[dataIndex-beginIndex] = new State(state[dataIndex-beginIndex-1].beginIndex
						, data[dataIndex]+state[dataIndex-beginIndex-1].maxSum);
			} else {
				state[dataIndex-beginIndex] = new State(dataIndex, data[dataIndex]);
			}
		}
		int maxSumOfAllState = Integer.MIN_VALUE, maxSumOfAllStateIndex = beginIndex;
		for (int indexOfState = 0; indexOfState <= endIndex-beginIndex; indexOfState ++) {
			if (maxSumOfAllState < state[indexOfState].maxSum) {
				maxSumOfAllState = state[indexOfState].maxSum;
				maxSumOfAllStateIndex = indexOfState+beginIndex;
			}
		}
		for (int i = state[maxSumOfAllStateIndex-beginIndex].beginIndex; i <= maxSumOfAllStateIndex; i ++)
			System.out.printf("%d ", data[i]);
		System.out.println();
		return maxSumOfAllState;
	}
	static class State {
		int beginIndex, maxSum;
		public State () {
			this(-1, -1);
		}
		public State (int beginIndex, int maxSum) {
			this.beginIndex = beginIndex;
			this.maxSum = maxSum;
		}
	}
}