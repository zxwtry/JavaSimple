package gaoXiaoBang;


/*



���������㷨

ĳСѧҪ���ܸ�ѧ���������������Ǹ�һ��������

��Ȼ�������������Ҳ�Ǹ��ݷ�����������ġ�

����

��ٷ��Ƶķ���Ϊ n

����� n �ķ�Χ��

90-100�� ����

80-89�� ����

70-79: ����

60-69: �ϸ�

0-59: ����

�Ѿ�֪���˷��� n�� ����㡰������

ע�⣺������ʹ��else��䣬��ȻҲ����ʹ�� switch����Ϊ��Ŀ��Ŀ����ѵ��������������


 */



public class �㷨03����������_�����㷨 {
	private static final String[] LEVEL = {"����",  "�ϸ�",  "����",  "����",  "����"};
	public static void main(String[] args) {
		System.out.println(getLevel(50));
		System.out.println(getLevel(60));
		System.out.println(getLevel(90));
		System.out.println(getLevel(100));
	}
	
	private static String getLevel (int mark) {
		if (mark<60)
			mark = 59;
		if (mark>99)
			mark = 99;
		return LEVEL[((mark/60)*10+mark-60)/10];
	}
}
