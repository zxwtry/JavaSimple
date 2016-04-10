package javaSrc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
	public static void main(String[] args) {
		final int len = 100;
		long[] array = new long[len];
		for (int i = 0; i < len; i ++) {
			array[i] = (long)(Math.random()*len);
		}
		MaxValueTask mvt = new MaxValueTask(array, 0, len);
		System.out.println(mvt.compute());
	}
	static class MaxValueTask extends RecursiveTask<Long> {
		private static final long serialVersionUID = 1L;
		private final long[] array;
		private final int start;
		private final int end;
		private final int RANG_LENGTH = 10;
		MaxValueTask(long[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}
		@Override
		protected Long compute() {
			long max = Long.MIN_VALUE;
			if (end - start < RANG_LENGTH) {	// 寻找最大值
//				for (int i = start; i < end; i ++) {
//					if (array[i] > max) {
//						max = array[i];
//					}
//				}
				// 进行排序
				
			} else {	// 二分任务
				int mid = (start + end) >> 1;
				MaxValueTask lowTask = new MaxValueTask(array, start, mid);
				MaxValueTask highTask = new MaxValueTask(array, mid, end);
				lowTask.fork();
				highTask.fork();
				max = Math.max(max, lowTask.join());
				max = Math.max(max, highTask.join());
			}
			return max;
		}
		public Long calculate(long[] array) {
			MaxValueTask task = new MaxValueTask(array, 0, array.length);
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			Long result = forkJoinPool.invoke(task);
			return result;
		}
	}
}
