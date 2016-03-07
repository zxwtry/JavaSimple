package gaoXiaoBang;

import java.util.HashSet;
import java.util.Set;

public class 第五章分酒问题例子 {
	public static void main(String[] args) {
		Set<OilState> set = new HashSet<OilState>();
		set.add(new OilState(12, 0, 0));
		for ( ; ; ) {
			Set<OilState> newSet = new HashSet<OilState>();
			for (Object x : set) {
				OilState x2 = (OilState)x;
				Set<OilState> t = x2.op();
				newSet.addAll(t);
			}
			if (set.containsAll(newSet))    break;
			set.addAll(newSet);
		}
		for (Object k : set) {
			OilState k2 = (OilState)k;
			if(k2.has(6)) {
				while(k2 != null) {
					System.out.println(k2);
					k2 = k2.getFrom();
				}
			}
		}
	}
	static class OilState{
		static int[] full = {12, 8, 5};
		int[] v = new int[3];
		OilState from;
		public OilState(int a, int b, int c) {
			v[0] = a;
			v[1] = b;
			v[2] = c;
		}
		public Set<OilState> op () {
			Set<OilState> re = new HashSet<OilState>();
			for (int i = 0; i < v.length; ++ i)
				for (int j = 0; j < v.length; ++ j) {
					if (i == j)           continue;
					if (v[i] == 0)        continue;
					if (v[j] == full[j])  continue;
					
					OilState t = new OilState(v[0],v[1],v[2]);
					t.from = this;
					t.v[j] += t.v[i];
					t.v[i] = 0;
					if (t.v[j] > full[j]) {
						t.v[i] = t.v[j] - full[j];
						t.v[j] = full[j];
					}
					re.add(t);
				}
			return re;
		}
		public String toString() {
			return "<" + v[0] + "," + v[1] + "," + v[2] + ">";
		}
		public int hashCode() {
			return 100;
		}
		public boolean equals(Object x) {
			if (!(x instanceof OilState))    return false;
			OilState xo = (OilState)x;
			return v[0]==xo.v[0] && v[1]==xo.v[1] && v[2]==xo.v[2]; 
		}
		public boolean has(int x) {
			return v[0]==x || v[1]==x || v[2]==x; 
		}
		public OilState getFrom() {
			return from;
		}
	}
}
