package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class poj1016 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		String num[] = new String[16];
		while(true){
			for(int i=0; i<num.length; i++)	num[i]=new String();
			num[0]=br.readLine();
			if(num[0].equals("-1"))	break;
			for(int i=0; i<num.length-1; i++){
				int cou[]={0,0,0,0,0,0,0,0,0,0};
				for(int k=0; k<num[i].length(); k++)
					cou[num[i].charAt(k)-'0']++;
				for(int k=0; k<10; k++)
					if(cou[k]!=0){
						num[i+1]+=(cou[k]+"");
						num[i+1]+=(k+"");
					}
			}
			int steps = -1,loopLength=-1;
			if(!num[0].equals(num[1])){
				for(int i=1; i<num.length-1; i++)
					if(num[i].equals(num[i+1])){
						steps = i;
						break;
					}				
			}
			if(!num[0].equals(num[1])&&steps == -1){
				for(int i=1; i<num.length-2; i++){
					if(loopLength!=-1)	break;
					for(int j=i+2; j<num.length; j++)
						if(num[i].equals(num[j])){
							loopLength=j-i;
							break;
						}
				}
			}
			if(num[0].equals(num[1]))
				System.out.println(num[0]+" is self-inventorying");
			else if(steps!=-1){
				System.out.println(num[0]+" is self-inventorying after "+steps+" steps");
			}else if(loopLength!=-1){
				System.out.println(num[0]+" enters an inventory loop of length "+loopLength);
			}else
				System.out.println(num[0]+" can not be classified after 15 iterations");
		}
		br.close();
	}
}