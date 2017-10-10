package com.m2017.october;

import java.util.concurrent.*;

/**
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * Created by a-mdx on 2017/10/10.
 * https://leetcode.com/problems/regular-expression-matching/description/
 * 写一个匹配器，hard 级别的难度。。
 */
public class Octo10 {
    public boolean isMatch(String s, String p) {
        char[] pp = p.toCharArray();
        int index = 0;
        int temp;
        // 似乎需要用到 dp 思想，动态规划思想，这对我有点难。他们服务器还挂了，等等再说。
        return false;
    }

    public static void main(String... args) throws ExecutionException, InterruptedException, TimeoutException {
        // 练习 多线程 问题。
        //子线程完成某件任务后，把得到的结果回传给主线程
        Callable<Integer> callable = () -> {
            System.out.println("Task starts...");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i < 101; i++) {
                result += i;
            }
            System.out.println("Task finished and return result...");
            return result;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();


        System.out.println("Before futureTask.get()");
        System.out.println("Result: "+futureTask.get());
        futureTask.get(1, TimeUnit.DAYS);
        System.out.println("After futureTask.get()");


    }

}
