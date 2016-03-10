package oj.pku;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


//不管怎样一定要使用dp
//说白了，dp就是用空间换时间的做法。
//怎么样多地节省时间，就怎么样使用空间

public class poj1015 {
	static int n,m,fix;
	static int []p,d;
	static short [][][]ste;
	static boolean [][][]usd;
	public static void main(String[] args) {
		Scanner in = new Scanner (new BufferedReader(new InputStreamReader(System.in)));
		int count=0;
		while(true){
			count++;
			n=in.nextInt();m=in.nextInt();fix=20*m;
			if(n==0&&m==0)	break;
			System.out.println("Jury #"+count);
			p=new int[n+1];d=new int[n+1];
			for(int nty=1; nty<=n; nty++){
				p[nty]=in.nextInt();d[nty]=in.nextInt();				
			}
			ste=new short[n+1][m+1][40*m+1];
			usd=new boolean[n+1][m+1][40*m+1];
			for(int i=0; i<=n; i++)
				for(int j=0; j<=m; j++)
					for(int k=-20*m; k<=20*m; k++)
						ste[i][j][k+fix]=-1;
			ste[0][0][0+fix]=0;
			//dp开始
			for(int i=1; i<=n; i++)
				for(int j=0; j<=m; j++)
					for(int k=-20*m; k<=20*m; k++){
						ste[i][j][k+fix]=ste[i-1][j][k+fix];
						usd[i][j][k+fix]=false;
						if(j>0&&k-p[i]+d[i]+fix>=0&&k-p[i]+d[i]+fix<=40*m&&ste[i-1][j-1][k-p[i]+d[i]+fix]
								!=-1&&ste[i-1][j-1][k-p[i]+d[i]+fix]+p[i]+d[i]>ste[i][j][k+fix]){
							ste[i][j][k+fix]= (short) (ste[i-1][j-1][k-p[i]+d[i]+fix]+p[i]+d[i]);
							usd[i][j][k+fix]=true;
						}
					}	
			//dp结束
			for(int i=0; i<=fix; i++){
				if(ste[n][m][i+fix]>=ste[n][m][-i+fix]&&ste[n][m][i+fix]!=-1){
					System.out.println("Best jury has value "+((ste[n][m][i+fix]+i)/2)+" for" +
							" prosecution and value "+((ste[n][m][i+fix]-i)/2)+" for defence:");
					print(n,m,i);
					break;
				}else if(ste[n][m][-i+fix]!=-1){
					System.out.println("Best jury has value "+((ste[n][m][-i+fix]-i)/2)+" for" +
							" prosecution and value "+((ste[n][m][-i+fix]+i)/2)+" for defence:");
					print(n,m,-i);
					break;
				}
			}
			System.out.println("\n");
		}
		in.close();
	}
	private static void print(int i, int j, int k){
		if(i==0&&j==0&&k==0)return;
		if(usd[i][j][k+fix]==false)
			print(i-1,j,k);
		else{
			print(i-1,j-1,k-p[i]+d[i]);
			System.out.print(" "+i);
		}
	}
}