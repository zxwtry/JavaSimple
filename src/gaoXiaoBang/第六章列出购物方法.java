/*
��˾����ĳ�̵�Ĺ���ȯ1000Ԫ��
�޶�ֻ�ܹ�����е�m����Ʒ��
ÿ����Ʒ�ļ۸�ֱ�Ϊm1,m2,����
Ҫ������г����е�������������ù���ȯ�Ĳ�ͬ���﷽����
�������룺
��һ����һ������m������ɹ������Ʒ����������
��������m��������ÿ��1�У��ֱ������m����Ʒ�ĵ��ۡ�
���������
��һ����һ����������ʾ���ж����ַ���
�ڶ��п�ʼ��ÿ�ַ���ռ1�У���ʾ��ÿ����Ʒ������������м��ÿո�ָ���
���磺
���룺
2
200
300
��Ӧ�����
2
2 2
5 0
���룺
2
500
800
��Ӧ�����
1
2 0
 */

package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class �������г����﷽�� {
	private static final int MONEY = 1000;
	private static int minPrice = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		int[] price = new int[num];
		int[] count = new int[num];
		Arrays.fill(count, 0);
		for (int i = 0; i < num; ++ i) {
			price[i] = Integer.parseInt(br.readLine().trim());
			if(minPrice > price[i]) {
				minPrice = price[i];
			}
		}
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		search(price, list, MONEY, count);
		System.out.println(list.size());
		Iterator<int[]> it = list.iterator();
		while(it.hasNext()) {
			int[] temp = it.next();
			for (int i = 0; i < temp.length - 1; ++ i) {
				System.out.print(temp[i] + " ");
			}
			System.out.println(temp[temp.length-1]);
		}
		br.close();
	}
	private static void search(int[] price, ArrayList<int[]> list, int money, int[] count) {
		if (money == 0) {
			Iterator<int[]> it = list.iterator();
			boolean isFound = false;
			while(it.hasNext()) {
				int temp [] = it.next();
				boolean isTheSame = true;
				for (int i = 0; i < temp.length; ++ i) {
					isTheSame = isTheSame && (count[i] == temp[i]);
				}
				if (isTheSame) {
					isFound = true;
					break;
				}
			}
			if (!isFound) {
				int[] m = new int[count.length];
				for (int i = 0; i < count.length; ++ i) {
					m[i] = count[i];
				}
				list.add(m);
			}
			return;
		} else if (money < minPrice) {
			return;
		}
		for (int i = 0; i < count.length; i ++) {
			money -= price[i];
			count[i] ++;
				search(price, list, money, count);
			count[i] --;
			money += price[i];
		}
	}
	
//	@Test
//	public void test() {
//		ArrayList<int[]> list = new ArrayList<int[]>();
//		list.add(new int[]{1,2,3});
//		list.add(new int[]{1,2,3,4});
//		list.add(new int[]{1,2,3,5});
//		list.add(new int[]{1,2,3,6});
//		Iterator<int[]> it = list.iterator();
//		while(it.hasNext()) {
//			int[] temp = it.next();
//			for (int i = 0; i < temp.length - 1; ++ i) {
//				System.out.print(temp[i] + " ");
//			}
//			System.out.println(temp[temp.length-1]);
//		}
//	}

}
