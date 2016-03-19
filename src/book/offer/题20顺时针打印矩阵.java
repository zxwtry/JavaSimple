package book.offer;
/*
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһi������
 */
public class ��20˳ʱ���ӡ���� {
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
		//�����Ҵ�ӡһ��
		for (int i = start; i <= endX; ++ i) {
			System.out.printf("%d ", data[start][i]);
		}
		//���ϵ��´�ӡһ��
		if (start < endY) {
			for (int i = start+1; i <= endY; ++ i) 
				System.out.printf("%d ", data[i][endX]);
		}
		//���ҵ����ӡһ��
		if (start<endX && start<endY) {
			for (int i = endX-1; i >= start; -- i)
				System.out.printf("%d ", data[endY][i]);
		}
		//���µ��ϴ�ӡһ��
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
		//�����Ҵ�ӡһ��
		for (i = start; i <= endY; i ++) {
			System.out.printf("%d ", data[start][i]);
		}
		//���ϵ��´�ӡһ��
		if (start < endX) {
			for (i = start+1; i <= endX; i ++) {
				System.out.printf("%d ", data[i][endY]);
			}
		}
		//���ҵ����ӡһ��
		if (start < endX && start < endY) {
			for (i = endY-1; i >= start; i --) {
				System.out.printf("%d ", data[endX][i]);
			}
		}
		//���µ��ϴ�ӡһ��
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
		//������
		for (i = start; i <= endY; i ++) {
			System.out.printf("%d ", data[start][i]);
		}
		//���ϵ���
		if (start < endX) {
			for (i = start+1; i <= endX; i ++) {
				System.out.printf("%d ", data[i][endY]);
			}
		}
		//������
		if (start < endY && start < endX) {
			for (i = endY-1; i >= start; i --) {
				System.out.printf("%d ", data[endX][i]);
			}
		}
		//���µ���
		if (start < endX && start < endY) {
			for (i = endX-1; i > start; i --) {
				System.out.printf("%d ", data[i][start]);
			}
		}
	}
}

























