package com.yuanstone.practice.leetcode.solution100;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution0024 {

    public static void main (String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.print();

        ListNode swap = swapPairs2(node1);
        swap.print();
    }

    public static ListNode swapPairs (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode holder = new ListNode(0);
        holder.next = head;

        ListNode left = head, right = head.next;
        ListNode pre = holder;
        while (right != null) {
            pre.next = right;
            left.next = right.next;
            right.next = left;
            pre = left;
            if (left.next == null) {
                break;
            }
            left = left.next;
            right = left.next;
        }
        return holder.next;
    }

    public static ListNode swapPairs2 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        head.next = swapPairs2(head.next);
        return newHead;
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
