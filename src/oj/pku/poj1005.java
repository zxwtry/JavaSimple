package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1005 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n; n=in.nextInt();double d;int nty=1;
		while(nty<=n){
			d=0;
			d+=Math.pow(Double.parseDouble(in.next()), 2);
			d+=Math.pow(Double.parseDouble(in.next()), 2);
			d=d*Math.PI/100;
			System.out.println("Property "+nty+++": This property will begin eroding in year "+((int)d+1)+".");
		}
		System.out.println("END OF OUTPUT.");
		in.close();
	}
}