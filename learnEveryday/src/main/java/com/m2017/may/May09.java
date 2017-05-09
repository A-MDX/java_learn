package com.m2017.may;

import org.junit.Test;

/**
 * Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Created by A-mdx on 2017/5/9.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description
 * 这个，就是说，求多次买卖的最大收益呀，不止是最高收益。
 * 2017年5月9日 18:28:04 回家验证一下对不对。
 */
public class May09 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int length = prices.length;
		if (length < 1) {
			return profit;
		}

		profit = findProfit(0, 1, profit, prices);

		return profit;
	}

	public int findProfit(int minIndex, int nowIndex, int nowProfit, int[] prices) {
		// 坐标
		if (nowIndex > prices.length - 1) {
			return nowProfit;
		}

		int min = prices[minIndex];

		int tempProfit = nowProfit;
		int waitProfit = nowProfit;
		for (int i = nowIndex; i < prices.length; i++) {
			int now = prices[i];
			if (now > min) {
				tempProfit += (now - min);
				// 1.直接拿走这次收益，去下一条路
				tempProfit = findProfit(i + 1, i + 2, tempProfit, prices);
				// 2. 跳过这次收益，下次拿
				waitProfit = findProfit(minIndex, i + 1, waitProfit, prices);
				break;
			} else {
				min = now;
				minIndex = i;
			}
		}
		if (tempProfit > waitProfit) {
			return tempProfit;
		}
		return waitProfit;
	}

	@Test
	public void test1() {
		int[] arr = {1, 5, 6, 9};
		System.out.println(maxProfit(arr));
	}
}
