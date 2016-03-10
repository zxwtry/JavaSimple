package oj.pku;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1018 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new 
				InputStreamReader(System.in)));
		//通讯系统数量
		int series = in.nextInt();
		//由于各个通讯系统相对独立，不需要对series进行保存
		while(series>0){
			series--;
			//开始对一个通讯系统进行工作　
			//一个通讯系统的输入
			//一个通讯系统需要多少种通讯部件
			int partNum=in.nextInt();
			//每种通讯部件有多少个部件选择
			int partSel[]=new int[partNum];
			//每种通讯部件中各个部件选择带宽和价格的存储
			int b[][]=new int[partNum][];
			int p[][]=new int[partNum][];
			//记录每种通讯部件的最大值，以便寻找最终可能的系统带宽最大值
			int bMax=Integer.MAX_VALUE,bMin=Integer.MAX_VALUE,
					bMaxs[]=new int[partNum];
			for(int partCou=0;partCou<partNum;partCou++){
				partSel[partCou]=in.nextInt();
				b[partCou]=new int[partSel[partCou]];
				p[partCou]=new int[partSel[partCou]];
				bMaxs[partCou]=0;
				for(int selCou=0;selCou<partSel[partCou];selCou++){
					b[partCou][selCou]=in.nextInt();
					p[partCou][selCou]=in.nextInt();
					if(bMin>b[partCou][selCou])
						bMin=b[partCou][selCou];
					if(bMaxs[partCou]<b[partCou][selCou])
						bMaxs[partCou]=b[partCou][selCou];
				}
			}
			for(int partCou=0;partCou<partNum;partCou++)
				bMax=(bMax>bMaxs[partCou])?bMaxs[partCou]:bMax;
			double dp=0;int pSum,pTmp;
			for(int bCou=bMin;bCou<=bMax;bCou++){
				pSum=0;
				for(int partCou=0;partCou<partNum;partCou++){
					pTmp=Integer.MAX_VALUE;
					for(int selCou=0;selCou<partSel[partCou];selCou++){
						if(b[partCou][selCou]>=bCou&&pTmp>p[partCou][selCou])
							pTmp=p[partCou][selCou];
					}
					pSum+=pTmp;
				}
				if((double)bCou/pSum>dp)
					dp=(double)bCou/pSum;
			}
			System.out.printf("%.3f\n",dp);
		}
		in.close();
	}
}