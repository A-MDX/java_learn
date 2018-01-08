package com.m2018.january;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 学学 有关奇葩的泛型
 * Create by A-mdx at 2018/1/7 17:50
 */
public class January07Pro {
    @Test
    public void test1() {
        List<? extends CharSequence> list = new ArrayList<>();
//        list.add("xxx0");  失败了

//        list.add(new Object());

    }

    private <T> void fillList(List<T> list, T item) {
        // 主要是看看，list 只能添加其同类型的数据
        list.add(item);
    }

    private <T> void fillList2(List<? super T> list, T item) {
        // 哎，通配符也能 放入继承的通配符了，看来 这本书老了
        list.add(item);
    }

    @Test
    public void test2() {
        // 
        List<CharSequence> list = new ArrayList<>();
        fillList(list, "xxx");

        List<A> list1 = new ArrayList<>();
        fillList(list1, new B());
        fillList2(list1, new B());
    }
}

class A {
}

class B extends A {
}