package com.yuanstone.practice.geektime.bdsa.queue;

import org.omg.CORBA.Object;

// 环形队列实现
public class CircularQueue<T> {
    private T[] queue;
    private int capacity;
    private int head;
    private int tail;

    public CircularQueue (int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue (T t) {
        if ((tail + 1) % capacity == head) {
            // 队列满（存在一个不可用空间）
            return false;
        }
        queue[tail] = t;
        tail = (tail + 1) % capacity;
        return true;
    }

    public T dequeue () {
        if (head == tail) {
            // 队列空
            return null;
        }
        T t = queue[head];
        head = (head + 1) % capacity;
        return t;
    }
}
