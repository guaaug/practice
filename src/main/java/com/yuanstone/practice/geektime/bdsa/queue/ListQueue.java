package com.yuanstone.practice.geektime.bdsa.queue;


import com.yuanstone.practice.geektime.bdsa.structure.ListNode;

// 链式队列实现, 无限容量
public class ListQueue {
    private ListNode head;
    private ListNode tail;

    public boolean enqueue (ListNode node) {
        if (node == null) {
            // 节点为空
            return false;
        }
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    public ListNode dequeue () {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return node;
    }
}
