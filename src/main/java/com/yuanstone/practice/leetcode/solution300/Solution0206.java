package com.yuanstone.practice.leetcode.solution300;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution0206 {

    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.print();

        ListNode reverse = reverseList(node1);
        reverse.print();
    }

    public static ListNode reverseList (ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
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

    // 递归写法
    public ListNode reverseList1 (ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode temp = cur.next;
        ListNode newHead = reverseList1(cur.next);
        temp.next = cur;
        cur.next = null;
        return newHead;
    }
}