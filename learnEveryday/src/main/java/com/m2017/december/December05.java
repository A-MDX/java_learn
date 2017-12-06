package com.m2017.december;

import java.util.*;

/**
 * 1.内  部 * 原来如果无法被子类访问到的方法，是无法被重写的。
 * 2.才发现代理模式是可以自动生成的，真方便到爆炸 使用 alt+insert
 * 3.试试看，变量随机生成
 * Create by A-mdx at 2017/12/5 23:45
 */
public class December05 implements Map {
    
    private static int genRand(){
        Random random = new Random();
        return random.nextInt(100);
    }
    
    public static final int WHAT_ABOUT_THIS = genRand();

    public static void main(String... args) {
        System.out.println("WHAT_ABOUT_THIS:"+WHAT_ABOUT_THIS);
    }
    

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public void putAll(Map m) {
        map.putAll(m);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return map.entrySet();
    }

    private HashMap map = new HashMap();


}
