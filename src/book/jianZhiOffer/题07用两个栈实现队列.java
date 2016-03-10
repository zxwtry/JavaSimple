package book.jianZhiOffer;

import java.util.Stack;

public class 题07用两个栈实现队列 {
	static class MyQueue {
		private Stack<Integer> stk1 = new Stack<Integer>();	
		private Stack<Integer> stk2 = new Stack<Integer>();	
		public void add (int data) {
			stk1.push(data);
		}
		public int get () {
			if (stk2.isEmpty()) {
				while (! stk1.isEmpty()) {
					stk2.push(stk1.pop());
				}
			}
			return stk2.pop();
		}
		public boolean isEmpty () {
			return stk1.isEmpty() && stk2.isEmpty();
		}
 	}
	public static void main(String[] args) {
		MyQueue mq = new MyQueue () ;
		mq.add(1);
		mq.add(2);
		mq.add(3);
		mq.add(4);
		while (!mq.isEmpty()) {
			System.out.println(mq.get());
		}
		mq.add(6);
		mq.add(7);
		System.out.println(mq.get());
		mq.add(8);
		System.out.println(mq.get());
		System.out.println(mq.get());
	}
	
}
