package com.m2017.July;

/**
 * Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * Created by a-mdx on 2017/7/11.
 * https://leetcode.com/problems/number-of-1-bits/#/description
 * 一个简单的小算法，主要是复习一下位运算。
 */
public class July11 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int size = 0;

        if (n > 0) {


        } else if (n < 0) {
            if (Math.abs(n) / 2 == 0) {
                size++;
            }
            n = n >>> 1;
        }

        while (n > 1) {
            if (n % 2 == 1) {
                size++;
            }
            n = n / 2;
        }
        if (n == 1) {
            size += 1;
        }

        return size;


    }

    public static void main(String... args) {
        July11 main = new July11();
        System.out.println(main.hammingWeight(0xffffffff));

    }
}
