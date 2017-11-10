package com.m2017.november;

import org.junit.Test;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * Created by a-mdx on 2017/11/10.
 * https://leetcode.com/problems/reverse-linked-list/description/
 * 反转 字符串。一种是 取值重建，另一种 用 栈
 */
public class Novem10 {

    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode newHead = new ListNode(head.val);

        // init
//        newHead.next = null;
        while (head.next != null){
            ListNode temp = newHead;

            // 直接重新构建，避免 对象互相影响。
            int next = head.next.val;
            newHead = new ListNode(next);
            newHead.next = temp;

            // 下一个
            head = head.next;
        }
        return newHead;
    }

    public ListNode reverseList1(ListNode head){
        // 用 栈 。。。
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        // init
        ListNode newHead = stack.pop();
        ListNode tempNode = newHead;
        while (!stack.isEmpty()){

            ListNode temp = stack.pop();
            tempNode.next = temp;
            tempNode = tempNode.next;
            tempNode.next = null;
        }
        return newHead;

    }

    // 朋友所写
    public ListNode reverseList2(ListNode head) {
        //a---b---c---d
        //null
        //b---c---d
        //a
        //c---d
        //b---a
        if (head == null) {
            return head;
        }
        ListNode b = head.next;
        ListNode a = head;
        while (b != null) {
            a.next = b.next;
            b.next = head;
            head = b;
            b = a.next;
        }
        return head;

    }

    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        head = reverseList2(head);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
