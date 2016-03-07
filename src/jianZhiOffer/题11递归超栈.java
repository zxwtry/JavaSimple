package jianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Ã‚11µ›πÈ≥¨’ª {
	public static void main(String[] args) {
		stkDepth(0);
		stkAndHeap.testHeap();
		stkAndHeap.testStack();
	}
	private static void stkDepth(int depth) {
		int data[] = new int[10000];
		Arrays.fill(data, Integer.MAX_VALUE);
		if (depth == 8000) {
			System.out.println("AA");
			return;
		}
		stkDepth(depth+1);
	}
	static class stkAndHeap{
	    public static void testHeap(){
	        for(;;){
	              ArrayList<Integer> list = new ArrayList<Integer> (2000);
	              list.add(1);
	          }
	    }
	    static int num=1;
	    public static void testStack(){
	        num++;
	        testStack();
	     }
	}
}
