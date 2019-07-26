package com.yuanstone.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution0020 {

    public static void main (String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid (String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (!pairs.containsKey(chars[i])) stack.push(chars[i]);
            else if (stack.isEmpty() || stack.pop() != pairs.get(chars[i])) return false;
        if (!stack.isEmpty()) return false;
        return true;
    }
}
