package book.offer;
/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一i个数字
 */
public class 题20顺时针打印矩阵 {
	public static void main(String[] args) {
//		int[][] data = {
//				{1},
//				{2},
//				{3},
//				{4}
//		};
//		int[][] data = {
//				{1, 2, 3, 4}
//		};
		int[][] data = {
				{1}	
		};
//		int[][] data = {
//				{ 1, 2, 3, 4},
//				{ 5, 6, 7, 8},
//				{ 9,10,11,12},
//				{13,14,15,16},
//				{17,18,19,20}
//		};
		travelClockwise(data);
		travelClockwise2(data);
		travelClockwise3(data);
	}
	private static void travelClockwise (int[][] data) {
		if (data == null)   return;
		int start = 0;
		while (data.length>start*2 && data[0].length>start*2) {
			travelMatrixInCircle(data, data.length, data[0].length, start);
			start ++;
		}
		System.out.println();
	}
	private static void travelMatrixInCircle (int[][] data, int rows, int columns, int start) {
		int endX = columns-1-start;
		int endY = rows-1-start;
		//从左到右打印一行
		for (int i = start; i <= endX; ++ i) {
			System.out.printf("%d ", data[start][i]);
		}
		//从上到下打印一行
		if (start < endY) {
			for (int i = start+1; i <= endY; ++ i) 
				System.out.printf("%d ", data[i][endX]);
		}
		//从右到左打印一行
		if (start<endX && start<endY) {
			for (int i = endX-1; i >= start; -- i)
				System.out.printf("%d ", data[endY][i]);
		}
		//从下到上打印一行
		if (start<endX && start<endY-1) {
			for (int i = endY-1; i >= start+1; -- i) 
				System.out.printf("%d ", data[i][start]);
		}
	}
	private static void travelClockwise2(int[][] data) {
		if (data == null)   return;
		int start = 0;
		while (data.length>start*2 && data[0].length>start*2) {
			travelMatrixInCircle2 (data, data.length, data[0].length, start);
			start ++;
		}
		System.out.println();
	}
	private static void travelMatrixInCircle2 (int[][] data, int rows, int columns, int start) {
		int endX = rows-1-start;
		int endY = columns-1-start;
		int i;
		//从左到右打印一行
		for (i = start; i <= endY; i ++) {
			System.out.printf("%d ", data[start][i]);
		}
		//从上到下打印一列
		if (start < endX) {
			for (i = start+1; i <= endX; i ++) {
				System.out.printf("%d ", data[i][endY]);
			}
		}
		//从右到左打印一行
		if (start < endX && start < endY) {
			for (i = endY-1; i >= start; i --) {
				System.out.printf("%d ", data[endX][i]);
			}
		}
		//从下到上打印一列
		if (start < endX && start < endY) {
			for (i = endX-1; i > start; i --) {
				System.out.printf("%d ", data[i][start]);
			}
		}
	}
	private static void travelClockwise3(int[][] data) {
		if (data == null)   return;
		int start = 0, rows = data.length, columns = data[0].length;
		while (rows > (start<<1) && columns > (start<<1)) {
			travelMatrixInCircle3(data, rows, columns, start);
			start ++;
		}
	}
	private static void travelMatrixInCircle3 (int[][] data, int rows, int columns, int start) {
		int endX = rows-1-start;
		int endY = columns-1-start;
		int i;
		//从左到右
		for (i = start; i <= endY; i ++) {
			System.out.printf("%d ", data[start][i]);
		}
		//从上到下
		if (start < endX) {
			for (i = start+1; i <= endX; i ++) {
				System.out.printf("%d ", data[i][endY]);
			}
		}
		//从左到右
		if (start < endY && start < endX) {
			for (i = endY-1; i >= start; i --) {
				System.out.printf("%d ", data[endX][i]);
			}
		}
		//从下到上
		if (start < endX && start < endY) {
			for (i = endX-1; i > start; i --) {
				System.out.printf("%d ", data[i][start]);
			}
		}
	}
}

























