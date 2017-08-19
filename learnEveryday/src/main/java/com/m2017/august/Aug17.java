package com.m2017.august;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 4Sum II
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * Created by a-mdx on 2017/8/17.
 * https://leetcode.com/problems/4sum-ii/description/
 * 看着似乎还是很有难度的，得好好想想了
 * 这就是 用 空间换时间 吗？ 一颗赛艇
 */
public class Aug17 {

    // 昨天偶尔看到的一种解题思路
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int num = A[i] + B[j];
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }

            }
        }

        int sum = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int num = C[i] + D[j];
                num = -num;
                if (map.containsKey(num)) {
                    sum += map.get(num);
                }
            }
        }

        return sum;
    }

    // 这个会超时，n^4 的时间复杂度，我也是醉了
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        // 1.sort
//        Arrays.sort(A);
//        Arrays.sort(B);
//        Arrays.sort(C);
        Arrays.sort(D);

        // 2.
        int sum = 0;

//        int bIndex = B.length/2;
//        int cIndex = C.length/2;
//        int dIndex = D.length/2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    int expect = 0 - (A[i] + B[j] + C[k]);

                    for (int l = 0; l < D.length; l++) {
                        if (expect == D[l]) {
                            sum++;
                        }
                    }

//                    int dIndex = D.length/2;
//                    int temp = dIndex;
//                    int count = 0;
//                    while (true){
//                        count++;
//                        if (expect == D[dIndex]){
//                            sum++;
//                            break;
//                        }else if (expect > 0){
//                            dIndex++;
//                        }else {
//                            dIndex--;
//                        }
//                        if (dIndex >= D.length || dIndex < 0 || count > temp){
//                            break;
//                        }
//                    }

                }
            }
        }

        return sum;
    }

    @Test
    public void test() {
        int[] arr = {1, 2};
        int[] brr = {-2, -1};
        int[] crr = {-1, 2};
        int[] drr = {0, 2};
        System.out.println(fourSumCount(arr, brr, crr, drr));
    }

}
