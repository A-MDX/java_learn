package com.m2017.november;

import org.junit.Test;

import java.util.Arrays;

/**
 * 朋友发过来的题
 * josephus环问题：古代某法官要判断N个犯人的死刑，他有一条荒唐的法律，将犯人站成一个圈，从第start个人开始i，没数到
 * distance个犯人，就拉出来弄死，然后再从下一个开始数distance个，数到的人在弄死，直到剩下的最后一个犯人予以赦免。
 * Created by a-mdx on 2017/11/14.
 */
public class Novem14 {
    public String josephus(int[] number, int start, int distance) {
        // 初始化，
        boolean[] arr = new boolean[number.length];
        Arrays.fill(arr, true);
        int nowIndex = start - 1;
        int length = number.length;
        int nearByDistance = distance; // 距离死刑距离

        int lastOne = -1;
        while (true) {
            if (arr[nowIndex]) {
                if (nearByDistance == 0) {
                    // 处死
                    arr[nowIndex] = false;
                    nearByDistance = distance;

                } else {
                    // 下一个
                    nearByDistance--;
                }

            }
            //
            if (nowIndex + 1 == length) {
                int restLive = 0;

                for (int i = 0; i < length; i++) {
                    if (arr[i]) {
                        restLive++;
                    }
                }
                if (restLive == 1) {
                    // 存活的 i
                    int index = 0;
                    while (!arr[index]) {
                        index++;
                    }
                    lastOne = index;
                    break;
                }
                nowIndex = 0;
            } else {
                nowIndex++;
            }
        }
        return lastOne + "";
    }

    @Test
    public void test1() {
        int[] numbers = new int[5];
        System.out.println(josephus(numbers, 1, 3));

    }

}
