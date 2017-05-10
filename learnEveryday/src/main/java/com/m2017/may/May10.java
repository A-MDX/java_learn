package com.m2017.may;

/**
 * Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Created by A-mdx on 2017/5/10.
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description
 *  接着昨天的那道题，昨天的结果都对，就是超时了。
 *  好吧，似乎目前想不到更好的解决办法，先去借鉴下别人的解决思路。
 *  今天只想看会书。
 */
public class May10 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        return total;
    }
    // 说真的，我感觉这个十分奇怪，毫无道理。
    
}
