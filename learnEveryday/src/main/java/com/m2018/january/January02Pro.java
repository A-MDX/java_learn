package com.m2018.january;

import org.junit.Test;

import java.util.Iterator;

/**
 * p357
 * 试着自己做一个 栈
 * Create by A-mdx at 2018/1/2 23:03
 */
public class January02Pro {
    public static void main(String... args) {
        LinkedStacks<String> stacks = new LinkedStacks<>();
        stacks.push("apple");
        stacks.push("banana");
        stacks.push("orange");

        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }

    @Test
    public void test1() {
        // 使用适配器的方式，将这个玩意可以完美的实现 迭代器接口
        IterStack<String> stacks = new IterStack<>();
        stacks.push("apple");
        stacks.push("banana");
        stacks.push("orange");

        // 该迭代器接口还不会影响原来属性 
        for (String s : stacks) {
            System.out.println("s: " + s);
        }
        System.out.println("-------------------------------------------");
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}

// 将下面的栈 用适配器模式来实现 iterable
class IterStack<T> extends LinkedStacks<T> implements Iterable<T> {
    int count;

    public void push(T t) {
        count++;
        super.push(t);
    }

    public T pop() {
        T t = super.pop();
        if (t != null) {
            count--;
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int countItem = count;
            Node<T> top = getTop();

            @Override
            public boolean hasNext() {
                return countItem > 0;
            }

            @Override
            public T next() {
                T t = top.item;
                if (countItem > 0) {
                    countItem--;
                    top = top.next;
                }
                return t;
            }
        };
    }
}

// 这个 ，自从学了数据结构就一直这么简单了
// 一个 push方法，一个 pop 方法足够了
class LinkedStacks<T> {
    protected static class Node<U> {
        U item;
        Node<U> next;

        Node() {

        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T item = top.item;
        if (top.next != null) {
            top = top.next;
        }
        return item;
    }

    protected Node<T> getTop() {
        return top;
    }
}