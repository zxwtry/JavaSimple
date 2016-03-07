package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class poj1014 {
	static int []coin = new int[7];
	static int []unus = new int[7];
	static int val;
	public static void main(String[] args) {
		Scanner in = new Scanner (new BufferedReader
				(new InputStreamReader(System.in)));
		int gcu=0;
		while(true){
			coin[0]=0;val=0;gcu++;
			for(int i=1;i<7;i++){
				coin[i]=in.nextInt();
				coin[0]+=coin[i];
				val+=i*coin[i];
			}	
			if(0==coin[0])	break;
			if(1==val%2){
				System.out.println("Collection #"+gcu+":\n"+"Can't be divided.\n");
				continue;
			}
			val=val/2;unus[0]=0;
			for(int i=1;i<unus.length;i++)
				unus[i]=coin[i];
			if(search()==true){
				System.out.println("Collection #"+gcu+":\n"+"Can be divided.\n");
			}
			else
				System.out.println("Collection #"+gcu+":\n"+"Can't be divided.\n");			
		}
		in.close();
	}
	private static boolean search() {
		if(unus[0]==val)	return true;
		if(1==(val-unus[0])%2&&0==(unus[1]+unus[3]+unus[5]))	return false;
		for(int i=6;i>0;i--){
			if(unus[i]!=0&&val-unus[0]>=i){
				unus[0]+=i;unus[i]--;
				if(search())	return true;
				unus[0]-=i;unus[i]++;
			}
		}
		return false;
	}
}