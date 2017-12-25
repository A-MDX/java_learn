package com.m2017.december;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 漫画：动态规划
 * 今天深入学了下 动态规划，想试试看能否写出难一点的 dp
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * 工人 ：10 ；
 * 1. 400金/5人
 * 2. 500金/5人
 * 3. 300金/4人
 * 4. 200金/3人
 * 5. 350金/3人
 * Created by a-mdx on 2017/12/25.
 */
public class December25Plus {


    @Test
    public void test1() {
        List<Gold> goldList = Arrays.asList(
                new Gold(400, 5)
                , new Gold(500, 5)
                , new Gold(300, 4)
                , new Gold(200, 3)
                , new Gold(350, 3));
        int works = 10;
//        int maxGold = findMaxByLine(goldList, works);
//        System.out.println(maxGold);

        int maxGold = findMaxByDP(goldList, works);
        System.out.println(maxGold);
    }

    // 2. 使用 dp ，其时间复杂度是 O(n*m)
    private int findMaxByDP(List<Gold> goldList, int works) {
        // 定义 最优子结构：f(goldList[5], works) = max(f(goldList[4], works), f(goldList[4], works - gold[5].worker))
        // 写的很乱，简单来讲，就是决定挖，还是不挖，选择其中的最大值
        // 边界：f(1) = gold[1].gold 或者由于工人不够，f(1) = 0

        // 决定以 2d 数组的形式写出来，便于理解
        int[][] arr = new int[goldList.size()][works];

        // 初始化边界，即 第一行
        Gold g0 = goldList.get(0);
        for (int i = 0; i < works; i++) {
            if (i + 1 < g0.worker) {
                // 工人不够
                arr[0][i] = 0;
            } else {
                arr[0][i] = g0.golds;
            }
        }

        // 开始进行 dp
        for (int i = 1; i < goldList.size(); i++) {
            Gold tempGold = goldList.get(i);
            for (int j = 0; j < works; j++) {
                if (j + 1 >= tempGold.worker) {
                    // 如果 工人数量够了，则 进行此操作，
                    // 一个是 不挖当前矿，一个是 挖当前矿
                    if (j + 1 - tempGold.worker == 0) {
                        // 若没工人了，不用算了
                        arr[i][j] = Math.max(arr[i - 1][j], tempGold.golds);
                    } else {
                        // 若 挖了当前矿，则工人数量就要剪掉了当前所用，并加上 当前能挖数量
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - tempGold.worker] + tempGold.golds);
                    }
                }
            }
        }

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        return arr[goldList.size() - 1][works - 1];
    }

    // 1. 排列组合，直接暴力.
    // 这种 做法 的 时间复杂度是：O(2^n)，有多少n 就有多少循环，很慢很夸张
    private int findMaxByLine(List<Gold> goldList, int works) {
        // 直接使用回溯法
        List<List<Gold>> allCombination = new ArrayList<>();
        addAllCombination(goldList, new ArrayList<Gold>(), allCombination);

        int maxResult = 0;
        for (List<Gold> list : allCombination) {
            int max = 0;
            int lastWorks = works;
            for (Gold g : list) {
                if (lastWorks - g.worker >= 0) {
                    max += g.golds;
                    lastWorks -= g.worker;
                } else {
                    break;
                }
            }
            maxResult = Math.max(maxResult, max);
        }

        return maxResult;
    }

    private void addAllCombination(List<Gold> goldList, ArrayList<Gold> tempGolds, List<List<Gold>> allCombination) {
        if (tempGolds.size() == goldList.size()) {
            allCombination.add(new ArrayList<>(tempGolds));
            return;
        }
        for (int i = 0; i < goldList.size(); i++) {
            Gold gold = goldList.get(i);
            if (tempGolds.contains(gold)) {
                continue;
            }
            tempGolds.add(gold);
            addAllCombination(goldList, tempGolds, allCombination);
            tempGolds.remove(gold);
        }
    }


    class Gold {
        int golds;
        int worker;

        Gold(int golds, int worker) {
            this.golds = golds;
            this.worker = worker;
        }
    }
}
