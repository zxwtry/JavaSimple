package gaoXiaoBang;

public class µÚËÄÕÂ¶ÑÅÅĞòÀı×Ó {
	public static void main (String[] args) {
		int[] data = {9,1,8,2,7,6,5,4,3};
		new myHeap(data);
	}
	static class myHeap {
		private int index;
		public myHeap(int[] data) {
			index = data.length-1;
			heapResort(data);
			show(data);
		}
		private void heapResort(int[] data) {
			while (index > 0) {
				if (index%2 == 0) {
					for (int i = (index+1)/2-1; i >= 0; --i) {
						if (data[i*2+1] < data[i*2+2]) {
							if (data[i*2+2] > data[i]) {
								data[i]     = data[i] ^ data[i*2+2];
								data[i*2+2] = data[i] ^ data[i*2+2];
								data[i]     = data[i] ^ data[i*2+2];
							}
						} else {
							if (data[i*2+1] > data[i]) {
								data[i] = data[i] ^ data[i*2+1];
								data[i*2+1] = data[i] ^ data[i*2+1];
								data[i] = data[i] ^ data[i*2+1];
							}
						}
					}
				} else {
					if(data[index] > data[(index+1)/2-1]) {
						data[index]         = data[index] ^ data[(index+1)/2-1];
						data[(index+1)/2-1] = data[index] ^ data[(index+1)/2-1];
						data[index]         = data[index] ^ data[(index+1)/2-1];
					}
					for (int i = (index+1)/2-2; i >= 0; --i) {
						if (data[i*2+1] < data[i*2+2]) {
							if (data[i*2+2] > data[i]) {
								data[i]     = data[i] ^ data[i*2+2];
								data[i*2+2] = data[i] ^ data[i*2+2];
								data[i]     = data[i] ^ data[i*2+2];
							}
						} else {
							if (data[i*2+1] > data[i]) {
								data[i]     = data[i] ^ data[i*2+1];
								data[i*2+1] = data[i] ^ data[i*2+1];
								data[i]     = data[i] ^ data[i*2+1];
							}
						}
					}
				}
				data[0] = data[0] ^ data[index];
				data[index] = data[0] ^ data[index];
				data[0] = data[0] ^ data[index];
				-- index;
			}
		}
		private void show(int[] data) {
			for (int i = 0; i < data.length; ++ i) {
				System.out.print(data[i]+" ");
			}
			System.out.println();
		}
	}
}
