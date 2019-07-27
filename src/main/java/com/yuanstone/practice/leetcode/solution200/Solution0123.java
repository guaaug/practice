package com.yuanstone.practice.leetcode.solution200;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
 */
public class Solution0123 {

    public static void main (String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit (int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][3][2];    // [第i天][买入次数][是否持股]
        dp[0][0][0] = 0;                    // 无买入，无持股，收益0
        dp[0][0][1] = Integer.MIN_VALUE;    // 无买入，有持股，不可能发生，收益负无穷
        dp[0][1][0] = Integer.MIN_VALUE;    // 有买入，无持股，不可能发生，收益负无穷
        dp[0][1][1] = -prices[0];           // 有买入，有持股，收益负数
        dp[0][2][0] = Integer.MIN_VALUE;    // 买入次数>天数，不可能发生，收益负无穷
        dp[0][2][1] = Integer.MIN_VALUE;    // 买入次数>天数，不可能发生，收益负无穷
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i]);
            // 无买入，无持股，收益0
            dp[i][0][0] = 0;

            // dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][-1][0] - prices[i]);
            // 无买入，有持股，不可能发生
            dp[i][0][1] = Integer.MIN_VALUE;

            // dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);

            // dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            // 带入 dp[i - 1][0][0] == 0
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);

            // dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);

            // dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], (dp[i - 1][1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][1][0] - prices[i]));
        }
        int result = dp[prices.length - 1][2][0];
        result = Math.max(result, dp[prices.length - 1][1][0]);
        return Math.max(result, dp[prices.length - 1][0][0]);
    }

    // 对 maxProfit 进行简化
    public static int maxProfit2 (int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dp10 = Integer.MIN_VALUE;
        int dp11 = -prices[0];
        int dp20 = Integer.MIN_VALUE;
        int dp21 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, (dp10 == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp10 - prices[i]));
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, -prices[i]);
        }
        return Math.max(Math.max(dp20, dp10), 0);
    }
}
