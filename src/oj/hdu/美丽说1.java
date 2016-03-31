package oj.hdu;

import java.util.*;

public class √¿¿ˆÀµ1 {
    static int n;
    static Leg[] l = new Leg[105];
    static Leg2[] lp = new Leg2[105];
    static boolean[] isS = new boolean[105];
    static int cost = Integer.MAX_VALUE;
    static class Leg implements Comparable<Leg>{
    	int len;
    	int pay;
    	public Leg () {
    	}
    	public Leg (int len, int pay) {
    		this.len = len;
    		this.pay = pay;
    	}
		@Override
		public int compareTo(Leg o) {
			return len - o.len;
		}
		public String toString() {
			return String.format("%d %d ", len, pay);
		}
    }
    static class Leg2 implements Comparable<Leg2>{
    	int len;
    	int pay;
    	public Leg2 () {
    	}
    	public Leg2 (int len, int pay) {
    		this.len = len;
    		this.pay = pay;
    	}
		@Override
		public int compareTo(Leg2 o) {
			return pay - o.pay;
		}
		public String toString() {
			return String.format("%d %d ", len, pay);
		}
    }
    static {
    	for (int i = 0; i < 105; i ++ ) {
    		l[i] = new Leg();
    		lp[i] = new Leg2();
    	}
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
        	cost = Integer.MAX_VALUE;
            n = cin.nextInt();
            if (n == 1) {
            	System.out.println(0);
            } else if (n == 2) {
            	if (l[0].len == l[1].len) {
            		System.out.println(0);
            	} else {
            		System.out.println(Math.min(l[0].pay, l[1].pay));
            	}
            } else {
	            for (int i = 0; i < n; i ++ ) {
	            	l[i].len = cin.nextInt();
	            	lp[i].len = l[i].len;
	            }
	            for (int i = 0; i < n; i ++ ) {
	            	l[i].pay = cin.nextInt();
	            	lp[i].pay = l[i].pay;
	            }
	            Arrays.sort(l, 0, n);
	            Arrays.sort(lp, 0, n);
	            int fff = 0;
	            for (int i = n-1; i >= 0; i ++) {
	            	if (lp[i].len == lp[n-1].len) {
	            		fff ++;
	            	}
	            }
	            if (fff > n / 2) {
	            	System.out.println(0);
	            }
	            else {
	            int count = 0, pre = Integer.MIN_VALUE;
	            int i = 0;
	            for (;i < n; i ++) {
	            	if (i != 0 && pre != l[i].len) {
	            		boolean isM = false;
	            		int select = n - count * 2 + 1;
	            		int selcost = 0;
	            		Arrays.fill(isS, false);
	            		for (int j = 0; j < n; j ++) { 
	            			if (lp[j].len > pre) {
	            				selcost += lp[j].pay;
	            				select --;
	            				isS[j] = true;
	            			}
	
	            			
	            		}
	            		if (select == 0) {
	        				isM = true;
	        				break;
	        			}
	            		for (int j = 0; j < n; j ++) { 
	            			if (isS[j])
	            				continue;
	            			if (select == 0)
	            				break;
	            			if (lp[j].len < pre) {
	            				selcost += lp[j].pay;
	            				select --;
	            			}
	            			if (select == 0 ) {
	            				isM = true;
	            				break;
	            			}
	            		}
	            		if (isM) {
		            		if (selcost < cost)
		            			cost = selcost;
	            		}
	            		count = 1;
	            		pre = l[i].len;
	            	} else {
	            		count ++;
	            		pre = l[i].len;
	            	}
	            }
	            boolean isM = false;
	    		int select = n - count * 2 + 1;
	    		int selcost = 0;
	    		Arrays.fill(isS, false);
	    		for (int j = 0; j < n; j ++) { 
	    			if (lp[j].len > pre) {
	    				selcost += lp[j].pay;
	    				select --;
	    				isS[j] = true;
	    			}
	
	    		
	    		}
	    		if (select == 0) {
					isM = true;
					break;
				}
	    		for (int j = 0; j < n; j ++) { 
	    			if (isS[j])
	    				continue;
	    			if (select == 0)
	    				break;
	    			if (lp[j].len < pre) {
	    				selcost += lp[j].pay;
	    				select --;
	    			}
	    			if (select == 0 ) {
	    				isM = true;
	    				break;
	    			}
	    		}
	    		if (isM) {
	        		if (selcost < cost)
	        			cost = selcost;
	    		}
	    		System.out.println(cost);
	            cost = Integer.MAX_VALUE;
	        }
            }
        }
        cin.close();
    }
}





















