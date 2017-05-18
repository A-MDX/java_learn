package com.m2017.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Basic Calculator II
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * Created by A-mdx on 2017/5/18.
 * https://leetcode.com/problems/basic-calculator-ii/#/description
 * 真难，应该说麻烦。记得前些天学的栈，我记得似乎可以用这个 栈 数据结构来做。。
 */
public class May18 {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");

        String[] numStr = s.split("[[/*\\-+]]");

        // 获取全部数组
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numStr.length; i++) {
            nums.add(Integer.valueOf(numStr[i]));
        }

        // 数字用 n 代替
        String s2 = s.replaceAll("[0-9]", "");
        // 乘除用 a 代替
        String s1 = s2.replaceAll("[*/]", "a");
        // 加减用 b 代替
        s1 = s1.replaceAll("[+-]", "b");

        // s1 成了纯ab符号，s2 成了+-*/
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(nums);

        // 解析 乘除
        int temp;
        while ((temp = s1.indexOf("a")) > -1) {
            Integer newInt = cal(nums.get(temp), nums.get(temp + 1), s2.charAt(temp));
            // 删除下一位，然后删除 这个符号。
            nums.set(temp, newInt);
            nums.remove(temp + 1);

            // 删除老数组1
            s1 = delIndex(s1, temp);
            s2 = delIndex(s2, temp);

        }

        // 解析加减, 快速的。
        int sum = nums.get(0);
        for (int i = 0; i < s1.length(); i++) {
            sum = cal(sum, nums.get(i + 1), s2.charAt(i));
        }

        return sum;
    }

    private Integer cal(Integer num1, Integer num2, char flag) {
        switch (flag) {
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return 0;
        }
    }

    private String delIndex(String str, int index) {
        char[] arr = str.toCharArray();
        arr[index] = 'f';
        str = new String(arr);
        str = str.replaceAll("f", "");
        return str;
    }

    @Test
    public void test2() throws Exception {
        System.out.println(calculate("3+2*2+2"));
    }

    @Test
    public void test1() {
        String str = "3+2*2-2/7*7";
        System.out.println(str.replaceAll("[*/]", "a"));
        System.out.println(Arrays.toString(str.split("[/*\\-+]")));
    }

}
