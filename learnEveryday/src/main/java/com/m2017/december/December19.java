package com.m2017.december;

import org.junit.Test;

import java.util.*;

/**
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * Created by a-mdx on 2017/12/19.
 * https://leetcode.com/problems/subsets-ii/description/
 * 好久没来算法了
 * 跑通可以的，但是，不知道能否通过算法，而且这个排序规则实在不好掌握，明天去提交看看。2017年12月19日 22:22:41
 */
public class December19 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> checkSet = new HashSet<>();

        int nowIndex = nums.length-1;
        List<Integer> tempList = new ArrayList<>();
        genValue(result, nums, nowIndex, tempList, checkSet);
        result.add(new ArrayList<>());
        return result;
    }

    private void genValue(List<List<Integer>> result, int[] nums, int nowIndex, List<Integer> tempList, Set<Integer> checkSet) {
        if (nowIndex < 0) {
            return;
        }

        List<Integer> temp = new ArrayList<>(tempList);

        // 不加 ，走一遍
        genValue(result, nums, nowIndex -1, temp, checkSet);

        temp.add(nums[nowIndex]);

        temp.sort(Comparator.comparing(s -> s));
        if (checkSet.add(temp.hashCode())) {
            // 为 true 了
            result.add(temp);
        }

        // 加了走一遍
        genValue(result, nums, nowIndex -1, temp, checkSet);

    }

    @Test
    public void test1() {
        List<List<Integer>> list = subsetsWithDup(new int[]{1, 2, 2});
        list.forEach(System.out::println);
    }


}
