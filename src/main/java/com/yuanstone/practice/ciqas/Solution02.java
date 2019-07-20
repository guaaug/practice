package com.yuanstone.practice.ciqas;

/**
 * 实现单例模式
 */
public class Solution02 {
    private Solution02 () {}

    // 懒加载，第一次调用 getInstance 时，才会触发 Holder 的初始化
    public static Solution02 getInstance () {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final Solution02 INSTANCE = new Solution02();
    }
}
