package com.m2018.july;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * Create by dxma at 2018-07-13 15:26
 * https://leetcode-cn.com/problems/reorganize-string/description/
 * 这道题有些意思
 */
public class July13 {
    public String reorganizeString(String S) {
        Map<Character, Temp> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> {
                v.size++;
                return v;
            });

            map.putIfAbsent(c, new Temp(c));
        }
        List<Temp> list = map.values().stream().sorted().collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        char last = '0';
        while (!list.isEmpty()) {

            char next = checkAndBuild(list, last);
            if (next == 0) {
                return "";
            }
            last = next;
            builder.append(next);

            list.removeIf(s -> s.size == 0);
            Collections.sort(list);
        }
        return builder.toString();
    }

    private char checkAndBuild(List<Temp> list, char last) {
        for (int i = 0; i < list.size(); i++) {
            if (last == list.get(i).c) {
                continue;
            }
            Temp temp = list.get(i);
            temp.size--;
            return temp.c;
        }
        return 0;
    }

    class Temp implements Comparable<Temp> {
        char c;
        int size;

        Temp(char c1) {
            c = c1;
            size = 1;
        }

        @Override
        public int compareTo(Temp o) {
            return o.size - size;
        }
    }

    @Test
    public void test1() {
        String str = "aaab";
        System.out.println(reorganizeString(str));

    }

}
