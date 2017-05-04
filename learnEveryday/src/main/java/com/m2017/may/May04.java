package com.m2017.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * <p>
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * Created by A-mdx on 2017/5/4.
 * https://leetcode.com/problems/combination-sum-iii/#/description
 * 这个有意思，可以使用递归，前些天写的递归
 * 写出来了，但是太慢了，似乎。
 */
public class May04 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rlist = new ArrayList<>();
        findList(new ArrayList<>(), rlist, k, n, 0);
        return rlist;
    }

    public void findList(List<Integer> list, List<List<Integer>> rlist, int k, int n, int next) {
        if (list.size() == k) {
//            final int[] sum = {0};   性能瓶颈主要在这里，没想到可以直接利用一下最终结果。
//            list.forEach( s -> sum[0] += s);
//            sum[0]
            if (0 == n) {
                rlist.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = next + 1; i < 10; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            findList(list, rlist, k, n - i, i);
            list.remove(list.size() - 1); // remove 最后一个
        }

    }

    @Test
    public void test1() {
        System.out.println(combinationSum3(3, 11));
    }

}
