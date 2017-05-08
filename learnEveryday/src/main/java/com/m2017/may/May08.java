package com.m2017.may;

import org.junit.Test;

/**
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p>
 * In this case, no transaction is done, i.e. max profit = 0.
 * Created by A-mdx on 2017/5/8.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * 简单来说，给你一串股票每天价格表，求最大收益会是多少.
 * 这个是我做了这么多天以来，最简单的一道题了。。
 */
public class May08 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int num = prices[i];

            if (min < num) {
                if (profit < (num - min)) {
                    profit = num - min;
                }
            } else {
                min = num;
            }

        }
        return profit;
    }

    @Test
    public void test1() {
        int[] arr = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr));
    }

}
