package com.m2017.june;

import org.junit.Test;

/**
 * 淘汰赛
 * Elimination Game
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 * Created by A-mdx on 2017/6/6.
 * https://leetcode.com/problems/elimination-game/#/description
 * 淘汰赛，左到右，右到左
 * 一道中等难度的题，很有趣
 */
public class June06 {


    // 这是看别人的... 真是日了狗了、比我简单，还比我快。
    // https://discuss.leetcode.com/topic/59293/java-easiest-solution-o-logn-with-explanation
    public int lastRemaining(int n) {
        boolean left = true;
        int remain = n;
        int step = 1;
        int head = 1;
        while (remain > 1){
            if (left || remain%2 == 1){
                head = head + step;
            }
            remain = remain/2;
            step *= 2;
            left = !left;
        }
        return head;
    }

    /**
     * 3375 / 3377 test cases passed.
     Status: Memory Limit Exceeded
     真坑，就差一点
     * @param n
     * @return
     */
    public int lastRemaining2(int n) {
        if (n <= 1) {
            return n;
        }
        n--;
        int length = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] arr = new int[length];
        int index = 0;
        int num = 2;
        while (index < length) {
            arr[index++] = num;
            num += 2;
        }
        boolean flag = true;
        while (arr.length > 1) {
            n = arr.length;
            n--;
            length = n % 2 == 0 ? n / 2 : n / 2 + 1;
            int[] arr1 = new int[length];

            if (flag) {
                index = n-1;
                int index1 = length - 1;
                while (index >= 0) {
                    arr1[index1--] = arr[index];
                    index -= 2;
                }
            } else {
                // old arr
                index = 1;
                // new arr
                int index1 = 0;
                while (index < n + 1) {
                    arr1[index1++] = arr[index];
                    index += 2;
                }
            }
            arr = arr1;
            flag = !flag;
        }
        return arr[0];
    }


    @Test
    public void test1() {
        System.out.println(lastRemaining(9));
    }

    public int lastRemaining1(int n) {
        if (n <= 1) {
            return n;
        }
        n--;
        int length = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] arr = new int[length];
        int index = 0;
        int num = 2;
        while (index < length) {
            arr[index++] = num;
            num += 2;
        }
        return right2left(arr);
    }

    public int right2left(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return arr[0];
        }
        length--;
        int n = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int index = length - 1;
        int[] arr1 = new int[n];
        int index1 = n - 1;
        while (index >= 0) {
            arr1[index1--] = arr[index];
            index -= 2;
        }
        return left2right(arr1);
    }

    private int left2right(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return arr[0];
        }
        length--;
        int n = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int index = 1;
        int index1 = 0;
        int[] arr1 = new int[n];
        while (index < length + 1) {
            arr1[index1++] = arr[index];
            index += 2;
        }
        return right2left(arr1);
    }


}
