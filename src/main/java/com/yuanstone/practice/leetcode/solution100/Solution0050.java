package com.yuanstone.practice.leetcode.solution100;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Solution0050 {

    public static void main (String[] args) {
        double x = 2.0;
        int n = 2;
        System.out.println(myPow(x, n));
    }

    public static double myPow (double x, int n) {
        if (n == 0) return 1.0;
        if (n == Integer.MIN_VALUE) {
            double half = myPow(x, n / 2);
            return half * half;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return pow(x, n);
    }

    private static double pow (double x, int n) {
        if (n == 1) return x;
        double half = pow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}
