package com.yuanstone.practice.leetcode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution0025 {

    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.print();

        ListNode reverse = reverseKGroup2(node1, 2);
        reverse.print();

        reverse = reverseKGroup2(reverse, 3);
        reverse.print();
    }

    public static ListNode reverseKGroup (ListNode head, int k) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode pre = sentry, tail = sentry;

        while (true) {
            int i;
            for (i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    break;
                }
            }
            if (i < k) {
                break;
            }
            ListNode kHead = pre.next;
            while (pre.next != tail) {
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            pre = kHead;
            tail = kHead;
        }
        return sentry.next;
    }

    // 递归
    public static ListNode reverseKGroup2 (ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup2(cur, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) { val = x; }

        public void print () {
            System.out.print(val + " -> ");
            if (next != null) {
                next.print();
            } else {
                System.out.println("null");
            }
        }
    }
}