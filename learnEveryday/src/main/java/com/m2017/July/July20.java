package com.m2017.July;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Created by a-mdx on 2017/7/20.
 * https://leetcode.com/problems/climbing-stairs/#/description
 * 动态规划，应该算是最简单的动态规划了，but，还是不怎么会。。
 * dynamic programming
 */
public class July20 {
    // https://mp.weixin.qq.com/s/_kHeAI4PvF-KH7IQrmnRVg 

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = a+b;
            a = b;
            b = temp;

        }
        return b;
    }

    @Test
    public void test() throws Exception {
        System.out.println(climbStairs(10));
    }

    public int climbStairs1(int n) {
        // 动态规划 1
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return climbStairs1(n-1)+climbStairs1(n-2);
    }


    private Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs2(int n) {
        if (cache.get(n) != null){
            return cache.get(n);
        }
        // 动态规划 2
        cache.put(1, 1);
        cache.put(2, 2);
        int temp = climbStairs1(n-1)+climbStairs1(n-2);
        cache.put(n, temp);
        return temp;
    }

    public int climbStairs3(int n) {
        // 动态规划 1

        int temp = 3;
        int sum1 = 1;
        int sum2 = 2;
        while (temp <= n){
            int temp1 = sum2;
            sum2 += (sum2 + sum1);
            sum1 = temp1;

            temp ++;
        }

        return sum2;
    }

    @Test
    public void test3() throws Exception {
        System.out.println(climbStairs3(10));
    }

    @Test
    public void test1(){
        int time = climbStairs1(10);
        System.out.println(time);
    }

    @Test
    public void test2(){
        int time = climbStairs2(10);
        System.out.println(time);
    }

}
