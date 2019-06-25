package com.yuanstone.practice.geektime.bdsa.linkedlist;

import lombok.Data;

public class LinkedList {

    // 单链表反转
    public static Node reverse (Node list) {
        Node current = list, pre = null, next;
        while (current != null) {
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    // 单链表检测环
    public static boolean checkCircle (Node list) {
        Node one = list, two = list;
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
    public static Node merge (Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            Node merge = new Node();
            Node pos = merge;
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


    public static Node test (Node list) {
        Node current = list, pre = null;
        while (current != null) {
            list = list.getNext();
            current.setNext(pre);
            pre = current;
            current = list;
        }
        return pre;
    }
}

@Data
class Node {
    private Node next;
    private int data;
}
