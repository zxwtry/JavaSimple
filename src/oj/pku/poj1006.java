package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1006 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int p,e,i,d,ans,n=1;
		while(true){
			p=in.nextInt();e=in.nextInt();
			i=in.nextInt();d=in.nextInt();
			if(p==-1&&e==-1&&i==-1&&d==-1)
				break;
			ans=(5544*p+14421*e+1288*i+ 21252-d)%(23*28*33);
			if(ans==0)ans=21252;
			System.out.println("Case "+n+": the next triple peak occurs in "+ans+" days.");
			n++;
		}
		in.close();
	}
}
