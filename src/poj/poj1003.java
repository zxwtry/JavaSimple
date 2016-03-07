package poj;

import java.io.*;
import java.util.Scanner;

public class poj1003 {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		float f = 0.00f;int n = 2;
		while(true){
			f = Float.parseFloat(new String(in.next()));
			if (f<0.01) break; n=2;
			while(f>0.0){
				f-=1/(float)n;
				n++;
			}
			System.out.println(n-2+" card(s)");
		}
		in.close();
	}
}