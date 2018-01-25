package com.m2018.january;

import org.junit.Test;

import java.util.BitSet;

/**
 * 今天了解了个 bitSet, 我好像记得有个叫 bitmap 的，那个更加厉害了。
 * Create by A-mdx at 2018-01-18 23:51
 */
public class January18 {
    
    public static final String msg = "呵呵呵达。。。";
    
    // 这个玩意孩子真是神奇，说不定会有不一般的作用
    public static void main(String... args) {
        System.out.println(msg);
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
    
    // -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc*
    @Test
    public void test1(){
        ReferenceGc o1 = new ReferenceGc();
        ReferenceGc o2 = new ReferenceGc();
        o1.instance = o2;
        o2.instance = o1;
        
        o1 = null;
        o2 = null;
        
        System.gc();
    }
    
    class ReferenceGc {
        public Object instance;
        public static final int _1MB = 1024*1024;
        private byte[] bigSize = new byte[2* _1MB];
    }

}
