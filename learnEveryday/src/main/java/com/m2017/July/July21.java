package com.m2017.July;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * Created by a-mdx on 2017/7/21.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 */
public class July21 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode root = head;

        while (head.next != null) {
            ListNode next = head.next;
            if (head.val == next.val) {
                // 删除 next
                if (next.next != null) {
                    next = next.next;
                    head.next = next;
                    continue;
                } else {
                    head.next = null;
                    return root;
                }
            }
            head = next;
        }
        return root;
    }

    @Test
    public void test1() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        ListNode next = root.next;
        root.next = next;

        next.next = new ListNode(2);
        next = next.next;
        next.next = new ListNode(3);

        root = deleteDuplicates(root);

        while (true) {
            System.out.println(root.val);
            if (root.next != null) {
                root = root.next;
            } else {
                break;
            }
        }

    }

    @Test
    public void test2() throws Exception {

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
