package com.m2017.december;

import org.junit.Test;

import java.util.*;

/**
 * 今天晚上，想学习一下优先队列
 * PriorityQueue 优先队列
 * Create by A-mdx at 2017/12/20 23:23
 */
public class December20Pro {
    @Test
    public void test1(){
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int next = random.nextInt(100);
            System.out.println("next: "+next);
            queue.add(next);
        }
        System.out.println("-------------------------------------------");
        while (true){
            System.out.println(queue.remove());
        }
    }

    @Test
    public void test2() {
        System.getenv().forEach((k, v) -> System.out.println(k+" -> "+v));
    }

    @Test
    public void test3() {
        // 测试，底层数组会被改变..
        Integer[] arr = { 1,2,3,4,5,6,7,8,9};
        List<Integer> list = Arrays.asList(arr);
        System.out.println("before list:"+list);
        System.out.println("before arr:"+Arrays.toString(arr));
        System.out.println("---------------------------------------");
        Collections.shuffle(list);
        System.out.println("after list:"+list);
        System.out.println("after arr:"+Arrays.toString(arr));
        // 这个是依赖底层 的数组实现的，
    }
}
