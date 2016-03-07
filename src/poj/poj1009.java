package poj;

import java.io.*;
import java.util.*;
public class poj1009 {
	static ArrayList<Integer> numVal,numTim;
	static int n,m,ans[]=new int[2];
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		while (true){
			n = in.nextInt();m = 0;
			System.out.println(n);
			if (n == 0)	break;
			numVal=new ArrayList<Integer>();
			numTim=new ArrayList<Integer>();
			while (true){
				numVal.add(in.nextInt());
				numTim.add(in.nextInt());
				if (numTim.get(numVal.size()-1)==0)	break;
				m += numTim.get(numVal.size()-1);
			}	
			if (numVal.size()==2){
				System.out.println("0 "+numTim.get(0)+"\n"+"0 0");
				continue;
			}
			m = m/n; ans[0]=-1; ans[1]=-1;int p=0,c=0;
			for (int i = 0; i < numVal.size(); i++){
				if (numTim.get(i)>3*n){
					for (int j=0;j<=n;j++){
						c=getM(p++,i,j);
						if(c==ans[0])
							ans[1]++;
						else{
							if(ans[0]!=-1) System.out.println(ans[0]+" "+ans[1]);
							ans[0]=c;ans[1]=1;
						}
					}
					if(0==ans[0])
						ans[1]+=numTim.get(i)-2*n-2;
					else{
						if(ans[0]!=-1) System.out.println(ans[0]+" "+ans[1]);
						ans[0]=0;ans[1]=numTim.get(i)-2*n-2;						
					}
					p+=numTim.get(i)-2*n-2;
					for(int j=numTim.get(i)-n-1;j<=numTim.get(i)-1;j++){
						c=getM(p++,i,j);
						if(c==ans[0])
							ans[1]++;
						else{
							if(ans[0]!=-1) System.out.println(ans[0]+" "+ans[1]);
							ans[0]=c;ans[1]=1;
						}
					}
				}else
					for (int j=0;j<numTim.get(i);j++){
						c=getM(p++,i,j);
						if(c==ans[0])
							ans[1]++;
						else{
							if(ans[0]!=-1) System.out.println(ans[0]+" "+ans[1]);
							ans[0]=c;ans[1]=1;
						}
					}
			}
			System.out.println(ans[0]+" "+ans[1]+"\n"+"0 0");
		}
		in.close();
	}
	public static int getM(int p,int i,int j){
		int max=0, ii = p/n, jj=p%n,tmp=0;
		for (int k=-1; k<2; k++)
			for (int t=-1; t<2; t++)
				if(k==0&&t==0)
					continue;
				else if (k==-1&&ii==0)
					continue;
				else if (k==1&&ii==m-1)
					continue;
				else if (t==-1&&jj==0)
					continue;
				else if (t==1&&jj==n-1)
					continue;
				else{
					tmp=numVal.get(getV(i,j,k*n+t));
					max=(max>=Math.abs(tmp-numVal.get(i)))?max:Math.abs(tmp-numVal.get(i));
				}
		return max;
	}
	public static int getV(int i,int j,int l){
		if (l>0)
			while(l>0){
				if (numTim.get(i)-j>l)	return i;
				l-=numTim.get(i)-j-1;
				while (l>0)
					l-=numTim.get(++i);
			}
		else
			while(l<0){
				if (j+1>-l)	return i;
				l+=j;
				while (l<0)
					l+=numTim.get(--i);
			}
		return i;
	}
}