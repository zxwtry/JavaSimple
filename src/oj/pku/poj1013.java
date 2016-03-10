//第一行：有多少组
//每组会有三行数据，代表天平状态
//每行三个字符串，一：天平左边。二：天平右边。三：右边是up,down,even
//每组数据都有一个确定的答案－－这句非常重要
//输出那个砝码有问题，是轻是重。
package oj.pku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1013 {
	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(
				new InputStreamReader(System.in)));
		int pha[]=new int['L'-'A'+1];
		int n=in.nextInt(),nco=0;
		boolean com[]=new boolean [3];
		String s[]=new String[3];
		while(nco<n){
			for(int phs=0;phs<pha.length;phs++)
				pha[phs]=0;
			for(int i=0;i<3;i++){
				s[i] = new String();
				s[i]+=(in.next().trim());
				s[i]+=(in.next().trim());
				switch(in.next().charAt(0)){
				case 'e':
					com[i]=true;
					break;
				case 'd':
					com[i]=false;
					break;
				case 'u':
					com[i]=false;
					s[i]=(new StringBuffer(s[i]).reverse()).toString();
					break;
					default:
						System.out.println("edu鎵ц鍒颁簡闈炴硶浠ｇ爜");
						break;
				}
			}
			StringBuffer left = new StringBuffer();
			StringBuffer right = new StringBuffer();
			for(int i=0; i<3; i++){
				if(com[i]==false)continue;
				for(int j=0;j<s[i].length();j++)
				pha[s[i].charAt(j)-'A']=1;
			}
			for(int i=0; i<3; i++){
				if(true==com[i])continue;
				for(int j=0;j<s[i].length()/2;j++)
					if(1!=pha[s[i].charAt(j)-'A'])
						left.append(s[i].charAt(j));
				for(int j=s[i].length()/2;j<s[i].length();j++)
					if(1!=pha[s[i].charAt(j)-'A'])
						right.append(s[i].charAt(j));					
			}
			int leftL = left.length();
			int rightL = right.length();
			for(int i=0; i<leftL;i++){
				for(int j=0; j<rightL; j++)
					if(right.charAt(j)==left.charAt(i)){
						pha[left.charAt(i)-'A']=-1;						
						right.deleteCharAt(j);
						rightL--;j--;
						left.deleteCharAt(i);
						leftL--;i--;
						break;
					}
			}
			for(int i=0; i<left.length(); i++){
				if(pha[left.charAt(i)-'A']!=-1)
					pha[left.charAt(i)-'A']+=2;
			}
			for(int i=0; i<right.length(); i++){
				if(pha[right.charAt(i)-'A']!=-1)
					pha[right.charAt(i)-'A']+=2;
			}
			int ans[] = {-1,-1,-1,-1};
			for(int i=0; i<left.length(); i++){
				if(pha[left.charAt(i)-'A']>ans[0]){
					ans[0]=pha[left.charAt(i)-'A'];
					ans[1]=i;
				}
			}
			for(int i=0; i<right.length(); i++){
				if(pha[right.charAt(i)-'A']>ans[0]){
					ans[2]=pha[right.charAt(i)-'A'];
					ans[3]=i;
				}
			}
			if(ans[0]>ans[2])
				System.out.println(left.charAt(ans[1])+" is the counterfeit coin and it is "+"light.");
			else
				System.out.println(right.charAt(ans[3])+" is the counterfeit coin and it is "+"heavy.");
			nco++;
		}
		in.close();
	}
}