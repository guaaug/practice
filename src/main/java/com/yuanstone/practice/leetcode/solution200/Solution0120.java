package com.yuanstone.practice.leetcode.solution200;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution0120 {

    public static void main (String[] args) {
        List<Integer> l1 = List.of(2);
        List<Integer> l2 = List.of(3, 4);
        List<Integer> l3 = List.of(6, 5, 7);
        List<Integer> l4 = List.of(4, 1, 8, 3);
        List<List<Integer>> list = List.of(l1, l2, l3, l4);
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal (List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int[] mem = new int[triangle.size()];
        List<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < mem.length; i++) {
            mem[i] = last.get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                mem[j] = Math.min(mem[j], mem[j + 1]) + triangle.get(i).get(j);
            }
        }
        return mem[0];
    }
}
