package com.m2017.december;

import org.junit.Test;

import java.util.*;

/**
 * 学习一些方法工具类
 * Create by A-mdx at 2017/12/19 23:48
 */
public class December19Pro {
    @Test
    public void test1(){
        List<String> list1 = Arrays.asList("xxx", "111");
        List<String> list2 = new ArrayList<>();
        List<String> list3 = Collections.emptyList();
        Collections.addAll(list2, "xxx", "123123");
        // 使用上面的 addAll，其所得到的数组，额，可以新增
        list3.add("Str");//error .unsupportedOperation
        System.out.println(list3); 
    }

    @Test
    public void test2() {
        // 这个竟然可以排序
        //  new LinkedHashSet<>();
        // new HashSet<>();
        Set<String> set = new LinkedHashSet<>();
        set.add("abc");
        set.add("qwe");
        set.add("zxc");
        System.out.println(set);
        
        // treeSet 可以传递一个比较器，用来比较
    }
}
