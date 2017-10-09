package com.m2017.october;

import org.junit.Test;

/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Created by a-mdx on 2017/10/9.
 * https://leetcode.com/problems/multiply-strings/description/
 * 每日一练，继续
 * 这道题，似乎有点麻烦, 光自己想还真难
 * 想了半天想明白后，真感觉要给大神跪了
 */
public class Octo09 {

    // 看网上的  https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j, p2 = i + j + 1;

                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;

            }
        }

        StringBuilder str = new StringBuilder();
        for (int po : pos) {
            if (po != 0 || str.length() != 0) {
                str.append(po);
            }
        }
        return str.length() == 0 ? "0" : str.toString();
    }


    public String multiply1(String num1, String num2) {
        long n1 = tranStr(num1);
        long n2 = tranStr(num2);

        return n1 * n2 + "";
    }

    public long tranStr(String str) {
        long num = 0;

        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i);
            num = num * 10 + temp - 48;
        }

        return num;
    }

    @Test
    public void test1() {
        System.out.println((int) '1');
        System.out.println(tranStr("12345"));

    }

}
