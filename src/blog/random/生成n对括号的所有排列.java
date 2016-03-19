package blog.random;

import java.util.LinkedList;
import java.util.ListIterator;

/*

����n�����ŵ����кϷ�����

ʵ��

n = 3�����еĺϷ�����

((()))  (()()) (())() ()(()) ()()()     

˼·

���һ������Ϊ2n�ĺϷ����У���1��2n��λ�ö��������¹���

1
�����ŵĸ����������ŵĸ���
���ԣ����ǾͿ��԰����������ȥ��ӡ����

������λ��k���ǻ�ʣ��left�������ź�right��������

���left��right��Ϊ�㣬��˵�������Ѿ����һ���Ϸ����У����Խ����ӡ����
���left>0����ӡ������
���right>0 ���� right>left ��ӡ������

 */
public class ����n�����ŵ��������� {
	public static void main(String[] args) {
		ListIterator<String> it = generateAllMatching(3).listIterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
	static LinkedList<String> generateAllMatching (int n) {
		LinkedList<String> result = new LinkedList<String>();
		generateAllMatching (n, n, "", result);
		return result;
	}
	static void generateAllMatching (int leftNum, int rightNum, String s, LinkedList<String> result) {
		if (leftNum == 0 && rightNum == 0)
			result.add(s);
		if (leftNum > 0)
			generateAllMatching (leftNum-1, rightNum, s + '(', result);
		if (rightNum > 0 && leftNum < rightNum)
			generateAllMatching (leftNum, rightNum-1, s + ')', result);
	}
}
