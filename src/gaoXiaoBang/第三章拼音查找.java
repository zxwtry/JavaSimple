/*

������ʹ���ֻ�ͨ��¼��ʱ�򣬶�ϣ���ܿ��ٶ�λĳ�ˡ�

�Ƚ����е�����������ƴ������ĸ��

����ĳ���б��д洢�������ϵ�˵����֡������һ�ֻ����ܹ��Ӹ�����ƴ����λ�����ʵ����������ж����ƥ�䣬��λ����ˡ�

��֧��ģ������

��ʾ�� ���ֵ�GBK������ǰ���ƴ��˳��ġ�ֻҪ���ÿ����ĸ�Ŀ�ʼ���־Ϳ����ˡ�

		try {
			String s = "�����ŵĶ�Ǹ��þͿ�������Ŷ��ȥ����������һ��";
			byte[] b = s.getBytes("gbk");
			for (int i = 0; i < b.length / 2; ++ i) {
				System.out.println(b[2 * i] + "\t" + b[2 * i + 1]);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String temp = br.readLine();
			System.out.println(myNameList.getRelative(temp));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			String s = "��������������������������Њ";
			byte[] b = s.getBytes("gbk");
			int temp = Integer.MAX_VALUE;
			for (int i = 0; i < b.length / 2; ++ i) {
//				System.out.println(s.charAt(i) + "   " + b[2 * i] + "   " + b[2 * i + 1]);
//				temp = Math.min(temp, b[2 * i] * 1000 + b[2 * i + 1]);
				if (b[2 * i] == -40) {
					System.out.println(s.charAt(i) + "   " + b[2 * i] + "   " + b[2 * i + 1]);
					temp = Math.min(temp, b[2 * i] * 1000 + b[2 * i + 1]);
				}
			}
			System.out.println(temp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		a   ��   -80   -95
		b	��   -80    -59
		c	��   -78   -63
		d	��   -76    -18
		e	��   -74    -22
		f	��   -73   -94
		g	��   -72   -63
		h	��   -71   -2
		i
		j	��   -69   -9
		k	��   -65   -90
		l	��   -64   -84
		m	��   -62   -24
		n	��   -60   -61
		o	Ŷ   -59   -74
		p	ž   -59   -66
		q	��   -58   -38
		r	Ȼ   -56   -69
		s	��   -56   -10
		t	��   -53   -6
		u
		v
		w	��   -51   -38
		x	��   -50   -11
		y	ѹ   -47   -71
		z	��   -44   -47
		z	��   -41   -7
		
		
 */

