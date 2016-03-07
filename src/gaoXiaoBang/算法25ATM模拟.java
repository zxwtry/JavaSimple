package gaoXiaoBang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*

 ATM模拟

程序描述：

使用字符用户界面。
当输入给定的卡号和密码（初始卡号为123456，密码是666666）
时，系统能登录ATM柜员机系统，用户可以按照以下规则进行：

1、如果三次不能正确输入密码，则退出程序。

2、查询余额：初始余额为10000元。

3、ATM取款：每次取款金额为100的倍数，
总额不超过5000元，支取金额不允许透支。

4、ATM存款：不能出现负存款。

5、修改密码：新密码长度不小于6位，
不允许出现6位完全相同的情况，
只有旧密码正确，新密码符合要求才可以成功修改密码。

6、卡号、密码、余额可以写入文件中。

设计2个类协作实现程序要求的功能。

Account类：表示和管理用户的账户信息。
保存：账号、密码、余额信息。提供方法，
实现对这些信息的安全修改和读取。

ATM类：提供用户操作界面，解释用户输入的请求，
进一步调用Account类完成具体的实质性的工作。
该类捕获因用户各种非法输入造成的错误，
以友好的方式提示用户重新输入。 

 */


public class 算法25ATM模拟 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int id,password;
			System.out.println("请输入账户号：");
			id = Integer.parseInt(br.readLine().trim());
			boolean isReturnForTimes = false;
			for (int passwordWrongTimes = 0; passwordWrongTimes < 3; ++ passwordWrongTimes) {
				System.out.println("请输入密码：");
				password = Integer.parseInt(br.readLine().trim());
				if (password == Bank.getPassword(id)) {
					break;
				}
				if (passwordWrongTimes == 2) {
					System.out.println("密码输入次数过多（已经输入3次）\n系统将退出");
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
