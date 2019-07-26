package com.yuanstone.practice.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Solution0069 {

    public static void main (String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt (int x) {
        if (x == 0 || x == 1) return x;
        if (x >= 2147395600) return 46340;
        int low = 0, high = Math.min(x, 92678);
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid * mid > x) {
                high = mid - 1;
            } else if ((mid + 1) * (mid + 1) > x) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public int mySqrt2 (int x) {// 使用二分法，找出平方比x的区间，返回分界点;
        if (x == 0) return 0;

        long left = 1, right = x / 2 + 1;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (mid * mid > x) right = mid;// 返回值不可能是right
            if (mid * mid < x) left = mid;// 返回值只可能是left
            if (mid * mid == x) return (int) mid;
        }
        return (int) left;
    }

    public int mySqrt3 (int x) {
        long lhs = 0, rhs = x;
        while (lhs < rhs) {
            long mid = (lhs + rhs + 1) / 2;
            if (mid <= x / mid) {
                lhs = mid;
            } else {
                rhs = mid - 1;
            }
        }
        return (int) lhs;
    }
}
