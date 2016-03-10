package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//这是一个典型的搜索问题，需要进行相应的搜索来完成相应的目标
public class poj1017 {
	static int []num = new int [7];
	public static void main(String[] args) {
		Scanner in = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
		while(true){
			num[0]=0;
			for (int i=1; i<7; i++){
				num[i] = in.nextInt();
				num[0] += num[i];
			}
			if(num[0]==0)	break;
			int cou = num[6]+num[5]+num[4]+num[3]/4+(num[3]%4+3)/4;
			num[1]=(num[1]>11*num[5])?num[1]-11*num[5]:0;
			int a1 = 0;int a2 = 5*num[4];
			if(a2>=num[2]){
				a1=(a2-num[2])*4;num[2]=0;
				num[1]=(num[1]>a1)?num[1]-a1:0;
			}else{
				num[2]=num[2]-a2;
			}
			if(num[3]%4==0){
				num[3]=0;
			}else{
				a1=8-num[3]%4;a2=7-2*(num[3]%4);
				num[2]=num[2]-a2;
				if(num[2]<0){
					a1+=4*(-num[2]);
					num[2]=0;
				}
				num[1]=(num[1]>a1)?num[1]-a1:0;
			}
			cou+=num[2]/9+(num[2]%9+8)/9;
			if(num[2]%9!=0){
				a1=(9-num[2]%9)*4;
				num[1]=(num[1]>a1)?num[1]-a1:0;				
			}
			cou+=num[1]/36+(num[1]%36+35)/36;
			System.out.println(cou);
		}
		in.close();
	}
}