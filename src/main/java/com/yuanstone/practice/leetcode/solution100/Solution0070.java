package com.yuanstone.practice.leetcode.solution100;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution0070 {

    public static void main (String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs (int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int sub1 = 2, sub2 = 1;
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = sub1 + sub2;
            sub2 = sub1;
            sub1 = total;
        }
        return total;
    }
}
