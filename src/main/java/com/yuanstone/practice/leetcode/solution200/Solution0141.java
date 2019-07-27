package com.yuanstone.practice.leetcode.solution200;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class Solution0141 {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        node1.print(0);

        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) { val = x; }

        public void print (int index) {
            if (index > 10) {
                System.out.println("stop: too many nodes");
                return;
            }
            System.out.print(val + " -> ");
            if (next != null) {
                next.print(++index);
            } else {
                System.out.println("null");
            }
        }
    }
}
