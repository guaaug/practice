package com.yuanstone.practice.leetcode.solution100;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Solution0032 {

    public static void main (String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses (String s) {
        if (s == null || s.length() == 0) return 0;
        int longest = 0;
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') ++left;
            if (chars[i] == ')') ++right;
            if (left == right) {
                longest = Math.max(longest, 2 * left);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')') ++right;
            if (chars[i] == '(') ++left;
            if (left == right) {
                longest = Math.max(longest, 2 * right);
            } else if (right < left) {
                left = 0;
                right = 0;
            }
        }
        return longest;
    }

    // 最快示例
    public int longestValidParentheses2 (String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '(') {
                continue;
            } else {
                if (i - 2 >= 0) {
                    if (s.charAt(i - 2) == '(') {
                        dp[i] = dp[i - 2] + 2;
                    } else if (s.charAt(i - 2) == ')' && i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + dp[i - 2 - dp[i - 1]] + 2;
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
