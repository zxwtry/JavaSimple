package oj.pku;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class poj1011 {
	//标记是否使用过这个棍子，在�?�归时需要标�?
	static boolean [] used ;	
	//棍子总数�?
	static int len ;	
	//棍子的数�?
	static int []s ;	
	//总长�?
	static int sum ;	
	//假设的原棍子长度
	static int max ;	
	//棍子数量  �? 总长�?/原棍子长�?
	static int parts ;
	
	public static void main(String[] args)throws Exception{
		Scanner read = new Scanner(new 
				InputStreamReader(System.in));
		while((len = read.nextInt())!=0){
			s = new int[len];
			int index = 0,lencou=0;
			sum =0;
			used = new boolean[len];
			while(lencou<len){
				s[index]=read.nextInt();
				sum += s[index++];
				lencou++;
			}
			Arrays.sort(s);
			max = s[len-1];
			for(; max<=sum; max++){
				//穷举棍子长度，只会�?�取能够整除的情�?
				if(sum%max == 0){
					//原棍子数�?
					parts = sum/max;
					//递归搜索
					if(search(0,len-1,0)){
						System.out.println(max);
						break;
					}
				}
			}
		}
		read.close();
	}
	private static boolean search(int res, int next, int cpl){
		//如果凑成了一根棍子，继续凑下面一�?
		if(res==max){
			//这个是现在这个棍子的长度，初始化�?0
			res = 0;
			//这里等于len-2只是�?个初始化，反正len-1肯定被占用了
			next = len-2;
			//这个是已经凑成的棍子数量
			cpl++;
		}
		//如果凑成parts这么多棍子，那么就结束了，搜索完�?
		if(cpl==parts) return true;
		//从后�?前搜�?
		while(next >= 0){
			//如果没有被使用的�?
			if(used[next]==false){
				//那么判断下这根棍子能不能放进我现在剩余的空间里面
				if(res+s[next]<=max){
					//能放得进的话，那么标记这根棍子已经被使用过了
					used[next]=true;
					//继续寻找下一�?
					if(search(res+s[next],next-1,cpl))
						return true;
					//如果没有凑成功，把这根棍子不放进去并标记为false
					used[next]=false;
					//如果第一块都放不进去的话，那么说明找的有问题，直接�??出了
					if(res == 0)
						break;
					//如果现在本来应该尝试成功的（已经拼成了一个大棍子，应该进入�?�归变成0的）却失败了，说明找的有问题
					if(res+s[next]==max)
						break;
				}
				//找下�?块不相等的棍�?
				int i = next-1;
				while(i>=0&&s[i]==s[next])	i--;
				next = i;
				//如果剩下的和比我�?要的棍子还小的话，就不凑�?
				int l_s = 0;
				for(int j=next; j>=0; j--)
					if(!used[j])
						l_s += s[j];
				if(l_s<max-res)
					break;
				//继续找下面的棍子 
				continue;
			}
			//说明这个棍子被使用过了，找下面一个棍�?
			next--;
		}
		//如果从这里出来的话，表示程序不能凑完�?有的棍子
		return false;
	}
}