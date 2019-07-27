package com.yuanstone.practice.leetcode.solution100;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution0023 {

    public static void main (String[] args) {
        ListNode n13 = new ListNode(5);
        ListNode n12 = new ListNode(4);
        ListNode n11 = new ListNode(1);
        n12.next = n13;
        n11.next = n12;

        ListNode n23 = new ListNode(4);
        ListNode n22 = new ListNode(3);
        ListNode n21 = new ListNode(1);
        n22.next = n23;
        n21.next = n22;

        ListNode n32 = new ListNode(6);
        ListNode n31 = new ListNode(2);
        n31.next = n32;

        ListNode node = mergeKLists(new ListNode[]{n11, n21, n31});
        if (node == null) {
            System.out.println("null");
        } else {
            node.print();
        }
    }

    public static ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int amount = lists.length;
        int low = 0, high = amount - 1;
        while (amount > 1) {
            if (low < high) {
                lists[low] = merge2Lists(lists[low], lists[high]);
                ++low;
                --high;
            } else {
                low = 0;
                amount = high + 1;
            }
        }
        return lists[0];
    }

    private static ListNode merge2Lists (ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) current.next = left;
        if (right != null) current.next = right;
        return head.next;
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
