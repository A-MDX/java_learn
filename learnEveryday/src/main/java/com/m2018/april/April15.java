package com.m2018.april;

import org.junit.Test;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和-，计算两整数a 、b之和。
 * <p>
 * 示例：
 * 若 a = 1 ，b = 2，返回 3。
 * Create by A-mdx at 2018-04-15 18:15
 */
public class April15 {
    public int getSum(int a, int b) {
        if (b == Integer.MIN_VALUE) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a++;
            }
        } else {
            b = -b;
            for (int i = 0; i < b; i++) {
                a--;
            }
        }

        return a;
    }

    @Test
    public void test1() {
        System.out.println(getSum(2147483647, -2147483648));


    }
}
