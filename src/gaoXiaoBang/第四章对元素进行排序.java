/*
设有 5 个互不相同的元素 a、b、c、d、e，能否通过不多于 7 次比较就将其排好序？
如果能，请列出其比较过程；如果不能，则说明原因。

7次
1   a与b进行比较，c与d进行比较。有：（比较次数：2）
             a > b  &&  c > d
             a > b  &&  c < d
             a < b  &&  c > d
             a < b  &&  c < d
             
2   假定是         a > b  &&  c > d
         继续比较     b和d（即上面比较两个较小的）。有：（比较次数：3）
             b > d  即： a > b > d && c > d
             d > b  即： c > d > b && a > b
             
3   假定是         b > d  即： a > b > d && c > d
         继续比较     将e插入上式   a > b > d  中，
                             比较两次即可完成比较（折半插入）。有：（比较次数：5）
             e > a > b > d   （i）
             a > e > b > d   （ii）
             a > b > e > d   （iii）
             a > b > d > e   （iiii）
             
4   假定是         e > a > b > d
                            （已知   c > d ， i、ii、iii是完全一样的
                                iiii比上三式简单一点）
         继续比较     比较两次即可完成比较（折半插入）。有：（比较次数：7）
             
 */

package gaoXiaoBang;

public class 第四章对元素进行排序 {
	public static void main(String[] args) {
		
	}
}