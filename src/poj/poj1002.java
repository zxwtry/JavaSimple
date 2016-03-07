package poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class poj1002 {
	static int map [] = new int [10000000];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n,ntr=0;n=Integer.parseInt(in.readLine());
		DecimalFormat df1 = new DecimalFormat("000");
		DecimalFormat df2 = new DecimalFormat("0000");
		while(ntr<n){
			String s = new String(in.readLine());
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<s.length(); i++){
				switch(s.charAt(i)){
				case 'A':
				case 'B':
				case 'C':	
					sb.append("2");
					break;	
				case 'D':
				case 'E':
				case 'F':	
					sb.append("3");
					break;	
				case 'G':
				case 'H':
				case 'I':	
					sb.append("4");
					break;		
				case 'J':
				case 'K':
				case 'L':	
					sb.append("5");
					break;
				case 'M':
				case 'N':
				case 'O':	
					sb.append("6");
					break;
				case 'P':
				case 'R':
				case 'S':	
					sb.append("7");
					break;	
				case 'T':
				case 'U':
				case 'V':	
					sb.append("8");
					break;	
				case 'W':
				case 'X':
				case 'Y':	
					sb.append("9");
					break;
					default:
						if(s.charAt(i)>='0'&&s.charAt(i)<='9')
							sb.append(s.charAt(i));	
						break;
				}
			}
			ntr++;
			map[Integer.parseInt(sb.toString())]++;
		}//while
		boolean show = false;
		for(int i=0;i<10000000;i++){
			if(map[i]>=2){
				System.out.println(new String(df1.format(i/10000))+"-"+new String(df2.format(i%10000))+" "+map[i]);
				show = true;
			}
		}
		if (show==false)
			System.out.println("No duplicates.");
	}
}