package com.m2017.december;

import org.junit.Test;

/**
 * .类还能写在 方法体内
 * 2.
 * Create by A-mdx at 2017/12/14 22:46
 */
public class December14 {
    interface Foot{
        String get();
    }
    
    String get(){
        return "outer get()";
    }
              
    public String getFootStr(boolean defaultAble){
        if (defaultAble){
            class FootImpl implements Foot{
    
                @Override
                public String get() {
                    return "This is a big foot.";
                }
            }
            return new FootImpl().get();
        }
//        return new FootImpl().get(); // 方法体内的类，很奇葩
        return ((Foot) () -> "Ok, that's nice.").get();
    }
    
    public String forMax(Max max){
        return max.get();
    }

    @Test
    public void test1(){
        System.out.println("xxxxxxxxxx");
        System.out.println(getFootStr(true));
        System.out.println(get());
        System.out.println(new Max() {
            @Override
            public String get() {
                return December14.this.get(); //?
            }
        });

        System.out.println(forMax(() -> get()));
    }
    
    interface Max{
        String get();
    }
}
