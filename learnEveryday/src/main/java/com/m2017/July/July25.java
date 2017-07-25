package com.m2017.July;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * <p>
 * Created by a-mdx on 2017/7/25.
 * https://leetcode.com/problems/merge-intervals/#/description
 * 感觉像是需要融合边界，给定几个边界，然后融合成新边界，似乎，有点难度呀。
 * but, 还是很 easy 的做出来了。
 */
public class July25 {

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> list = new ArrayList<>();
        if (intervals.size() == 0) {
            return list;
        }

        // 需要一个排序模块
        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval each = intervals.get(i);
            if (each.start >= temp.start && each.start <= temp.end) {
                // 在 temp 的区间里
                if (each.end > temp.end) {
                    temp.end = each.end;
                }
            } else {
                // 不在这个区间内
                list.add(temp);
                temp = each;
            }
        }
        list.add(temp);

        return list;
    }

    @Test
    public void test1() {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 3)
                , new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)));
        List<Interval> list = merge(intervals);
        list.forEach(System.out::println);

    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + " , " + end + "]";
        }
    }
}
