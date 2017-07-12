package com.m2017.July;

import org.junit.Test;

import java.util.*;

/**
 * Smallest Range
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * <p>
 * Example 1:
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * Note:
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -105 <= value of elements <= 105.
 * For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code template, you'll see this point.
 * Created by a-mdx on 2017/7/12.
 * https://leetcode.com/problems/smallest-range/#/description
 * 这道题是 做出来最多的一道 hard 难度题了，想想都复杂呀
 * 感觉先抄一遍可能会懂一点
 * 太难了，这道题我不会坐，抄一遍都不会
 * 干脆再写一道？
 */
public class July12 {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i).get(0);
            Element e = new Element(i, 0, temp);
            pq.offer(e);
            max = Math.max(max, temp);
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()){
            Element curr = pq.poll();
            if (max - curr.val < range){
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            if (curr.idx + 1 < nums.get(curr.row).size()){
                curr.idx++;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max){
                    max = curr.val;
                }
            }
        }

        return new int[]{start, end};
    }
    
    class Element{
        int val;
        int idx;
        int row;
        Element(int r, int i, int v){
            row = r;
            idx = i;
            val = v;
        }
    }

    @Test
    public void test2() throws Exception {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));
        int[] arr = smallestRange(nums);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1(){
        TreeSet<Integer> noDupli = new TreeSet<>();
        noDupli.add(3);
        noDupli.add(1);
        noDupli.add(9);
        noDupli.add(2);
        noDupli.add(4);

        System.out.println(noDupli);

        System.out.println("----------");
        for (Integer i : noDupli) {
            System.out.println(i);
        }

        System.out.println(noDupli);
    }
}
