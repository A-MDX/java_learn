package com.m2018.april;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * Create by A-mdx at 2018-04-18 21:17
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 * 这个，应该是回溯法
 */
public class April18Pro {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        char[] source = S.toCharArray();
        char[] arr = new char[S.length()];
        genStr(arr, source, 0, list);
        return list;
    }

    private void genStr(char[] arr, char[] source, int index, List<String> result) {
        if (index == source.length) {
            result.add(new String(arr));
            return;
        }
        char c = source[index];
        if (Character.isLetter(c)) {
            if (Character.isLowerCase(c)){
                arr[index] = Character.toUpperCase(c);
            }else {
                arr[index] = Character.toLowerCase(c);
            }
            genStr(arr, source, index + 1, result);
        }
        arr[index] = c;
        genStr(arr, source, index + 1, result);
    }

    @Test
    public void test1() {

        System.out.println(letterCasePermutation("c"));
    }

}
