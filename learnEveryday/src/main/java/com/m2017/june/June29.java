package com.m2017.june;

import java.util.Stack;

/**
 * Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 * Created by A-mdx on 2017/6/29.
 * https://leetcode.com/problems/min-stack/#/description
 * 最小栈 问题，这个正好前些天看算法看到过。
 */
public class June29 {


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    public static class MinStack {

        private Stack<Integer> elements;
        private Stack<Integer> mins;
        
        /** initialize your data structure here. */
        public MinStack() {
            elements = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int x) {
            elements.push(x);
            if (mins.size() == 0){
                mins.push(x);
            }else {
                int nowMin = mins.peek();
                if (nowMin >= x){
                    mins.push(x);
                }
            }
            
        }

        public void pop() {
            int num = elements.pop();
            if (mins.peek() == num){
                mins.pop();
            }
        }

        public int top() {
            return elements.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }
    
}
