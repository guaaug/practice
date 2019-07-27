package com.yuanstone.practice.leetcode.solution100;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Solution0036 {

    public boolean isValidSudoku (char[][] board) {
        Map<Character, Integer>[] rows = new Map[9];
        Map<Character, Integer>[] columns = new Map[9];
        Map<Character, Integer>[] boxes = new Map[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(8);
            columns[i] = new HashMap<>(8);
            boxes[i] = new HashMap<>(8);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int box = (i / 3) * 3 + j / 3;
                    if (rows[i].get(board[i][j]) != null) return false;
                    else rows[i].put(board[i][j], 1);
                    if (columns[j].get(board[i][j]) != null) return false;
                    else columns[j].put(board[i][j], 1);
                    if (boxes[box].get(board[i][j]) != null) return false;
                    else boxes[box].put(board[i][j], 1);
                }
            }
        }
        return true;
    }

    // 快速示例，基于位操作
    public boolean isValidSudoku2 (char[][] board) {
        short[] rows = new short[9];
        short[] columns = new short[9];
        short[] boxes = new short[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int bit = (1 << board[i][j] - '1');
                    int box = (i / 3) * 3 + j / 3;
                    if ((bit & rows[i]) > 0 || (bit & columns[j]) > 0 || (bit & boxes[box]) > 0) return false;
                    rows[i] |= bit;
                    columns[j] |= bit;
                    boxes[box] |= bit;
                }
            }
        }
        return true;
    }
}
