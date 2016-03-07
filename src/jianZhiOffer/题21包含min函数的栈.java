package jianZhiOffer;

public class 题21包含min函数的栈 {
	public static void main(String[] args) {
		StackWithMin<Integer> swm = new StackWithMin<Integer>();
		swm.add(3);
		System.out.println("Min: "+swm.getMin());
		swm.add(4);
		System.out.println("Min: "+swm.getMin());
		swm.add(2);
		System.out.println("Min: "+swm.getMin());
		swm.add(1);
		System.out.println("Min: "+swm.getMin());
		System.out.println(swm.pop());
		System.out.println("Min: "+swm.getMin());
		System.out.println(swm.pop());
		System.out.println("Min: "+swm.getMin());
		swm.add(0);
		System.out.println("Min: "+swm.getMin());
		
	}
	static class StackWithMin <T extends Comparable<? super T>>{
		private java.util.Stack<T> stk1, stk2;
		public StackWithMin () {
			stk1 = new java.util.Stack<T>();
			stk2 = new java.util.Stack<T>();
		}
		public void add (T data) {
			stk1.add(data);
			if (stk2.isEmpty()) {
				stk2.push(data);
			} else {
				if (data.compareTo(stk2.peek()) < 0)
					stk2.push(data);
				else 
					stk2.push(stk2.peek());
			}
		}
		public T pop () {
			stk2.pop();
			return stk1.pop();
		}
		public T getMin () {
			return stk2.peek();
		}
	}
}
