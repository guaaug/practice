package com.yuanstone.practice.leetcode.solution700;

public class MyCircularDeque0641 {
    private int head;
    private int tail;
    private int size;
    private int[] array;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque0641 (int k) {
        head = 0;
        tail = 0;
        size = k + 1;
        array = new int[size];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront (int value) {
        int nextPos = (head + 1) % size;
        if (nextPos == tail) return false;
        array[head] = value;
        head = nextPos;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast (int value) {
        int nextPos = (tail - 1 + size) % size;
        if (nextPos == head) return false;
        tail = nextPos;
        array[tail] = value;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront () {
        if (head == tail) return false;
        head = (head - 1 + size) % size;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast () {
        if (head == tail) return false;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront () {
        if (head == tail) return -1;
        return array[(head - 1 + size) % size];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear () {
        if (head == tail) return -1;
        return array[tail];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty () {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull () {
        return (head + 1) % size == tail;
    }
}
