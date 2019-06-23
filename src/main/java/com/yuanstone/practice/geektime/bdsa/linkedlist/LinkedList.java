package com.yuanstone.practice.geektime.bdsa.linkedlist;

import lombok.Data;

public class LinkedList {

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
}

@Data
class Node {
    private Node next;
}
