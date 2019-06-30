package com.yuanstone.practice.geektime.bdsa.queue;

// 顺序链表实现
public class ArrayQueue<T> {
    private T[] queue;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue (int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    // 数组只能使用一次的入队方式
    public boolean enqueue (T t) {
        if (tail == capacity) {
            // 队列满
            return false;
        }
        queue[tail] = t;
        tail++;
        return true;
    }

    // 入队操作，tail == capacity 时，增加数据向数组前端迁移的操作，复用数组空间
    public boolean enqueue2 (T t) {
        if (tail == capacity) {
            if (head == 0) {
                // 整个数组空间都用满了
                return false;
            }
            // 迁移数据
            for (int i = head; i < tail; i++) {
                queue[i - head] = queue[i];
            }
            // 更新队列头尾指针
            tail -= head;
            head = 0;
        }
        queue[tail] = t;
        tail++;
        return true;
    }

    public T dequeue () {
        if (tail == head) {
            return null;    // 队列空
        }
        T t = queue[head];
        head++;
        return t;
    }
}
