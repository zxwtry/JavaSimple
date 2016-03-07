package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1010 {
	private static int cou,cus,val[] = new int [100],ans[]=new int[4];
	private static int DEPTH=4,sav[]=new int[8];
	private static boolean b[] = new boolean[100];
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while(in.hasNext()){
			cou=0;
			while (true){
				val[cou]=in.nextInt();
				if (val[cou]==0){
					sort(val,0,cou-1);
					int inv[][] = new int [2][100],inc=0;
					inv[0][0]=val[0];inv[1][0]=1;
					for(int m=1;m<=cou-1;m++)
						if(val[m]==inv[0][inc])
							inv[1][inc]++;
						else{
							inc++;inv[0][inc]=val[m];inv[1][inc]=1;
						}
					int vac=0;
					for(int m=0;m<=inc;m++){
						if(inv[1][m]>4)	inv[1][m]=4;
						while(inv[1][m]>0){
							val[vac]=inv[0][m];inv[1][m]--;vac++;
						}
					}
					cou=vac;
					break;
				}
				cou++;
			}
			while (true){
				cus=in.nextInt();
				if (cus==0)	break;
				ans[0]=ans[1]=ans[2]=ans[3]=0;
				sav[4]=-1;sav[5]=-1;sav[6]=0;sav[7]=0;dfs(0);
				if(sav[4]==-1){	
					System.out.print(cus+" ----");
					System.out.println(" none");
					continue;}
				if(sav[6]==1){	
					System.out.print(cus+" ("+(sav[7]+1)+"): ");
					System.out.println("tie");
					continue;}				
				System.out.print(cus+" ("+(sav[7]+1)+"): ");
				for(int m=0;m<sav[4];m++)
						System.out.print(val[sav[m]]+" ");				
				System.out.println(val[sav[sav[4]]]);
			}
		}
		in.close();
	}
	private static void dfs(int dep){
		if (dep>3)
			return;
		for (int seq=ans[dep]; seq<cou; seq++){
			for (int m=dep; m<DEPTH; m++) ans[m]=seq;
			if(jud(dep,seq))continue;
			dfs(dep+1);
		}
	}
	private static boolean jud(int dep,int seq){
		int sum=0,m,max,cpy;
		for(m=0;m<=dep;m++)	sum+=val[ans[m]];
		if(sum==cus){
			max=0;cpy=-1;
			for(m=0; m<=dep; m++)
				max=(max>=val[ans[m]])?max:val[ans[m]];
			for(m=0;m<100;m++)
				b[m]=false;
			for(m=0;m<=dep;m++)
				b[ans[m]]=true;
			for(m=0;m<100;m++)
				if(b[m]==true)
					cpy++;
			if(sav[4]==-1){			
				for(m=0; m<=dep; m++)		sav[m]=ans[m];
				for(m=dep+1; m<DEPTH; m++)	sav[m]=-1;
				sav[4]=dep;sav[5]=max;sav[6]=0;sav[7]=cpy;return true;}
			
			char cod[] = new char[3];
			if (cpy>sav[7])cod[0]='2';else if(cpy==sav[7])cod[0]='1';else cod[0]='0';
			if (dep<sav[4])cod[1]='2';else if(dep==sav[4])cod[1]='1';else cod[1]='0';
			if (max>sav[5])cod[2]='2';else if(max==sav[5])cod[2]='1';else cod[2]='0';
			
			int iod = Integer.parseInt(new String(cod));
			if(iod>111){
				for(m=0; m<=dep; m++)		sav[m]=ans[m];
				for(m=dep+1; m<DEPTH; m++)	sav[m]=-1;
				sav[4]=dep;sav[5]=max;sav[6]=0;sav[7]=cpy;;
			}else if(iod==111) sav[6]=1;
			return true;
		}else
			return false;
	}
	private static void sort(int val[],int start,int end){
		for(int i=start;i<=end;i++)
			for(int j=i+1;j<=end;j++)
				if(val[i]>val[j]){
					int tmp = val[i];
					val[i]=val[j];
					val[j]=tmp;
				}
	}
}