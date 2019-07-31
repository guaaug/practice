package com.yuanstone.practice.leetcode.solution500;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Solution0415 {

    public static void main (String[] args) {
        String num1 = "18";
        String num2 = "0";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings (String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int l1 = c1.length - 1;
        int l2 = c2.length - 1;
        char zero = '0';
        // 结果变量
        int length = Math.max(l1, l2) + 2;
        char[] result = new char[length];

        int jin = 0;
        while (l1 >= 0 || l2 >= 0) {
            int sum = jin;
            if (l1 >= 0) {
                sum += c1[l1] - zero;
                --l1;
            }
            if (l2 >= 0) {
                sum += c2[l2] - zero;
                --l2;
            }
            if (sum > 9) {
                jin = 1;
                sum -= 10;
            } else {
                jin = 0;
            }
            result[--length] = (char) (sum + zero);
        }
        if (jin == 1) {
            result[--length] = '1';
            return String.valueOf(result);
        }
        return String.valueOf(result).substring(1);
    }
}
