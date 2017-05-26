package com.m2017.may;

import org.junit.Test;

/**
 * Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * Created by A-mdx on 2017/5/26.
 * https://leetcode.com/problems/power-of-two/#/description
 * 查看是否是 2 的次方, 看着很简单的题，没想到还想了很久。。
 */
public class May26 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
         while (n > 1){
             int i = n%2;
             if (i == 1){
                 return false;
             }
             n = n/2;
             if (n == 1){
                 return true;
             }
         }
         return true;
    }
    
    @Test
    public void test1(){
        System.out.println(isPowerOfTwo(6));
    }
}
