package com.yuanstone.practice.leetcode.solution300;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Solution0242 {

    public static void main (String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram (String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hash = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (char c : sa) {
            hash[c - 'a']++;
        }
        for (char c : ta) {
            hash[c - 'a']--;
            if (hash[c - 'a'] < 0) return false;
        }
        return true;
    }
}
