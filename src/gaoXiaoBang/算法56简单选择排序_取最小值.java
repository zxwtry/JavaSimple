package gaoXiaoBang;

/*

����
ȡ��Сֵ
ѡ����������Ҫѡ����С��Ԫ�ء�
��ʹ�õ�����̨���ķ��������СԪ�ء�
���ڼ���Ҫͬʱ�����С�ʹ�СԪ�أ��������ھ����Ǿ���������β�����

 */


public class �㷨56��ѡ������_ȡ��Сֵ {
	public static void main(String[] args) {
		int[] data = {1, 6, 4, 2, 3, 7, 5};
		MaxTwo max = selectSort(data, 0, data.length-1);
		if (max == null) {
			System.out.println("������������");
		} else if (max.firstIndex == max.secondIndex) {
			System.out.println("ֻ�ҵ�һ���ǣ�"+data[max.firstIndex]);
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
