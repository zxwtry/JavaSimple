/*
С������һ���ǹ��ꡣ������Ĳã���ˮ���ǰ���4��һ����7��һ�������֡��ǹ����ܲ������

С���������ǵ�ʱ�������������ְ�װ����ϡ�
��Ȼ��Щ�ǹ���Ŀ���޷���ϳ����ģ�����Ҫ�� 10 ���ǡ�

������ü��������һ�£������ְ�װ����£�������򵽵�������17��
����17���κ����ֶ�������4��7��ϳ�����

�����Ҫ���������֪������װ������ʱ�����������ϳ������֡�

���룺
��������������ʾÿ�ְ�װ���ǵĿ���(��������1000)

Ҫ�������
һ������������ʾ������򵽵�����

���磺
�û����룺
4 7
����Ӧ�������
17

�����磺
�û����룺
3 5
����Ӧ�������
7
 */

package gaoXiaoBang;

public class �����·־�����_���������ϳ������� {
	public static void main(String[] args) {
		myCom my = new myCom(4,7);
		System.out.println(my.getMaxUn());
		my.set(3, 5);
		System.out.println(my.getMaxUn());
		my.set(4, 5);
		System.out.println(my.getMaxUn());
		my.set(10, 15);
		System.out.println(my.getMaxUn());
	}
	static class myCom {
		int a, b;
		boolean isFinished;
		public myCom(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public void set(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int getMaxUn() {
			int i = a*b-1;
			for (; i>a && i>b; -- i) {
				isFinished = false;
				if (i%a==0 || i%b==0)    continue;
				bfs(i);
				if (!isFinished) {
					break;
				}
			}
			return i;
		}
		private void bfs(int data) {
			if (isFinished || (data<a&&data<b))    return;
			if (data==a || data==b)    isFinished = true;
			bfs(data-a);
			bfs(data-b);
		}
	}
}
