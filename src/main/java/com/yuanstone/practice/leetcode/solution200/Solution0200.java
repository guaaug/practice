package com.yuanstone.practice.leetcode.solution200;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class Solution0200 {

    public static void main (String[] args) {
        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';
        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';
        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';

        System.out.println(numIslands(grid));
//        System.out.println(numIslands2(grid));
//        System.out.println(numIslands3(grid));
    }

    public static int numIslands (char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int num = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (grid[i][j] == '1') {
                    ++num;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private static void dfs (char[][] grid, int row, int column) {
        int rowSize = grid.length;
        int columnSize = grid[0].length;

        if (row < 0 || column < 0 || row >= rowSize || column >= columnSize || grid[row][column] == '0') return;

        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }

    public static int numIslands2 (char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int num = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (grid[i][j] == '1') {
                    ++num;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.offer(i * columnSize + j);
                    while (!queue.isEmpty()) {
                        int row = queue.peek() / columnSize;
                        int column = queue.poll() % columnSize;
                        if (row > 1 && grid[row - 1][column] == '1') {
                            queue.offer((row - 1) * columnSize + column);
                            grid[row - 1][column] = '0';
                        }
                        if (row < rowSize - 1 && grid[row + 1][column] == '1') {
                            queue.offer((row + 1) * columnSize + column);
                            grid[row + 1][column] = '0';
                        }
                        if (column > 1 && grid[row][column - 1] == '1') {
                            queue.offer(row * columnSize + (column - 1));
                            grid[row][column - 1] = '0';
                        }
                        if (column < columnSize - 1 && grid[row][column + 1] == '1') {
                            queue.offer(row * columnSize + (column + 1));
                            grid[row][column + 1] = '0';
                        }
                    }
                }

            }
        }
        return num;
    }

    public static int numIslands3 (char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        UnionFind uf = new UnionFind(grid);
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (grid[i][j] == '1') {
//                    grid[i][j] = '0';
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(i * columnSize + j, (i - 1) * columnSize + j);
                    }
                    if (i < rowSize - 1 && grid[i + 1][j] == '1') {
                        uf.union(i * columnSize + j, (i + 1) * columnSize + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * columnSize + j, i * columnSize + j - 1);
                    }
                    if (j < columnSize - 1 && grid[i][j + 1] == '1') {
                        uf.union(i * columnSize + j, i * columnSize + j + 1);
                    }
                }
            }
        }
        return uf.getNum();
    }

    static class UnionFind {
        private int num;
        private int parent[];
        private int rank[];

        public UnionFind (char[][] grid) {
            int rowSize = grid.length;
            int columnSize = grid[0].length;

            num = 0;
            parent = new int[rowSize * columnSize];
            rank = new int[rowSize * columnSize];

            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < columnSize; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * columnSize + j] = i * columnSize + j;
                        ++num;
                    }
                    rank[i * columnSize + j] = 0;
                }
            }
        }

        public int find (int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
                --num;
            }
        }

        public int getNum () {
            return num;
        }
    }
}
