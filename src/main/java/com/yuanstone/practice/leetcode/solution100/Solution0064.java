package com.yuanstone.practice.leetcode.solution100;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution0064 {

    public static void main (String[] args) {
        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum (int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rowSize = grid.length;
        int columnSize = grid[0].length;
        int[][] mem = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                mem[i][j] = -1;
            }
        }
        mem[0][0] = grid[0][0];
        return minPathSum(mem, grid, rowSize - 1, columnSize - 1);
    }

    private static int minPathSum (int[][] mem, int[][] grid, int i, int j) {
        if (mem[i][j] >= 0) return mem[i][j];
        int temp = Integer.MAX_VALUE;
        if (i > 0) temp = minPathSum(mem, grid, i - 1, j);
        if (j > 0) temp = Math.min(temp, minPathSum(mem, grid, i, j - 1));
        int result = temp + grid[i][j];
        mem[i][j] = result;
        return result;
    }

    // 另一个解法
    public int minPathSum2 (int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[] res = new int[grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            res[i] = sum;
        }
        for (int i = 1; i < grid.length; i++) {
            res[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++)
                res[j] = Math.min(res[j], res[j - 1]) + grid[i][j];
        }
        return res[res.length - 1];
    }
}
