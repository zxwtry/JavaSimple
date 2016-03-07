/*
正常的表达式称为中缀表达式，运算符在中间，主要是给人阅读的，机器求解并不方便。

例如：3 + 5 * (2 + 6) - 1

而且，常常需要用括号来改变运算次序。

相反，如果使用逆波兰表达式（前缀表达式）表示，上面的算式则表示为：

- + 3 * 5 + 2 6 1

不再需要括号，机器可以用递归的方法很方便地求解。

为了简便，我们假设：

1. 只有 + - * 三种运算符

2. 每个运算数都是一个小于10的非负整数

下面的程序对一个逆波兰表示串进行求值。

其返回值为一个数组：其中第一元素表示求值结果，第二个元素表示它已解析的字符数。

填写缺少的代码

static int[] evaluate(String x)

{

if(x.length()==0) return new int[] {0,0};

char c = x.charAt(0);

if(c>='0' && c<='9') return new int[] {c-'0',1};

int[] v1 = evaluate(x.substring(1));

int[] v2 = __________________________________________; //填空位置

evaluate(x.substring(v1[1]+1));



int v = Integer.MAX_VALUE;

if(c=='+') v = v1[0] + v2[0];

if(c=='*') v = v1[0] * v2[0];

if(c=='-') v = v1[0] - v2[0];

return new int[] {v,1+v1[1]+v2[1]};

}
 */

package gaoXiaoBang;

public class 第六章表达式求值_缺少代码填写 {
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

//	int[] v2 = x.length() > 1 ? evaluate(x.substring(2)) : new int[]{0,0}; //填空位置
	int[] v2 = evaluate(x.substring(v1[1]+1)); //填空位置



	int v = Integer.MAX_VALUE;

	if(c=='+') v = v1[0] + v2[0];

	if(c=='*') v = v1[0] * v2[0];

	if(c=='-') v = v1[0] - v2[0];

	return new int[] {v,1+v1[1]+v2[1]};

	}
}