package gaoXiaoBang;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ������ƴ������ {
	public static void main(String[] args) {
		NameList myNameList = new NameList();
		myNameList.addName("��ѧ��");
		myNameList.addName("����ʢ");
		myNameList.addName("����");
		myNameList.addName("����");
		myNameList.addName("�ܽ���");
		myNameList.addName("��С��");
		myNameList.addName("��Ѹ");
		myNameList.addName("�Ź���");
		myNameList.addName("��Ȫ");
		myNameList.addName("Ҧ����");
		myNameList.addName("����");
		myNameList.addName("��Ρ");
		myNameList.addName("����ܿ");
		myNameList.addName("С����");
		myNameList.addName("������");
		myNameList.addName("������");
		myNameList.addName("����");
		myNameList.addName("����");
		myNameList.addName("����");
		//��һ����ʾ����ѡ�񵽵�����		�������ݣ�W WF ZJL ZX zx Zx
		System.out.println(myNameList.getRelative("Zx"));
		//��һ����ʾ����ȫ������
		System.out.println(myNameList.getList());
		
	}
	static class NameList {
		List<String> nameList;
		private HashMap<Character,byte[]> myHashMap;
		public NameList() {
			nameList = new ArrayList<String>();
			myHashMap = new HashMap<Character,byte[]>();
			this.addDictory('a', null);
		}
		public void addName(String name) {
			nameList.add(this.getPosition(name), name);
		}
		public List<String> getList() {
			return nameList;
		}
		public String toString() {
			return nameList.toString();
		}
		//�õ�������zxw��zjl���ܽܣ���֮���String pre
		//��������ǰ׺���ϵ�������ɵ�List<String>
		public List<String> getRelative(String pre) {
			if ((pre.charAt(0) >= 'A' && pre.charAt(0) <= 'Z') || 
					(pre.charAt(0) >= 'a' && pre.charAt(0) <= 'z'))
				return getRelative_Eng(pre);
			else
				return getRelative_Chn(pre);
		}
		//����public List<String> getRelative(String pre)
		private List<String> getRelative_Eng(String str) {
			List<String> ans = new ArrayList<String>();
			if (str.equals(""))   return ans;
			char[] strChar = str.toCharArray();
			int[] dicTemp = new int[2];
			byte[] nameDicTemp;
			int nameDicTempSum;
			String sTemp;
			if (strChar[0] != 'i' && strChar[0] != 'u' && strChar[0] != 'v'
					&& strChar[0] != 'I' && strChar[0] != 'U' && strChar[0] != 'V') {
				if (strChar[0] <= 'Z' && strChar[0] >= 'A') {
					dicTemp = getDictory((char)(strChar[0] - 'A' + 'a'));
					Iterator<String> it = nameList.iterator();
					while(it.hasNext()) {
						try {
							sTemp = it.next();
							nameDicTemp = sTemp.getBytes("gbk");
							nameDicTempSum = nameDicTemp[0] * 1000 + nameDicTemp[1];
							if (nameDicTempSum >= dicTemp[1])   break;
							if (nameDicTempSum >= dicTemp[0])   ans.add(sTemp);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else if (strChar[0] <= 'z' && strChar[0] >= 'a') {
					dicTemp = getDictory(strChar[0]);
					Iterator<String> it = nameList.iterator();
					while(it.hasNext()) {
						try {
							sTemp = it.next();
							nameDicTemp = sTemp.getBytes("gbk");
							nameDicTempSum = nameDicTemp[0] * 1000 + nameDicTemp[1];
							if (nameDicTempSum >= dicTemp[1])   break;
							if (nameDicTempSum >= dicTemp[0])   ans.add(sTemp);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (int i = 1; i < strChar.length; ++ i) {
				if (strChar[i] != 'i' && strChar[i] != 'u' && strChar[i] != 'v'
						&& strChar[i] != 'I' && strChar[i] != 'U' && strChar[i] != 'V') {
					if (strChar[i] <= 'Z' && strChar[i] >= 'A') {
						dicTemp = getDictory((char)(strChar[i] - 'A' + 'a'));
						for (int k = 0; k < ans.size(); ++ k) {
							try {
								nameDicTemp = ans.get(k).getBytes("gbk");
								if (nameDicTemp.length >= (i+1) * 2) {
									nameDicTempSum = nameDicTemp[2 * i] * 1000 + nameDicTemp[2 * i + 1];
									if (nameDicTempSum < dicTemp[0] || nameDicTempSum >= dicTemp[1]) {
										ans.remove(k);
										-- k;
									}
								}
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					} else if (strChar[i] <= 'z' && strChar[i] >= 'a') {
						dicTemp = getDictory(strChar[i]);
						for (int k = 0; k < ans.size(); ++ k) {
							try {
								nameDicTemp = ans.get(k).getBytes("gbk");
								if (nameDicTemp.length >= (i+1) * 2) {
									nameDicTempSum = nameDicTemp[2 * i] * 1000 + nameDicTemp[2 * i + 1];
									if (nameDicTempSum < dicTemp[0] || nameDicTempSum >= dicTemp[1]) {
										ans.remove(k);
										-- k;
									}
								}
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			return ans;
		}
		//����public List<String> getRelative(String pre)
		private List<String> getRelative_Chn(String pre) {
			List<String> ans = new ArrayList<String>();
			for (int i = 0; i < pre.length(); ++ i) {
				
			}
			return ans;
		}
		private int[] getDictory(char myChar) {
			int[] ansInt = new int[2];
			byte[] ansTemp = new byte[2];
			if (myChar != 'z') {
				ansTemp = myHashMap.get(myChar);
				if (ansTemp == null)   return null;
				ansInt[0] = ansTemp[0] * 1000 + ansTemp[1];
				ansTemp = myHashMap.get((char)(myChar+1));
				ansInt[1] = ansTemp[0] * 1000 + ansTemp[1];
			} else {
				ansTemp = myHashMap.get('z');
				if (ansTemp == null)   return null;
				ansInt[0] = ansTemp[0] * 1000 + ansTemp[1];
				ansTemp = myHashMap.get('Z');
				ansInt[1] = ansTemp[0] * 1000 + ansTemp[1];
			}
			return ansInt;
		}
		private void addDictory(char myChar, byte[] myByte) {
			if (myByte != null) {
				myHashMap.put(myChar, myByte);
			} else if (myHashMap.isEmpty()){
				myHashMap.put('a', new byte[]{-80, -95});
				myHashMap.put('b', new byte[]{-80, -59});
				myHashMap.put('c', new byte[]{-78, -63});
				myHashMap.put('d', new byte[]{-76, -18});
				myHashMap.put('e', new byte[]{-74, -22});
				myHashMap.put('f', new byte[]{-73, -94});
				myHashMap.put('g', new byte[]{-72, -63});
				myHashMap.put('h', new byte[]{-71, -2});
				myHashMap.put('i', null);
				myHashMap.put('j', new byte[]{-69, -9});
				myHashMap.put('k', new byte[]{-65, -90});
				myHashMap.put('l', new byte[]{-64, -84});
				myHashMap.put('m', new byte[]{-62, -24});
				myHashMap.put('n', new byte[]{-60, -61});
				myHashMap.put('o', new byte[]{-59, -74});
				myHashMap.put('p', new byte[]{-59, -66});
				myHashMap.put('q', new byte[]{-58, -38});
				myHashMap.put('r', new byte[]{-56, -69});
				myHashMap.put('s', new byte[]{-56, -10});
				myHashMap.put('t', new byte[]{-53, -6});
				myHashMap.put('u', null);
				myHashMap.put('v', null);
				myHashMap.put('w', new byte[]{-51, -38});
				myHashMap.put('x', new byte[]{-50, -11});
				myHashMap.put('y', new byte[]{-47, -71});
				myHashMap.put('z', new byte[]{-44, -47});
				myHashMap.put('Z', new byte[]{-41, -7});
			}
		}
		private int getPosition(String name) {
			Iterator<String> it = nameList.iterator();
			int count = 0;
			while (it.hasNext()) {
				if (!this.isTheFirstOneFormer(it.next(), name))	
					break;
				++ count;
			}
			return count;
		}
		private boolean isTheFirstOneFormer(String a, String b) {
			final int MIN = Math.min(a.length(), b.length());
			try {
				byte[] aBytes = a.getBytes("gbk");
				byte[] bBytes = b.getBytes("gbk");
				int aTemp,bTemp;
				for (int i = 0; i < MIN; ++ i) {
					aTemp = aBytes[2*i] * 1000 + aBytes[2*i+1];
					bTemp = bBytes[2*i] * 1000 + bBytes[2*i+1];
					if (aTemp != bTemp)
						return aTemp < bTemp;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return a.length() == MIN;
		}
	}
}
