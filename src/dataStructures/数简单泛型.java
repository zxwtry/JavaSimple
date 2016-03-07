package dataStructures;

public class Êý¼òµ¥·ºÐÍ {
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
