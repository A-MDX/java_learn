package com.m2017.July;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Created by a-mdx on 2017/7/19.
 * https://leetcode.com/problems/combinations/#/description
 * 这道题还是蛮简单的，主要是感觉跟以前写的特别相似
 */
public class July19 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> ints = new ArrayList<>();
        trans(1, n, k, ints, list);

        return list;
    }

    private void trans(int start, int end, int k, List<Integer> ints, List<List<Integer>> list){
        if (k < 1){

            list.add(new ArrayList<>(ints));
            return;
        }

        for (int i = start; i <= end-k+1; i++) {
            ints.add(i);
            trans(i+1, end, k-1, ints, list);
            ints.remove((Integer) i);
        }

    }

    @Test
    public void test1(){
        List<List<Integer>> list = combine(4, 2);
        list.forEach(System.out::println);
    }


}
