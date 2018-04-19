package com.m2018.april;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * Create by A-mdx at 2018-04-18 21:52
 * https://leetcode-cn.com/problems/combination-sum/description/
 * 应该也是回溯法，但不是一般的回溯。。。
 * 中等难度，感觉还行
 */
public class April18Plus {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        helper(candidates, 0, one, result, target, 0);
        return result;
    }

    private void helper(int[] candidates, int index, List<Integer> one, List<List<Integer>> result, int target, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(one));
            return;
        } else if (sum > target) {
            return;
        } else if (index == candidates.length) {
            return;
        }
        int num = candidates[index];
        one.add(num);
        helper(candidates, index, one, result, target, sum + num);
        one.remove(one.size() - 1);
        helper(candidates, index + 1, one, result, target, sum);
    }

    @Test
    public void test1() {
        int[] arr = {2, 3, 5};
        List<List<Integer>> result = combinationSum(arr, 8);
        result.forEach(System.out::println);

    }
}
