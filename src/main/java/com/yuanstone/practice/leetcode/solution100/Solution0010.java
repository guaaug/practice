package com.yuanstone.practice.leetcode.solution100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
 */
public class Solution0010 {

    public static void main (String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", ""));
    }

    public static boolean isMatch (String s, String p) {
        if (p == null) return s == null;
        if (p.equals("")) return s.equals("");

        Map<String, Boolean> mem = new HashMap<>();
        return isMatch(mem, s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private static boolean isMatch (Map<String, Boolean> mem, char[] sa, int si, char[] pa, int pi) {
        if (mem.get(si + "-" + pi) != null) return mem.get(si + "-" + pi);
        if (pi == pa.length) return si == sa.length;

        boolean firstMatch = si < sa.length && (sa[si] == pa[pi] || pa[pi] == '.');

        boolean result;
        if (pi < pa.length - 1 && pa[pi + 1] == '*') {
            result = isMatch(mem, sa, si, pa, pi + 2) || (firstMatch && isMatch(mem, sa, si + 1, pa, pi));
        } else {
            result = firstMatch && isMatch(mem, sa, si + 1, pa, pi + 1);
        }
        mem.put(si + "-" + pi, result);
        return result;
    }
}
