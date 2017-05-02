package com.m2017.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * Created by A-mdx on 2017/5/1.
 */
public class May01 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rlist = new ArrayList<>();
        findList(new ArrayList<>(), rlist, nums);
        return rlist;
    }

    public void findList(List<Integer> list, List<List<Integer>> rlist, int[] nums) {
        // 无意间写出了方法名与参数
        if (list.size() == nums.length) {
            rlist.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                findList(list, rlist, nums); // 好神奇的方法 
                list.remove(list.size() - 1);
            }
        }

    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> rlist = permute(arr);
        rlist.forEach(System.out::print);
    }

    @Test
    public void test1() {
        int[] arr = {0, 1, 0, 1, 0, 1};
        changgeArr(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
    }

    public void changgeArr(int[] arr) {
        arr[0] = 9;
    }
}
