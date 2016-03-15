package oj.nowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class 华为明明的随机数 {
    private static int[] map = new int[34];
    public static void main (String[] args) throws Exception{
    	Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            Arrays.fill(map, 0);
	        for (int i = 0; i < num; i ++) {
	            setOne(sc.nextInt());
	        }
	        for (int index = 1; index <= 1000; index ++) {
	            if (getStatus(index))
	                System.out.println(index);
	        }
        }
        sc.close();
    }
    private static void setOne (int index) {
        int indexInMap = index / 30;
        int indexInInt = index % 30;
		int numOfSingle = (1 << indexInInt );   
        if ((map[indexInMap] & numOfSingle) == numOfSingle) {
            
        } else {
            map[indexInMap] += numOfSingle;
        }
        
    }
    private static boolean getStatus (int index) {
        int indexInMap = index / 30;
        int indexInInt = index % 30;
		int numOfSingle = (1 << indexInInt );   
        if ((map[indexInMap] & numOfSingle) == numOfSingle) {
            return true;
        } else {
            return false;
        }
        
    }

}
