package com.m2017.august;

import org.junit.Test;

/**
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Created by a-mdx on 2017/8/22.
 * https://leetcode.com/problems/valid-sudoku/description/
 * 验证数独 问题
 *
 */
public class Aug22 {

    public static final int size = 9;

    public boolean isValidSudoku(char[][] board) {
        // 1. 验证 横
        for (int i = 0; i < size; i++) {
            char[] arr = board[i];
            if (!valid9ok(arr)){
                return false;
            }
        }
        // 2. 验证 竖
        for (int i = 0; i < size; i++) {
            char[] arr = new char[size];
            for (int j = 0; j < size; j++) {
                arr[j] = board[j][i];
            }
            if (!valid9ok(arr)){
                return false;
            }
        }
        
        // 3. 验证九宫格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = 0;
                char[] arr = new char[size];
                int x = i * 3;
                int y = j * 3;
                for (int k = x; k < x +3; k++) {
                    for (int l = y; l < y + 3; l++) {
                        arr[index++] = board[k][l];
                    }
                }
                if (!valid9ok(arr)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean valid9ok(char[] arr){
        boolean[] brr = new boolean[9];
        for (int i = 0; i < size; i++) {
            if (arr[i] != '.'){
                int num = arr[i] - '0' - 1;
                if (brr[num]){
                    // 可能重复了
                    return false;
                }else {
                    brr[num] = true;
                }
            }
        }
        return true;
    }

    @Test
    public void test1(){
        System.out.println((int)'0');
        System.out.println((int)'1');
        System.out.println((int)'9');
    }
}
