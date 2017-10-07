package com.m2017.october;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Octo07 {
    public static void what(String name, Integer age) {

        // just learn assert 关键字
        assert name != null;
        assert age != null;
        System.out.println("name: " + name + " , age: " + age);
    }


    public static void main(String... args) {

        // 练习 ，好久没有学习， 准备写两道题看看
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
//            list.remove(i);
            list.remove(Integer.valueOf(i));
        }
        System.out.println("set: " + set);
        System.out.println("list: " + list);
    }

}
