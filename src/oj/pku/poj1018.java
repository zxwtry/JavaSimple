package oj.pku;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class poj1018 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new 
				InputStreamReader(System.in)));
		//ͨѶϵͳ����
		int series = in.nextInt();
		//���ڸ���ͨѶϵͳ��Զ���������Ҫ��series���б���
		while(series>0){
			series--;
			//��ʼ��һ��ͨѶϵͳ���й�����
			//һ��ͨѶϵͳ������
			//һ��ͨѶϵͳ��Ҫ������ͨѶ����
			int partNum=in.nextInt();
			//ÿ��ͨѶ�����ж��ٸ�����ѡ��
			int partSel[]=new int[partNum];
			//ÿ��ͨѶ�����и�������ѡ�����ͼ۸�Ĵ洢
			int b[][]=new int[partNum][];
			int p[][]=new int[partNum][];
			//��¼ÿ��ͨѶ���������ֵ���Ա�Ѱ�����տ��ܵ�ϵͳ�������ֵ
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