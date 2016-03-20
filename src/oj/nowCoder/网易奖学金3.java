package oj.nowCoder;

import java.util.Comparator;
import java.util.Scanner;

/*




 */
public class ÍøÒ×½±Ñ§½ð3 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		int num, full, need;
		
		while (in.hasNext()) {
			num = in.nextInt();
			full = in.nextInt();
			need = in.nextInt() * num;
			
		}
		
		
		in.close();
	}
	
	static class Node implements Comparator <Node> {
		int ava, pay;
		public Node (int ava, int pay) {
			this.ava = ava;
			this.pay = pay;
		}
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
}
