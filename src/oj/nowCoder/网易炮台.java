package oj.nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*


������ѵ��Ī֮��,Ȼ�����Ī������Լ�¶���,̸��Լ�¶���,��Ȼ�ٲ���һ����,
�� ���Ǻ�Ĭ����------Լ�¶�����ʷ����ΰ��Ŀ�ѧ��. 
��Ī˵,��Ĭ���������˼��һ������:��Ĭ������������̨,��̨�ܹ�����������R�ĵ���
 (����֮��ľ���Ϊ���������ľ���,����(3,0),(0,4)֮��ľ�����5),
 ���һ����̨�ܹ��� ������,��ô�ͻ�Ե������1�����˺�.
 ��Ĭ����������̨����N*M�����еĵ���,���Ҹ������� ������. ��:��ô�����ܵ��˺����Ƕ��?

��������:
��һ��9������,R,x1,y1,x2,y2,x3,y3,x0,y0.R������̨������������,(x1,y1),(x2,y2),
(x3,y3)����������̨������.(x0,y0)������˵�����.


�������:
���һ��,��һ�д�����˳��ܵ�����˺�,(���ÿ����̨�����ܹ���������,���0��)

��������:
1 1 1 2 2 3 3 1 2

�������:
2x




 */
public class ������̨ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<P> al = new ArrayList<P> ();
		
		String line = "";

		line = br.readLine().trim();
		
		String[] sp = line.split(" ");
		
		int r = Integer.parseInt(sp[0]);
		
		int index = 1;
		
		for (;index < sp.length; index += 2) {
			al.add(new P (Integer.parseInt(sp[index]), Integer.parseInt(sp[index + 1])));
		}
		
		P[] a = new P[al.size() - 1];
		for (int i = 0; i < a.length; i ++) {
			a[i] = al.get(i);
		}
		System.out.println(getAns(a, al.get(a.length), r));
		
		br.close();
	}
	static String getAns (P[] a, P my, int r) {
		int count = 0;
		for (P i : a) {
			if ( (i.x - my.x) * (i.x - my.x) + (i.y - my.y) * (i.y - my.y)  <= r*r) {
				count ++;
			}
		}
		return String.format("%dx", count);
	}
	static class P {
		int x,y;
		public P (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
