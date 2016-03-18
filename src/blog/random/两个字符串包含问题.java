package blog.random;

import java.util.Arrays;

/*


������char* �� A �� B������A�� abcd, B�� xadbdweg, �����B�����ǰ�����A�ģ�x��adbd��weg��˳�򲻹ܣ�ֻҪ����ͬ�������ĸ�Ϳ��ԡ�
�����Թ٣�A�������ĸ�᲻���ظ����ᣡ
Ȼ��ʼ���ˡ�֪��Ҫ��¼��Ϣ��������ô���벻�����뵽�ķ�������o(n^2)�ġ���hash����¼A�������ĸ����B��ʼɨ�����Ǹ���ĸ�����ڣ����ڲ���ɨ������hashֵ-1��������һ����������������nƽ��������
����������Σ����Թٸ����ˡ�˫ָ����������
֪��A�ĳ���m�����B�����ȡ��ô�������Աȡ��������ʣ�ȥ��B�ĵ�һλ������m+1λ���ٶԱȡ�
�����м��m-2λ�����֪������ֻҪo��1����ʱ�䡣
��Ϊһ����26����ĸ�����Կ����ø�counter����¼��ǰ�����ٸ���ĸ������һ�¡���counterΪ0ʱ���ͱ�ʾ�ҵ�һ�����ϵ��Ӵ���


 */
public class �����ַ����������� {
	public static void main(String[] args) {
		//����˳��һ�����Ȳ����Ǵ�Сд����
		String str1 = "AACD", str2="AAAADAAACAADAEEADADFF";
		System.out.println(isHas(str1.toCharArray(), str2.toCharArray()));
	}
	static int isHas (char[] shortArray, char[] longArray) {
		boolean isFound = false;
		int firstMatchBeginIndex = 0;
		final int m = shortArray.length;
		int count = 0;
		int[] mapShort = new int[26];
		int[] mapLong = new int[26];
		Arrays.fill(mapShort, 0);
		Arrays.fill(mapLong, 0);
		for (int i = 0; i < m; i ++) {
			mapShort[shortArray[i]-'A'] ++;
			mapLong[longArray[i]-'A'] ++;
		}
		for (int i = 0; i < 26; i ++) {
			count += Math.abs(mapShort[i] - mapLong[i]);
		}
		if (count == 0)
			return 0;
		for (int i = m; i < longArray.length; i ++) {
			//��һ�����ǽ�ɾ�����ֲ�����
			int indexOfToBeDeleted = longArray[i-m]-'A';
			if (mapShort[indexOfToBeDeleted] == 0) {
				count --;
			} else {
				if (mapLong[indexOfToBeDeleted] == mapShort[indexOfToBeDeleted])
					count ++;
				else if (mapLong[indexOfToBeDeleted] > mapShort[indexOfToBeDeleted])
					count --;
				else
					count ++;
			}
			mapLong[indexOfToBeDeleted] --;
			//�ڶ������ǽ�Ҫ��ӵ���ӽ���
			int indexOfToBeAdded = longArray[i]-'A';
			if (mapShort[indexOfToBeAdded] == 0) {
				count ++;
			} else {
				if (mapLong[indexOfToBeAdded] == mapShort[indexOfToBeAdded])
					count ++;
				else if (mapLong[indexOfToBeAdded] > mapShort[indexOfToBeAdded])
					count ++;
				else
					count --;
			}
			mapLong[indexOfToBeDeleted] ++;
			if (count == 0) {
				isFound = true;
				firstMatchBeginIndex = i - m + 1;
				break;
			}
		} 
		if (isFound) {
			return firstMatchBeginIndex;
		} else {
			System.out.println("û���ҵ�");
			return Integer.MAX_VALUE;
		}
	}
}
