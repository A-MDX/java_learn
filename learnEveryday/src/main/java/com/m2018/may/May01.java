package com.m2018.may;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * Create by A-mdx at 2018-05-01 21:33
 */
public class May01 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int aLength = 0, bLength = 0;
        while (a != null) {
            a = a.next;
            aLength++;
        }
        while (b != null) {
            b = b.next;
            bLength++;
        }
        a = headA;
        b = headB;
        if (aLength > bLength) {
            int diff = aLength - bLength;
            while (diff > 0) {
                a = a.next;
                diff--;
            }
        } else {
            int diff = bLength - aLength;
            while (diff > 0) {
                b = b.next;
                diff--;
            }
        }

        while (a != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}