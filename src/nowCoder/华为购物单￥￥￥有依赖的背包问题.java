package nowCoder;
/*
 * ��Ŀ����

��ǿ����ܿ��ģ���˾����NԪ�����ս�����ǿ���������ս����ڹ��
�����������Ʒ��Ϊ���ࣺ�����븽���������Ǵ�����ĳ�������ģ��±����һЩ�����븽�������ӣ�
����	����
����	��ӡ����ɨ����
���	ͼ��
����	̨�ƣ��ľ�
������	��
���Ҫ�����Ϊ��������Ʒ����������ø���������������ÿ������������ 0 ���� 1 ���� 2 ��������
���������д������Լ��ĸ�������ǿ����Ķ����ܶ࣬Ϊ�˲�����Ԥ�㣬����ÿ����Ʒ�涨��һ����Ҫ�ȣ���Ϊ 5 �ȣ�
������ 1 ~ 5 ��ʾ���� 5 ������Ҫ���������������ϲ鵽��ÿ����Ʒ�ļ۸񣨶��� 10 Ԫ������������
��ϣ���ڲ����� N Ԫ�����Ե��� N Ԫ����ǰ���£�ʹÿ����Ʒ�ļ۸�����Ҫ�ȵĳ˻����ܺ����
    ��� j ����Ʒ�ļ۸�Ϊ v[j] ����Ҫ��Ϊ w[j] ����ѡ���� k ����Ʒ���������Ϊ j 1 �� j 2 �������� j k ����������ܺ�Ϊ��
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ �� +v[j k ]*w[j k ] �������� * Ϊ�˺ţ�
    ���������ǿ���һ������Ҫ��Ĺ��ﵥ��
 


��������:
����ĵ� 1 �У�Ϊ��������������һ���ո������N m
������ N �� <32000 ����ʾ��Ǯ���� m �� <60 ��Ϊϣ��������Ʒ�ĸ�������

�ӵ� 2 �е��� m+1 �У��� j �и����˱��Ϊ j-1 ����Ʒ�Ļ������ݣ�ÿ���� 3 ���Ǹ����� v p q

������ v ��ʾ����Ʒ�ļ۸� v<10000 ���� p ��ʾ����Ʒ����Ҫ�ȣ� 1 ~ 5 ���� q ��ʾ����Ʒ���������Ǹ�����
��� q=0 ����ʾ����ƷΪ��������� q>0 ����ʾ����ƷΪ������ q �����������ı�ţ�
 



�������:
 ����ļ�ֻ��һ����������Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ�� <200000 ����

��������:
1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

�������:
2200
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ��Ϊ���ﵥ�������������ı������� {
	private static int maxValue = Integer.MIN_VALUE, maxMoney;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while ( sc.hasNext() ) {
			maxMoney = sc.nextInt();
			int numOfGoods = sc.nextInt();
			Good[] allGoods = new Good[numOfGoods];
			for (int i = 0; i < numOfGoods; i ++) {
				allGoods[i] = new Good(sc.nextInt(), sc.nextInt(), sc.nextInt()-1 );
			}
			boolean[] isTraveled = new boolean[numOfGoods];
			Arrays.fill(isTraveled, false);
			maxValue = Integer.MIN_VALUE;
//			travel(allGoods, 0, 0, isTraveled);
			System.out.println(maxValue);
		}
		sc.close();
	}
	static class Good {
		int price, priority,attr;
		public Good () {}
		public Good (int price, int priority, int attr) {
			this.price = price;
			this.priority = priority;
			this.attr = attr;
		}
	}
	public static void travel (Good[] allGoods, int nowValue, int nowMoney, boolean[] isTraveled) {
		ArrayList<Integer> available = new ArrayList<Integer>();
		for (int i = 0; i < allGoods.length; i ++) {
			if (!isTraveled[i]) {
				available.add(i);
			}
		}
		if (available.size() == 0) {
			judge(allGoods, nowValue, nowMoney, isTraveled);
			return;
		}
		for (int i = 0; i < available.size(); i ++) {
			int selectIndex = available.get(i);
			if (maxMoney-nowMoney > allGoods[selectIndex].price) {
				boolean isFit = false;
				if (allGoods[selectIndex].attr != -1) {
					for (int j = 0; j < available.size(); j ++)
						if(available.get(i) == allGoods[selectIndex].attr) {
							isFit = true;
							break;
						}
				} else {
					isFit = true;
				}
				if (isFit) {
					isTraveled[selectIndex] = true;
					nowValue += allGoods[selectIndex].price * allGoods[selectIndex].priority;
					nowMoney += allGoods[selectIndex].price;
						judge(allGoods, nowValue, nowMoney, isTraveled);
						travel(allGoods, nowValue, nowMoney, isTraveled);
					nowMoney -= allGoods[selectIndex].price;
					nowValue -= allGoods[selectIndex].price * allGoods[selectIndex].priority;
					isTraveled[selectIndex] = false;
				}
			}
		}
	}
	private static void judge (Good[] allGoods, int nowValue, int nowMoney, boolean[] isTraveled) {
		if (nowMoney > maxMoney)
			return;
		for (int i = 0; i < allGoods.length; i ++) {
			if (isTraveled[i] && allGoods[i].attr != -1 && !isTraveled[allGoods[i].attr])
				return;
		}
		if (nowValue > maxValue)
			maxValue = nowValue;
	}
	

	
}



































