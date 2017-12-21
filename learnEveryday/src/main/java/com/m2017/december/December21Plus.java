package com.m2017.december;

import org.junit.Test;

import java.util.Arrays;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * <p>
 * <p>
 * Created by a-mdx on 2017/12/21.
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * ZHE道题，我可能写多了，脑袋反应不好使了
 *
 * 这里有两道题，一道题是 朋友推荐的，一道题是上述。
 */
public class December21Plus {

    // 看看别人写的之后，有感而发
    // 将 这个 2d 数组 看成一个 1d 数组即可
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) {
            return false;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        int start = 0;
        int end = height * width - 1;
        while (start != end) {
            int middle = (start + end) / 2;

//            int num = getNum(middle, matrix);
            int num = matrix[middle / width][middle % width];
            if (num > target) {
                end = middle;
            } else if (num < target) {
                start = middle;
            } else {
                return true;
            }
            if (end - start == 1) {
                return getNum(start, matrix) == target || getNum(end, matrix) == target;
            }
        }
        return getNum(start, matrix) == target || getNum(end, matrix) == target;
    }

    private int getNum(int num, int[][] arr) {
        int width = arr[0].length;
        int y = num / width;
        int x = num % width;
        return arr[y][x];
    }

    @Test
    public void test4() throws Exception {
        int[][] arr = {{1}};
        System.out.println(searchMatrix(arr, 1));
    }

    @Test
    public void test3() throws Exception {
        int[][] arr = {{1}, {3}};
        System.out.println(searchMatrix(arr, 2));
    }

    // 这种方式实在太过简单，没啥技术含量
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        if (width == 0) {
            return false;
        }
        for (int i = 0; i < height; i++) {
            int[] temp = matrix[i];
            if (temp[width - 1] < target) {
                continue;
            } else if (temp[0] > target) {
                return false;
            } else {

                // 优化这个选择代码，可以使用更快的
//                for (int j = 0; j < width; j++) {
//                    if (temp[j] == target) {
//                        return true;
//                    }
//                }

                // 可以用二分法
                int start = 0;
                int end = width - 1;
                if (start == end) {
                    return temp[start] == target;
                }
                while (start != end) {
                    int middle = (start + end) / 2;
                    if (temp[middle] > target) {
                        end = middle;
                    } else if (temp[middle] < target) {
                        start = middle;
                    } else {
                        return true;
                    }
                    if (end - start == 1) {
                        return temp[end] == target || temp[start] == target;
                    }
                }

                return false;
            }
        }
        return false;
    }

    @Test
    public void test2() throws Exception {
        int[][] arr = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(arr, 35));
    }

    /*
        朋友推荐的题，实在是无聊啊。
        给你一个二维数组    eg  参数  {  { 1 , 2],  {3,4} }   返回一个新的二维数组 {  {1，3} ，{1，4}，{2，3}，{2，4}  }
         */
    public static int[][] genMix(int[][] arr) {
        int[] arr1 = arr[0];
        int[] arr2 = arr[1];

        int[][] brr = new int[arr1.length * arr2.length][2];

        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                brr[index][0] = arr1[i];
                brr[index][1] = arr2[i];
                index++;
            }
        }

        return brr;
    }

    @Test
    public void test1() {
        int[][] arr = {{1, 2}, {3, 4}};
        arr = genMix(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
