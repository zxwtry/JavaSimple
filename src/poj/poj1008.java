package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1008 {
	final String sha[]={"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin",
			"mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu","uayet"};
	final static String stz[]={"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", 
			"muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
	public static void main(String[] args) {
		Scanner in = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
		int n;n=in.nextInt();String s1,s2;int yer;
		System.out.println(n);
		while(n>0){
			s1=in.next();s2=in.next();yer=in.nextInt();
			yer=yer*365; yer+=gtm(s2)*20;
			yer+=Integer.parseInt(s1.substring(0, s1.length()-1));
			System.out.println((yer%260%13+1)+" "+stz[yer%260%20]+" "+yer/260);
			n--;
		}
		in.close();
	}
	private static int gtm(String s2){
		switch(s2.charAt(0)){
		case 'p':
			if(s2.charAt(1)=='o')
				return 0;
			else return 15;
		case 'n':
			return 1;
		case 'z':
			if(s2.charAt(1)=='i')
				return 2;
			if(s2.charAt(1)=='o')
				return 3;
			else	return 10;
		case 't':
			return 4;
		case 'x':
			return 5;
		case 'y':
			if(s2.charAt(1)=='o')
				return 6;
			else return 9;
		case 'm':
			if(s2.charAt(1)=='o')
				return 7;
			else if (s2.charAt(1)=='u')
				return 14;
			else return 12;
		case 'c':
			if(s2.charAt(1)=='h')
				return 8;
			else if(s2.charAt(1)=='e')
				return 11;
			else return 17;
		case 'k':
			if(s2.charAt(1)=='a')
				return 13;
			else return 16;
		case 'u':
			return 18;
			default:
				return -1;
		}
	}
}