/*
�����ı��ʽ��Ϊ��׺���ʽ����������м䣬��Ҫ�Ǹ����Ķ��ģ�������Ⲣ�����㡣

���磺3 + 5 * (2 + 6) - 1

���ң�������Ҫ���������ı��������

�෴�����ʹ���沨�����ʽ��ǰ׺���ʽ����ʾ���������ʽ���ʾΪ��

- + 3 * 5 + 2 6 1

������Ҫ���ţ����������õݹ�ķ����ܷ������⡣

Ϊ�˼�㣬���Ǽ��裺

1. ֻ�� + - * ���������

2. ÿ������������һ��С��10�ķǸ�����

����ĳ����һ���沨����ʾ��������ֵ��

�䷵��ֵΪһ�����飺���е�һԪ�ر�ʾ��ֵ������ڶ���Ԫ�ر�ʾ���ѽ������ַ�����

��дȱ�ٵĴ���

static int[] evaluate(String x)

{

if(x.length()==0) return new int[] {0,0};

char c = x.charAt(0);

if(c>='0' && c<='9') return new int[] {c-'0',1};

int[] v1 = evaluate(x.substring(1));

int[] v2 = __________________________________________; //���λ��

evaluate(x.substring(v1[1]+1));



int v = Integer.MAX_VALUE;

if(c=='+') v = v1[0] + v2[0];

if(c=='*') v = v1[0] * v2[0];

if(c=='-') v = v1[0] - v2[0];

return new int[] {v,1+v1[1]+v2[1]};

}
 */

package gaoXiaoBang;

public class �����±��ʽ��ֵ_ȱ�ٴ�����д {
	public static void main(String[] args) {
		int[] ans = evaluate("-+3*5+261");
//		int[] ans = evaluate("+3*5+26");
//		int[] ans = evaluate("-*58+31");
		
		System.out.println(ans[0] + "  " + ans[1]);
		System.out.println("AAA".substring(1).length());
	}
	static int[] evaluate(String x)

	{

	if(x.length()==0) return new int[] {0,0};

	char c = x.charAt(0);

	if(c>='0' && c<='9') return new int[] {c-'0',1};

	int[] v1 = evaluate(x.substring(1));

//	int[] v2 = x.length() > 1 ? evaluate(x.substring(2)) : new int[]{0,0}; //���λ��
	int[] v2 = evaluate(x.substring(v1[1]+1)); //���λ��



	int v = Integer.MAX_VALUE;

	if(c=='+') v = v1[0] + v2[0];

	if(c=='*') v = v1[0] * v2[0];

	if(c=='-') v = v1[0] - v2[0];

	return new int[] {v,1+v1[1]+v2[1]};

	}
}
