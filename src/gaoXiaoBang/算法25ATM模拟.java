package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*

 ATMģ��

����������

ʹ���ַ��û����档
����������Ŀ��ź����루��ʼ����Ϊ123456��������666666��
ʱ��ϵͳ�ܵ�¼ATM��Ա��ϵͳ���û����԰������¹�����У�

1��������β�����ȷ�������룬���˳�����

2����ѯ����ʼ���Ϊ10000Ԫ��

3��ATMȡ�ÿ��ȡ����Ϊ100�ı�����
�ܶ����5000Ԫ��֧ȡ������͸֧��

4��ATM�����ܳ��ָ���

5���޸����룺�����볤�Ȳ�С��6λ��
���������6λ��ȫ��ͬ�������
ֻ�о�������ȷ�����������Ҫ��ſ��Գɹ��޸����롣

6�����š����롢������д���ļ��С�

���2����Э��ʵ�ֳ���Ҫ��Ĺ��ܡ�

Account�ࣺ��ʾ�͹����û����˻���Ϣ��
���棺�˺š����롢�����Ϣ���ṩ������
ʵ�ֶ���Щ��Ϣ�İ�ȫ�޸ĺͶ�ȡ��

ATM�ࣺ�ṩ�û��������棬�����û����������
��һ������Account����ɾ����ʵ���ԵĹ�����
���ಶ�����û����ַǷ�������ɵĴ���
���Ѻõķ�ʽ��ʾ�û��������롣 

 */


public class �㷨25ATMģ�� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int id,password;
			System.out.println("�������˻��ţ�");
			id = Integer.parseInt(br.readLine().trim());
			boolean isReturnForTimes = false;
			for (int passwordWrongTimes = 0; passwordWrongTimes < 3; ++ passwordWrongTimes) {
				System.out.println("���������룺");
				password = Integer.parseInt(br.readLine().trim());
				if (password == Bank.getPassword(id)) {
					break;
				}
				if (passwordWrongTimes == 2) {
					System.out.println("��������������ࣨ�Ѿ�����3�Σ�\nϵͳ���˳�");
					Thread.sleep(1000);
					isReturnForTimes = true;
				}
			}
			if (isReturnForTimes) {
				break;
			}
			System.out.println(Bank.getMoney(id));
		}
		br.close();
	}
	static class Bank {
		private static Map<Integer, Account> bankMap = new HashMap<Integer, Account>();
		static {
			bankMap.put(123456, new Account(123456, 666666 , 10000));
		}
		public void add(int id) {
		}
		public static double getMoney (int id) {
			return bankMap.get(id).getMoney();
		}
		public static int getPassword (int id ) {
			return bankMap.get(id).getPassword();
		}
		static class Account {
			private int id,password;
			private double money;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public int getPassword() {
				return password;
			}
			public void setPassword(int password) {
				this.password = password;
			}
			public double getMoney() {
				return money;
			}
			public void setMoney(double money) {
				this.money = money;
			}
			public Account () {
			}
			public Account (int id, int password, double money) {
				this.id = id;
				this.password = password;
				this.money = money;
			}
			
		}
	}
}
