package nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 华为进制转换 {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while ((s = br.readLine()) != null) {
            char[] c = s.toCharArray();
            int[] in;
            if (c.length>2 && c[0] == '0' && c[1] == 'x') {
                in = new int[c.length-2];
                for (int i = 2; i < c.length; ++ i) {
                    if (c[i] >='A' && c[i] <='Z') {
                        in[i-2] = c[i]-'A' +10;
                    } else if (c[i] >='a' && c[i] <='z') {
                        in[i-2] = c[i]-'a' +10;
                    } else if (c[i] >='0' && c[i] <='9') {
                        in[i-2] = c[i]-'0';
                    }
                }
            } else {
                 in = new int[c.length];
                for (int i = 0; i < c.length; ++ i) {
                    if (c[i] >='A' && c[i] <='Z') {
                        in[i] = c[i]-'A' +10;
                    } else if (c[i] >='a' && c[i] <='z') {
                        in[i] = c[i]-'a' +10;
                    } else if (c[i] >='0' && c[i] <='9') {
                        in[i] = c[i]-'0';
                    }
                }
                
            }
            
            int car = 0;
            for (int i = in.length-1; i > 0; -- i) {
                car = in[i]/10;
                in[i] = in[i]%10;
                in[i-1] += car;
            }
            for (int i = 0 ;i < in.length; i ++) {
                System.out.printf("%d",in[i]);
            }
            System.out.println();
        }
        br.close();
    }
}


