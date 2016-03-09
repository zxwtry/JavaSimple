package dataStructures;

public class ≤ÈKMP2 {
	public static void main(String[] args) {
        String sub = "aabaccfaddddaabc";
        String str = "gdsaadfdgffccsdaabaccfdaddaabaccfaddddaabcga";
        int[] next = getNext(sub);
        pattern(str,sub,next);
	}
	private static int[] getNext (String sub) {
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		int i,j;
		a[0] = -1; i = 0;
		for (j = 1; j < length; j ++) {
			i = a[j-1];
			while (i>=0 & c[j] != c[i+1]) {
				i = a[i];
			}
			if (c[j] == c[i+1])
				a[j] = i+1;
			else
				a[j] = -1;
		}
		return a;
	}
	public static int[] getNext2(char[] t) {
		return null;
	}
	private static void pattern (String str, String sub, int[] next) {
		char[] ch1 = str.toCharArray();
		char[] ch2 = sub.toCharArray();
		int i = 0, j = 0;  
		while (i < ch1.length) {
			if(ch1[i]==ch2[j]) {
                if(j==ch2.length-1) {
                    System.out.println(i-ch2.length+1);
                    break;
                }
                j++;
                i++;
            }
            else if(j==0) {
                 i++;
            }
            else {
                j = next[j-1]+1;
            }
		}
	}
}
