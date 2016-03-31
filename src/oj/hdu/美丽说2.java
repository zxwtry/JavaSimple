package oj.hdu;

import java.util.*;

public class ÃÀÀöËµ2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a[] = new int[4];
        while(cin.hasNextInt()) {
        	int sum = 0;
            for (int i = 0; i < 4; i ++) {
            	a[i] = cin.nextInt();
            	sum += a[i];
            }
            if (sum % 4 != 0) {
            	System.out.println(-1);
            } else {
            	System.out.println(8);
            }
        }
        cin.close();
    }
}