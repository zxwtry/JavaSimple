package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*




ĳ���깬������һ��������С�������Խ���Ԥ�������ָ���ָ���ж���С���Ļ��������ܼ򵥣�ֻ��3�֣���ת����ΪL������ת����ΪR������ǰ���������ף�ֱ�Ӽ����֣���

���磬���ǿ��Զ�С���������µ�ָ�

15L10R5LRR10R20

��С����ֱ��15���ף���ת������10���ף�����ת��...

���ѿ��������ڴ�ָ���С���ֻص��˳����ء�

��������ǣ���д�������û�����ָ��������ÿ��ָ��ִ�к�С��λ����ָ��ִ��ǰС��λ�õ�ֱ�߾��롣

�����롢�����ʽҪ��

�û�������һ������n��n<100������ʾ����������n��ָ�

����������n��ָ�ÿ��ָ��ֻ��L��R��������ɣ�������0~100֮���������

ÿ��ָ��ĳ��Ȳ�����256���ַ���

���������n�н����

ÿ�������ʾС��ִ����Ӧ��ָ��ǰ��λ�õ�ֱ�߾��롣Ҫ���������뵽С����2λ��

���磺�û����룺
5
L100R50R10
3LLL5RR4L12
LL
100R
5L5L5L5

����������
102.96
9.06
0.00
100.00
0.00



 */



public class ��һ�»��������� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTest = Integer.parseInt(br.readLine().trim());
		while (numOfTest-- > 0) {
			char[] robotRoute = br.readLine().trim().toCharArray();
			System.out.printf("%.2f\n",getLengthFromBeginToEnd(robotRoute));
		}
	}

	private static double getLengthFromBeginToEnd(char[] robotRoute) {
		int theLengthTemp = 0;
		Location locationNow = new Location(0, 0);
		Location directionNow = new Location(1, 0);
		for (int i = 0; i < robotRoute.length; ++ i) {
			switch (robotRoute[i]) {
			case 'L':
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
				theLengthTemp = 0;
				if (directionNow.ordinate == 0) {
					if (directionNow.abscissa > 0) {
						directionNow.abscissa = 0;
						directionNow.ordinate = 1;
					} else {
						directionNow.abscissa = 0;
						directionNow.ordinate = -1;
					}
				} else {
					if (directionNow.ordinate > 0) {
						directionNow.abscissa = -1;
						directionNow.ordinate = 0;
					} else {
						directionNow.abscissa = 1;
						directionNow.ordinate = 0;
					}
				}
				break;
			case 'R':
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
				theLengthTemp = 0;
				if (directionNow.ordinate == 0) {
					if (directionNow.abscissa > 0) {
						directionNow.abscissa = 0;
						directionNow.ordinate = -1;
					} else {
						directionNow.abscissa = 0;
						directionNow.ordinate = 1;
					}
				} else {
					if (directionNow.ordinate > 0) {
						directionNow.abscissa = 1;
						directionNow.ordinate = 0;
					} else {
						directionNow.abscissa = -1;
						directionNow.ordinate = 0;
					}
				}
				break;
			default:
				theLengthTemp = theLengthTemp*10 + robotRoute[i] - '0';
				break;
			}
			if (i == robotRoute.length-1) {
				locationNow.abscissa += theLengthTemp*directionNow.abscissa;
				locationNow.ordinate += theLengthTemp*directionNow.ordinate;
			}
		}
		double re = Math.sqrt(locationNow.abscissa*locationNow.abscissa
				+ locationNow.ordinate*locationNow.ordinate);
		return re;
	}
	static class Location {
		int abscissa; //������
		int ordinate; //������
		public Location () {}
		public Location (int abscissa, int ordinate) {
			this.abscissa = abscissa;
			this.ordinate = ordinate;
		}
	}
}
