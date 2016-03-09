package nowCoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


/*
 * ����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš�
 
���� 
 
1�� ��¼���8�������¼��ѭ����¼������ͬ�Ĵ����¼�����ļ����ƺ��к���ȫƥ�䣩ֻ��¼һ��������������ӣ�
 
2�� ����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
 
3�� ������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·����


��������:
һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������


�������:
�����еļ�¼ͳ�Ʋ�������������ʽ���ļ��� �������� ��Ŀ��һ���ո�������磺

��������:
E:\V1R2\product\fpgadrive.c   1325

�������:
fpgadrive.c 1325 1
 */
public class ��Ϊ�������¼ {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Ans a = new Ans ();
		while (sc.hasNext()) {
			String errorAddr = sc.next();
			//System.out.println(errorAddr.substring(errorAddr.lastIndexOf('\\'), errorAddr.length()));
			int errorLine = sc.nextInt();
			a.add(errorAddr.substring(errorAddr.lastIndexOf('\\')+1, errorAddr.length()), errorLine);
			a.printAll();
		}
		a.printAll();
		sc.close();
	}
	static class Ans {
		Map<Integer, Record> map = new HashMap<Integer,Record>();
		public void add (String errorAddr, int errorLine) {
			Record r = new Record(errorAddr, errorLine);
			if (map.containsKey(errorAddr.hashCode()+errorLine*errorLine*errorLine)) {
				++ map.get(errorAddr.hashCode()+errorLine*errorLine*errorLine).errorTimes;
			} else {
				map.put(errorAddr.hashCode()+errorLine*errorLine*errorLine, r);
			}
		}
		public void printAll () {
			if (map.isEmpty())   return;
			Iterator<Integer> it = map.keySet().iterator();
			while (it.hasNext()) {
				int key = it.next();
				Record r = map.get(key);
				System.out.println(r.errorAddr +" "+r.errorLine+" "+r.errorTimes);
			}
		}
		static class Record {
			String errorAddr;
			int errorLine;
			int errorTimes;
			public Record () {
				this(null, -1, 1);
			}
			public Record (String errorAddr, int errorLine) {
				this(errorAddr, errorLine, 1);
			}
			public Record (String errorAddr, int errorLine, int errorTimes) {
				this.errorAddr = errorAddr;
				this.errorLine = errorLine;
				this.errorTimes = errorTimes;
			}
			@Override
			public boolean equals (Object x) {
				if (! ( x instanceof Record) )   return false;
				Record rx = (Record) x;
				return (rx.equals(this.errorAddr) && this.errorLine == rx.errorLine);
			}
			@Override
			public int hashCode () {
				return (int)(this.errorAddr.hashCode()+errorLine*errorLine*errorLine);
			}
		}
	}
}
