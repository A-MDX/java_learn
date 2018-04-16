package com.m2018.april;

import org.junit.Test;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * Create by A-mdx at 2018-04-15 18:37
 * https://leetcode-cn.com/problems/add-strings/description/
 * 想练练手
 */
public class April15Pro {

    // 这次使用数组来做
    public String addStrings(String num1, String num2) {
        int size = num1.length() + num2.length();
        char[] arr = new char[size];

        if (num1.length() < num2.length()) {
            // 小于，则交换
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }

        int len2 = num2.length() - 1;
        boolean add1 = false;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a1 = num1.charAt(i) - '0';
            if (len2 >= 0) {
                int b1 = num2.charAt(len2) - '0';
                a1 += b1;
                len2--;
            }
            if (add1) {
                // 是否加 1
                a1++;
                add1 = false;
            }
            if (a1 >= 10) {
                add1 = true;
            }
            a1 = a1 % 10;
            arr[size - 1] = (char) (a1 + '0');
            size--;
        }
        if (add1){
            // 还需要 +1
            arr[size - 1] = 1+'0';
            size--;
        }

        char[] brr = new char[arr.length - size];
        System.arraycopy(arr, size, brr, 0, brr.length);

        return new String(brr);
    }

    // 套路不对，还会面临性能问题，重写
    public String addStrings1(String num1, String num2) {
        int temp = 1;
        long sum = 0L;
        if (num1.length() < num2.length()) {
            // 小于，则交换
            String tempStr = num1;
            num1 = num2;
            num2 = tempStr;
        }

        int len2 = num2.length() - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            if (len2 >= 0) {
                int b = num2.charAt(len2) - '0';
                a += b;
                len2--;
            }
            a *= temp;
            temp *= 10;
            sum = sum + a;
        }

        return sum + "";
    }

    @Test
    public void test2() {
//        String num1 = "6913259244";
//        String num2 = "71103343";
        String num1 = "1";
        String num2 = "9";

        System.out.println(addStrings(num1, num2));
    }

    @Test
    public void test1() {
        String num1 = "6913259244";

        String num2 = "71103343";
        System.out.println(addStrings1(num1, num2));
    }

}
