package com.m2017.june;

import org.junit.Test;

/**
 * Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * Created by A-mdx on 2017/6/20.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 * 天，惭愧，这么久没做了
 */
public class June20 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode next = head.next;
        while (next != null) {
            size++;
            next = next.next;
        }
        int index = size - n;
        int i = 1;
        ListNode temp = head;
        if (index == 0) {
            head = head.next;
            return head;
        }
        while (i < index + 1) {
            if (i == index) {
                ListNode is = temp.next;

                temp.next = is.next;

                return head;
            }
            i++;
            temp = temp.next;
        }
        return null;

    }


    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode del = removeNthFromEnd(head, 2);
        System.out.println(del);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
