package com.yuanstone.practice.leetcode.solution400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke
 */
public class Solution0322 {

    public static void main (String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange (int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount > 0 && (coins == null || coins.length == 0)) return -1;

        Map<Integer, Integer> mem = new HashMap<>();
        mem.put(0, 0);
        for (int i = 0; i < coins.length; i++) {
            mem.put(coins[i], 1);
        }
        int result = coinChange(mem, amount, coins);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private static int coinChange (Map<Integer, Integer> mem, int amount, int[] coins) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (mem.containsKey(amount)) return mem.get(amount);
        int subMin = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            subMin = Math.min(subMin, coinChange(mem, amount - coins[i], coins));
        }
        int result;
        if (subMin == Integer.MAX_VALUE) {
            result = subMin;
        } else {
            result = subMin + 1;
        }
        mem.put(amount, result);
        return result;
    }

    // --------------------------------------------------------
    private static int result = Integer.MAX_VALUE;

    public static int coinChange2 (int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        Arrays.sort(coins);
        helper(amount, coins, coins.length - 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static void helper (int amount, int[] coins, int idx, int cur) {
        if (idx < 0) return;
        if (amount % coins[idx] == 0) {
            result = Math.min(result, cur + amount / coins[idx]);
            return;
        }
        for (int i = amount / coins[idx]; i >= 0; i--) {
            if (cur + i > result - 1) {
                return;
            }
            helper(amount - i * coins[idx], coins, idx - 1, cur + i);
        }
    }

    // --------------------------------------------------------
    // 动态规划
    public static int coinChange3 (int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], (dp[i - coin] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - coin] + 1));
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
