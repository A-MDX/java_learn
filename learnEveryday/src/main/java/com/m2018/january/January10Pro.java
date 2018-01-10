package com.m2018.january;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 最近写公司代码写的太难受了，我现在只想随便写点，开心一下，重新燃起对编程的乐趣
 * Create by A-mdx at 2018/1/10 晚上 22:44
 */
public class January10Pro {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 7, 8, 9, 10);
        System.out.println(list);
        System.out.printf("fuck %-5d %10s\n", 15, "xxx");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.asList(arr));
    }

    @Test
    public void test2() {
        Class c = January10Pro.class;
        // 这个方法只是获取 内部类？
        Class[] cs = c.getClasses();
        for (Class aClass : cs) {
            System.out.println(aClass.getName());
        }
    }

    public static class Nb {
    }

    public static class Sb {
    }

    public class Ob {
    }
}
