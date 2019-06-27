package com.yuanstone.practice.geektime.bdsa.list;

import com.yuanstone.practice.geektime.bdsa.structure.ListNode;

public class LinkedList {

    // 单链表反转
    public static ListNode reverse (ListNode list) {
        ListNode current = list, pre = null, next;
        while (current != null) {
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    // 单链表检测环
    public static boolean checkCircle (ListNode list) {
        ListNode one = list, two = list;
        while (two != null) {
            one = one.getNext();
            two = (two.getNext() == null ? null : two.getNext().getNext());
            if (one == two) {
                return true;
            }
        }
        return false;
    }

    // 有序链表合并
    public static ListNode merge (ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            ListNode merge = new ListNode();
            ListNode pos = merge;
            while (list1 != null && list2 != null) {
                if (list1.getData() <= list2.getData()) {
                    pos.setNext(list1);
                    list1 = list1.getNext();
                } else {
                    merge.setNext(list2);
                    list2 = list2.getNext();
                }
                pos = pos.getNext();
            }
            if (list1 != null) {
                pos.setNext(list1);
            } else {
                pos.setNext(list2);
            }
            return merge.getNext();
        }
    }

    // 删除链表倒数第k个节点
    public static void deleteLastKth (ListNode list, int k) {
        if (k <= 0 || list == null) {
            return;
        }
        ListNode fast = list;
        for (int i = 1; i < k; i++) {
            fast = fast.getNext();
            if (fast == null) {
                return;
            }
        }
        ListNode slow = list;
        ListNode pre = null;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            pre = slow;
            slow = slow.getNext();
        }
        if (pre == null) {
            list = list.getNext();
        } else {
            pre.setNext(pre.getNext().getNext());
        }
    }

    // 求链表的中间节点
    public static ListNode getMiddle (ListNode list) {
        if (list == null) {
            return null;
        }
        ListNode fast = list;
        ListNode slow = list;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // 链表偶数节点时，返回了中间两个节点离头结点较近的一个
        return slow;
    }


    public static ListNode test (ListNode list) {
        ListNode current = list, pre = null;
        while (current != null) {
            list = list.getNext();
            current.setNext(pre);
            pre = current;
            current = list;
        }
        return pre;
    }
}