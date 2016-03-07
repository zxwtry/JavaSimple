package dataStructures;
/*
 * 泛型一般都是使用<T>或者是<T extends Comparable <? super T>>来进行标识
 */
public class 数简单泛型 {
	static class MySort<T> {
		public static<T extends Comparable <? super T>> void sort (T[] data) {
			for (int i = 0; i < data.length; ++ i) {
				for (int j = i+1; j < data.length; ++ j) {
					if (data[i].compareTo(data[j]) > 0) {
						T temp = data[i];
						data[i] = data[j];
						data[j] = temp;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Integer[] data= {1,3,5,7,9,8,6,4,2};
		MySort.sort(data);
		for (int i = 0; i < data.length; ++ i) {
			System.out.print(data[i] +" ");
		}
		System.out.println();
	}
	
}
