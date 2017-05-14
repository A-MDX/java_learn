package com.m2017.may;

import org.junit.Test;

/**
 * Ugly Number
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * Created by A-mdx on 2017/5/11.
 * https://leetcode.com/problems/ugly-number/#/description
 * 寻找质数？
 */
    public class May11 {
        public boolean isUgly(int num) {
            for (int i = 2; i < 6 && num > 0; i++) {
                while (num % i == 0) {
                    num /= i;
                }

            }
            return num == 1;
        }

        @Test
    public void test1() {
        System.out.println(isUgly(-51799));
    }
}
