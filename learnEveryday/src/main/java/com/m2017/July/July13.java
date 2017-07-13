package com.m2017.July;

import org.junit.Test;

/**
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Created by a-mdx on 2017/7/13.
 * https://leetcode.com/problems/merge-two-sorted-lists/#/description
 * 刷道简单的题，给自己来点自信
 * 这道题没想到挺麻烦的。我还是吧别人的也写下来。
 */
public class July13 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        if (l1 == null && l2 == null){
            return node;
        }
        if (l1 == null || l2 == null){
            if (l1 == null){
                node = new ListNode(l2.val);
                l2 = l2.next;
            }else {
                node = new ListNode(l1.val);
                l1 = l1.next;
            }

        }else if (l1.val > l2.val){
            node = new ListNode(l2.val);
            l2 = l2.next;
        }else {
            node = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode temp = node;
        while (true){

            if (l1 == null && l2 == null){
                break;

            }else if (l1 == null || l2 == null){
                if (l1 == null){
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else {
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                }

            }else if (l1.val > l2.val){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        return node;
    }

    // 他人想法
    public ListNode mergelist2(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode node;
        if (l1.val > l2.val){
            node = new ListNode(l2.val);
            node.next = mergelist2(l1, l2.next);
        }else {
            node = new ListNode(l1.val);
            node.next = mergelist2(l1.next, l2);
        }
        return node;
    }

    @Test
    public void test1(){
        ListNode l1 = null;
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode node = mergeTwoLists(l1, l2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
