package nowCoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


/*
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 
处理： 
 
1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 
2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 
3、 输入的文件可能带路径，记录文件名称不能带路径。


输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。


输出描述:
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：

输入例子:
E:\V1R2\product\fpgadrive.c   1325

输出例子:
fpgadrive.c 1325 1
 */
public class 华为简答错误记录 {
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
