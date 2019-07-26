package com.yuanstone.practice.leetcode;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 进阶：
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class Solution0151 {

    public static void main (String[] args) {
        System.out.println(reverseWords("  a  good   example  "));
    }

    public static String reverseWords (String s) {
        if (s == null || s.length() == 0) return s;
        if (s.trim().length() == 0) return "";
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].length() > 0) {
                sb.append(array[i]).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // 快速示例
    public String reverseWords2 (String s) {
        if (s.trim().length() == 0)
            return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            if (!words[i].trim().equals(""))
                sb.append(words[i] + " ");
        return sb.toString().trim();
    }
}
