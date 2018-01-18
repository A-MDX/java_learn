package com.m2018;

import java.util.BitSet;

/**
 * 今天了解了个 bitSet, 我好像记得有个叫 bitmap 的，那个更加厉害了。
 * Create by A-mdx at 2018-01-18 23:51
 */
public class January18 {
    // 这个玩意孩子真是神奇，说不定会有不一般的作用
    public static void main(String... args) {
        BitSet bs = new BitSet();
        bs.set(15);
        bs.set(20);
        System.out.println(bs.get(15));
        System.out.println(bs.get(20));
        System.out.println(bs.get(21));
        bs.set(1);
        System.out.println("------------------------------");
        System.out.print("[");
        for (int i = 0; i < bs.size(); i++) {
            System.out.print((bs.get(i) ? '1' : '0') + ",");
        }
        System.out.print("]");

    }

}
