package com.yuanstone.practice.leetcode.solution100;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution0007 {

    public static void main (String[] args) {

        System.out.println(reverse(-2147483412));
        System.out.println(reverse1(-2147483412));
        System.out.println(reverse2(-2147483412));
    }

    public static int reverse (int x) {
        int ans = 0;
        int i = 1;
        while (x != 0) {
            int num = x % 10;
            if (i < 10) {
                ans = ans * 10 + num;
            } else {
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > 7)) {
                    ans = 0;
                    break;
                }
                if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num < -8)) {
                    ans = 0;
                    break;
                }
                ans = ans * 10 + num;
            }
            x /= 10;
            i++;
        }
        return ans;
    }

    // 更快解法
    public static int reverse1 (int x) {
        int revertedInt0 = 0;
        int revertedInt1 = 0;
        while (x != 0) {
            revertedInt1 = revertedInt0 * 10 + x % 10;
            if (revertedInt1 / 10 != revertedInt0) {
                return 0;
            }
            x /= 10;
            revertedInt0 = revertedInt1;
        }
        return revertedInt1;
    }

    public static int reverse2 (int x) {
        int ans = 0, pre = 0;
        while (x != 0) {
            pre = ans;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans / 10 != pre) {
            return 0;
        }
        return ans;
    }
}
