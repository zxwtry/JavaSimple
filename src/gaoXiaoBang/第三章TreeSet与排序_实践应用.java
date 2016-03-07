/*

class MyData
{
private String province; // ʡ�� ���磺�ӱ�
private String date; // �������ڣ�yy-mm-dd�� ���磺 1989-06-18
private int sno; // ͬһ����Ʒ����ˮ�� ���磺1325
....
}

�ϱߵĽṹ��ʾ��ĳ��Ʒ��������Ϣ

������Ѹ���Ʒ������ӵ� TreeSet�У�����������ظ��ж����⡣

 */

package gaoXiaoBang;

import java.util.Set;
import java.util.TreeSet;

public class ������TreeSet������_ʵ��Ӧ�� {
	public static void main(String[] args) {
		MyTreeSet mts = new MyTreeSet();
		mts.add("HB", "1999-09-09", 123);
		mts.add("HB", "1999-09-08", 124);
		System.out.println(mts);
	}
	static class MyTreeSet {
		Set<MyData> mySet = new TreeSet<MyData>();
		public MyTreeSet() {
		}
		public void add(String province, String data, int sno) {
			mySet.add(new MyData(province, data, sno));
		}
		@Override
		public String toString() {
			return mySet.toString();
		}
		class MyData implements Comparable<MyData>{
			private String province;
			private String data;
			private int sno;
			public MyData() {
			}
			public MyData(String pro, String data, int sno) {
				this.province = pro;
				this.data = data;
				this.sno = sno;
			}
			public String getProvince() {
				return province;
			}
			public void setProvince(String province) {
				this.province = province;
			}
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public int getSno() {
				return sno;
			}
			public void setSno(int sno) {
				this.sno = sno;
			}
			@Override
			public boolean equals(Object obj) {
				if (!(obj instanceof MyData))
					return false;
				MyData myData = (MyData)obj;
				return this.province.equals(myData.getProvince()) && 
						this.data.equals(myData.getData()) && this.sno == myData.getSno();
			}
			@Override
			public int hashCode() {
				return province.hashCode()+data.hashCode()+sno;
			}
			@Override
			public String toString() {
				return province+"  "+data+"  "+sno;
			}
			@Override
			public int compareTo(MyData o) {
				return province.compareTo(o.getProvince()) != 0 ?
						province.compareTo(o.getProvince()) :(data.compareTo(o.getData())
								!= 0 ? data.compareTo(o.getData()) : (sno-o.getSno()));
			}
		}
	}
}
