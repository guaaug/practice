package com.yuanstone.practice.leetcode.solution100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution0022 {

    public static void main (String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis (int n) {
        if (n <= 0) return null;
        List<String> result = new ArrayList<>();
        generateAll(result, "", 0, 0, n);
        return result;
    }

    private static void generateAll (List<String> result, String cur, int left, int right, int size) {
        if (cur.length() == 2 * size) {
            result.add(cur);
            return;
        }
        if (left < size) generateAll(result, cur + "(", left + 1, right, size);
        if (right < left) generateAll(result, cur + ")", left, right + 1, size);
    }
}
