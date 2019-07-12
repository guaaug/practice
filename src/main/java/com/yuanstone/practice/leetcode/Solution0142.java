package com.yuanstone.practice.leetcode;

import java.util.HashSet;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * <p>
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Solution0142 {
    public static void main (String[] args) {
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        node1.print(0);

        ListNode node = detectCycle2(node1);
        System.out.println(node == null ? null : node.val);
    }

    public static ListNode detectCycle (ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (nodes.contains(cur)) {
                return cur;
            } else {
                nodes.add(cur);
                cur = cur.next;
            }
        }
        return null;
    }

    public static ListNode detectCycle2 (ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) { val = x; }

        public void print (int index) {
            if (index > 10) {
                System.out.println("stop: too many list nodes");
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
