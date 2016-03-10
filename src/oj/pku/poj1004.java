package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class poj1004 {
	public static void main(String[] args) {
		double d =0;short n=12;
		DecimalFormat df = new DecimalFormat(".00");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(n>0){
			d+=Double.parseDouble(in.next());
			n--;
		}
		System.out.println("$"+df.format(d/12));
		in.close();
	}
}
