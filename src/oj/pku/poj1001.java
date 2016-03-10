package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class poj1001 {
	public static void main(String[] args) throws Exception{
		String s = null; int ans[] = new int[139]; int poi=0,n,num;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int m,k;
			StringBuffer sub = new StringBuffer();			
			for(m=0;m<139;m++)ans[m]=0;
			s = in.readLine();
			sub.append(s.charAt(7));sub.append(s.charAt(8));
			n=Integer.parseInt(sub.toString().trim());
			if(n==0){
				System.out.println(0);
				continue;
			}
			sub.delete(0,2);
			for (m=5;m>=0;m--)
				if(s.charAt(m)!='.')
					sub.append(s.charAt(m));
				else
					poi=m;
			for(m=4;m>=0;m--)ans[m]=sub.charAt(m)-'0';
			num=Integer.parseInt(sub.reverse().toString());
			poi = (5-poi)*n;
			for(m=1;m<n;m++){
				for(k=0;k<139;k++)
					ans[k]=ans[k]*num;
				form(ans);
			}
			int end = 0;
			while(num>0){
				if(num%10==0){
					end++;
					num=num/10;
				}else{
					break;
				}
			}
			end = end * n;
			int mstart = 138,mend=0;
			while(ans[mstart]==0)
				mstart--;
			while(ans[mend]==0)
				mend++;
			if(poi<=mend)
				for(m=mstart;m>=poi;m--)System.out.print(ans[m]);
			else if (poi<=mstart){
				for(m=mstart;m>=poi;m--)System.out.print(ans[m]);
				System.out.print(".");
				for(m=poi-1;m>=mend;m--)System.out.print(ans[m]);
			}else{
				System.out.print(".");
				for(m=poi-1;m>mstart;m--)System.out.print(0);
				for(m=mstart;m>=mend;m--)System.out.print(ans[m]);
			}
			System.out.println();
		}
	}

	private static void form(int[] ans) {
		for(int m=0;m<130;m++){
			ans[m+5]+=ans[m]/100000;
			ans[m+4]+=(ans[m]/10000)%10;
			ans[m+3]+=(ans[m]/1000)%10;
			ans[m+2]+=(ans[m]/100)%10;
			ans[m+1]+=(ans[m]/10)%10;
			ans[m]=ans[m]%10;
		}
	}
}
