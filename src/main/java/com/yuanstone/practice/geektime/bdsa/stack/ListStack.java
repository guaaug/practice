package com.yuanstone.practice.geektime.bdsa.stack;

import com.yuanstone.practice.geektime.bdsa.structure.ListNode;

// 链式栈实现, 无限容量
public class ListStack {
    private ListNode head;

    public boolean push (ListNode node) {
        if (node == null) {
            return false; // 不支持null节点
        }
        node.setNext(head);
        head = node;
        return true;
    }

    public ListNode pop () {
        if (head == null) {
            return null; // 栈空
        }
        ListNode node = head;
        head = head.getNext();
        return node;
    }
}
