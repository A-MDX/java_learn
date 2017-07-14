package com.m2017.July;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 * Created by a-mdx on 2017/7/14.
 * https://leetcode.com/problems/spiral-matrix/#/description
 * 因为那个太简单了，所以在做一道。
 */
public class July14Pro {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0){
            return list;
        }
//        else if (matrix.length == 1){
//            for (int i = 0; i < matrix[0].length; i++) {
//                list.add(matrix[0][i]);
//            }
//            return list;
//        }

        tranSpiral(matrix, list, 0, matrix[0].length - 1, 0, matrix.length - 1);


        return list;
    }

    /**
     * 先 左 至 右 ，像是一个旋转的时钟
     */
    private void tranSpiral(int[][] matrix, List<Integer> list, int left, int right, int height, int low){
        int size = matrix.length * matrix[0].length;
        if (list.size() >= size){
            return;
        }
        // left -> right
        for (int i = left; i <= right; i++) {
            list.add(matrix[height][i]);
        }
        height++;
        if (list.size() >= size){
            return;
        }

        // height -> low
        for (int i = height; i <= low; i++) {
            list.add(matrix[i][right]);
        }
        right--;
        if (list.size() >= size){
            return;
        }

        // right -> left
        for (int i = right; i >= left; i--) {
            list.add(matrix[low][i]);
        }
        low--;
        if (list.size() >= size){
            return;
        }

        // low -> height
        for (int i = low; i >= height; i--) {
            list.add(matrix[i][left]);
        }
        left++;

        tranSpiral(matrix, list, left, right, height, low);
    }

    @Test
    public void test1(){
        int[][] arr = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
                {7},{9},{6}
        };
        List<Integer> list = spiralOrder(arr);
        System.out.println(list);
    }

}
