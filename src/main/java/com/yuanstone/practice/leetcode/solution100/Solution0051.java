package com.yuanstone.practice.leetcode.solution100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class Solution0051 {

    public static void main (String[] args) {
        List<List<String>> result = solveNQueens(4);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens (int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, n, 0, new int[n], new int[n], new int[2 * n], new int[2 * n]);
        return result;
    }

    public static void dfs (List<List<String>> result, int n, int row, int[] board, int[] cols, int[] pie, int[] na) {
        if (row >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowi = new char[n];
                Arrays.fill(rowi, '.');
                rowi[board[i]] = 'Q';
                list.add(new String(rowi));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] > 0 || pie[row + i] > 0 || na[row - i + n] > 0) continue;

            cols[i] += 1;
            pie[row + i] += 1;
            na[row - i + n] += 1;

            board[row] = i;
            dfs(result, n, row + 1, board, cols, pie, na);

            cols[i] -= 1;
            pie[row + i] -= 1;
            na[row - i + n] -= 1;
        }
    }
}
