package com.m2017.june;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * Created by A-mdx on 2017/6/1.
 * https://leetcode.com/problems/fizz-buzz/#/description
 * 这道题看着很有趣
 */
public class June01 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            boolean fizz = (i % 3 == 0);
            boolean buzz = (i % 5 == 0);
            if (fizz && buzz) {
                list.add("FizzBuzz");
            } else if (fizz) {
                list.add("Fizz");
            } else if (buzz) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }

        return list;
    }

    @Test
    public void test1() {
        List<String> list = fizzBuzz(16);
        list.forEach(System.out::println);
    }
}
