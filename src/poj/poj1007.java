package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1007 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n=in.nextInt();int m=in.nextInt();
		int ctn[][] = new int[2][m];String s[] = new String[m];
		for(int i=0; i<m; i++) ctn[0][i]=i;
		while(m>0){
			s[m-1]=in.next();
			for(int i=0; i<n-1; i++)
				for(int j=i+1; j<n; j++)
					if(s[m-1].charAt(i)>s[m-1].charAt(j))
						ctn[1][m-1]++;
				
			m--;
		}
		for(int i=0; i<s.length; i++)
			for(int j=i+1; j<s.length; j++)
				if(ctn[1][i]>ctn[1][j]){
					int tmp=ctn[1][i];	ctn[1][i]=ctn[1][j];
					ctn[1][j]=tmp;		tmp=ctn[0][i];
					ctn[0][i]=ctn[0][j];ctn[0][j]=tmp;
				}
		for(int i=0; i<s.length; i++){
			System.out.println(s[ctn[0][i]]);
		}
		in.close();
	}
}