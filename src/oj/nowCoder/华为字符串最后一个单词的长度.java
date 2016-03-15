package oj.nowCoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 华为字符串最后一个单词的长度 {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int index = s.lastIndexOf(' ');
        System.out.println(s.length()-index-1);
        br.close();
    }
}
