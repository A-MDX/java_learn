package com.m2017.december;

import org.junit.Test;

import java.util.*;

/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * Created by a-mdx on 2017/12/20.
 * https://leetcode.com/problems/n-queens/description/
 * 多个皇后问题，就跟 象棋里面多个老将一样，不能见面，见面就挂了
 * 额，经过计算，原来还不能使对角线相遇，整整一个米子，都不能碰到。
 */
public class December20 {


    // 好不容易做出来了，结果还整超时了，
    // 额，第二次提交就好了，估计是需要编译
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();

        // 初始化
        char[][] arr = new char[n][n];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }

        genQueens2(results, new ArrayList<>(), arr, 0);

        return results;
    }

    // index 参数就像是 y轴一样
    private void genQueens2(List<List<String>> results, ArrayList<String> tempList, char[][] arr, int index) {
        if (arr.length == index) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (checkIn(arr, i, index)) {
                arr[index][i] = 'Q';
                tempList.add(new String(arr[index]));

                genQueens2(results, tempList, arr, index + 1);

                tempList.remove(tempList.size() - 1);
                arr[index][i] = '.';
            }
        }
    }

    // 检查 在一个 2d 数组中，是否可以将 x,y 放到 arr 中
    private boolean checkIn(char[][] arr, int x, int y) {
        // 检查 横竖，仔细想构造顺序，其实下面的都不用检查，以及横线的也不用建查
        // 就好比一个米子，只需要检查米字的上半部分，那三个线有没有交叉点就好，下面完全忽略
        for (int i = 0; i < y; i++) {
            if (arr[i][x] == 'Q') {
                return false;
            }
        }
        /*
            {(x-1,y-1) | (x+1,y-1)}
         */
        // 检查 两个斜，上半的斜线
        int index = 1;
        while (true) {
            // 检查左上斜
            if (x - index < 0 || y - index < 0) {
                break;
            }

            int x1 = x - index;
            int y1 = y - index;
            if (arr[y1][x1] == 'Q') {
                return false;
            }
            index++;

        }
        index = 1;
        while (true) {
            // 右上斜
            if (x + index >= arr.length || y - index < 0) {
                break;
            }
            int x1 = x + index;
            int y1 = y - index;
            if (arr[y1][x1] == 'Q') {
                return false;
            }
            index++;

        }
        return true;
    }

    // 这样做是无法保证 对角能 不相交。
    // 该方法失败，，，了
    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> results = new ArrayList<>();

        Set<Integer> ySet = new HashSet<>();  //    去重复

        List<String> tempList = new ArrayList<>();

        genStr(results, tempList, n, ySet);

        return results;
    }

    private void genStr(List<List<String>> results, List<String> tempList, int n, Set<Integer> ySet) {
        if (tempList.size() == n) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ySet.add(i)) {
                tempList.add(genCharStr(n, i));
                genStr(results, tempList, n, ySet);
                ySet.remove(i); // 将刚刚添加的 remove 掉 ，为了下一组循环
                tempList.remove(tempList.size() - 1); // 将刚刚添加的 remove 掉
            }
        }
    }

    private String genCharStr(int size, int index) {
        char[] arr = new char[size];
        Arrays.fill(arr, '.');
        arr[index] = 'Q';
        return new String(arr);
    }

    @Test
    public void test1() {
        List<List<String>> lists = solveNQueens(9);
        lists.forEach(s -> {
            System.out.println("[");
            s.forEach(System.out::println);
            System.out.println("]");
        });
    }

}
