package com.yuanstone.practice.geektime.bdsa.stack;

import org.omg.CORBA.Object;

// 顺序栈实现
public class ArrayStack<T> {
    private T[] stack;      // 栈数组
    private int capacity;   // 栈容量
    private int position;   // 栈顶位置

    public ArrayStack (int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("capacity error...");
        }
        capacity = capacity;
        stack = (T[]) new Object[capacity];
        position = 0;
    }

    public boolean push (T t) {
        if (position == capacity) {
            return false;   // 栈满
        }
        stack[position] = t;
        position++;
        return true;
    }

    public T pop () {
        if (position == 0) {
            return null;    // 栈空
        }
        position--;
        return stack[position];
    }
}
