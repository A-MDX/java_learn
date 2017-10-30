package com.m2017.october;

/**
 * 225. Implement Stack using Queues
 * 实现一个
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * Created by a-mdx on 2017/10/27.
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * 用队列实现一个栈
 */
public class Octo27 {
    public static void main(String... args) {
        MyStack stack = new MyStack();
        stack.push(7);
        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}

class MyStack {

    private int[] arr;
    private int index;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        arr = new int[10];
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (index + 3 > arr.length) {
            int[] brr = new int[arr.length + 10];
            System.arraycopy(arr, 0, brr, 0, arr.length);
            arr = brr;
        }
        arr[index++] = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        index--;
        return arr[index];
    }

    /**
     * Get the top element.
     */
    public int top() {
        index--;
        return arr[index++];
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return index == 0;
    }
}
