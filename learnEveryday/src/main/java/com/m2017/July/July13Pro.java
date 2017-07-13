package com.m2017.July;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 * Created by a-mdx on 2017/7/13.
 * https://leetcode.com/problems/rotate-image/#/description
 * 刷题，旋转图片。
 */
public class July13Pro {
    public void rotate(int[][] matrix) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int x0 = xLength/2;
        int y0 = yLength/2;
        for (int x = 0; x < x0; x++) {
            for (int y = 0; y < y0; y++) {
                // 左下
                int heigLef = matrix[x][y];
                // 右上
                int heigRig = matrix[y][2 * x0 - x];
                // 左上
                int lowRig = matrix[2 * x0 - x][x * y0 -x];
                // 右下
                int lowLef = matrix[2 * x0 - y][x];

                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][2 * x0 - x];
                matrix[y][2 * x0 - x] = matrix[2 * x0 - x][x * y0 -x];
                matrix[2 * x0 - x][x * y0 -x] = matrix[2 * x0 - y][x];
                matrix[2 * x0 - y][x] = temp;
            }
        }

    }
    
    public void rotate1(int[][] matrix){
        // 先对称交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
            }
        }
        // 再左右交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -1- j];
                matrix[i][matrix.length -1 -j] = temp;

            }

        }
    }
    
    // 看这似乎更厉害
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int start = layer;
            int end = n-1-layer;

            for (int i = start; i < end; i++) {
                int offset = i - start;
                int top = matrix[start][i];

                matrix[start][i] = matrix[end - offset][start];
                matrix[end - offset][start] = matrix[end][end - offset];
                matrix[end][end - offset] = matrix[i][end];
                matrix[i][end] = top;
            }

        }
    }

    @Test
    public void test1(){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }
        System.out.println(" ---------------------- ");
        rotate2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }

    }

}
