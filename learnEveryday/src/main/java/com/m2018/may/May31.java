package com.m2018.may;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * Create by A-mdx at 2018-05-31 22:01
 * https://leetcode.com/problems/queue-reconstruction-by-height/discuss/
 * 这道题真难啊
 */
public class May31 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        System.out.println(Arrays.deepToString(people));
        List<int[]> arr = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            arr.add(people[i][1], people[i]);
        }
        return arr.toArray(people);
    }


    @Test
    public void test1() {
        int[][] arr = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
//        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
//        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(reconstructQueue(arr)));
    }

}
