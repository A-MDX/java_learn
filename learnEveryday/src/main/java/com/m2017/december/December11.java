package com.m2017.december;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * For example,
 * <p>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * Created by a-mdx on 2017/12/11.
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 寻找出现过多次的10个长度的 重复字段
 */
public class December11 {

    // 网上的操作
    // 这个想法 厉害了
    // 用 空间换 时间？
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeat = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (!seen.add(str)) {
                // 加不成功，就加，哎
                repeat.add(str);
            }
        }
        return new ArrayList<>(repeat);
    }

    // 又超时 了
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new ArrayList<>();
        // 使用 char ？
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (result.contains(str)) {
                // 去除重复
                continue;
            }
            int sIndex = i + 1;
            b2:
            while (sIndex < s.length() - 9) {
                if (arr[i] == arr[sIndex]) {
                    // 比较其他9个
                    int temp = i;
                    boolean flagOk = true; // 比较9个是否成功
                    for (int j = 1; j < 10; j++) {
                        if (arr[temp + j] != arr[sIndex + j]) {
                            flagOk = false;
                            break;
                        }
                    }
                    if (flagOk) {
                        result.add(str);
                        break b2;
                    }

                }
                sIndex++;
            }

        }
        return result;
    }

    // 这个 时间 超时了  Submission Result: Time Limit Exceeded
    // it's so easy
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String nowCheck = s.substring(i, i + 10);
//            String lastStr = s.substring(i + 1);
            if (result.contains(nowCheck)) {
                // 去除重复
                continue;
            }
            if (s.indexOf(nowCheck, i + 1) != -1) {
                result.add(nowCheck);
            }


        }

        return result;
    }

    @Test
    public void test1() {
        String s = "AAAAAAAAAAAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences1(s));
    }
}
