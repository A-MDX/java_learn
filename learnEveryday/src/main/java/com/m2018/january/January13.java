package com.m2018.january;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 《深入理解java 虚拟机》
 * p50
 * Create by A-mdx at 2018/1/13 0013 13:22
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:+HeapDumpOnOutOfMemoryError
 */
public class January13 {
    static class OOMObject {
    }

    public static void main(String... args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    @Test
    public void test1() {
        // 原来有个参数，叫做 accessOrder
        // 这个叫做 最近最少使用原则 p487
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            map.put(i, i + "" + i);
        }
        System.out.println(map);

        // linkedHashMap 可以做为一个资源查看器，访问最少的放到最前面
        for (int i = 0; i < 6; i++) {
            map.get(i);
        }
        System.out.println(map);


    }
}
