package com.m2017.may;

/**
 * Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * Created by A-mdx on 2017/5/27.
 * 也就是说，从中间删除一个了。关键是，没有给上一个节点。
 */
public class May27 {

    private ListNode root;
    
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
