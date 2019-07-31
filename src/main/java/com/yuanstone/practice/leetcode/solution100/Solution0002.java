package com.yuanstone.practice.leetcode.solution100;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution0002 {

    public static void main (String[] args) {
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n2.next = n4;
        n4.next = n3;
        ListNode m5 = new ListNode(5);
        ListNode m6 = new ListNode(6);
        ListNode m4 = new ListNode(4);
        m5.next = m6;
        m6.next = m4;

        ListNode result = addTwoNumbers2(n2, m5);
        result.print();
    }

    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;
        int jin = 0;
        while (left != null && right != null) {
            int sum = left.val + right.val + jin;

            jin = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            left = left.next;
            right = right.next;
        }
        left = (left == null ? right : left);
        while (left != null) {
            int sum = left.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            left = left.next;
        }
        if (jin != 0) {
            cur.next = new ListNode(jin);
        }
        return sentry.next;
    }

    public static ListNode addTwoNumbers2 (ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;
        int jin = 0;
        while (l1 != null || l2 != null) {
            int sum = jin;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                sum -= 10;
                jin = 1;
            } else {
                jin = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (jin != 0) {
            cur.next = new ListNode(jin);
        }
        return sentry.next;
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
