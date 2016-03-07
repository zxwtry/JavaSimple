package jianZhiOffer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class 题07用两个队列实现一个栈 {
	static class MyStack {
		private static Queue<Integer> qu1 = new LinkedBlockingQueue<Integer>();
		private static Queue<Integer> qu2 = new LinkedBlockingQueue<Integer>();
		public void add (int data) {
			qu1.add(data);
		}
		public int get () {
			if (qu2.isEmpty()) {
				while (!qu1.isEmpty()) {
					qu2.add(qu1.poll());
				}
			}
			return qu2.poll();
		}
		public boolean isEmpty () {
			return qu1.isEmpty() && qu2.isEmpty();
		}
	}
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		ms.add(1);
		ms.add(2);
		ms.add(3);
		ms.add(4);
		while (!ms.isEmpty()) {
			System.out.println(ms.get());
		}
		ms.add(5);
		ms.add(6);
		System.out.println(ms.get());
		ms.add(7);
		System.out.println(ms.get());
		System.out.println(ms.get());
	}
}
