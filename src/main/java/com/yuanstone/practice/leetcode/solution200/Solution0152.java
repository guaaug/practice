package com.yuanstone.practice.leetcode.solution200;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution0152 {

    public static void main (String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct (int[] nums) {
        if (nums.length == 1) return nums[0];
        int min = nums[0], max = nums[0], result = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

    // another
    public int maxProduct2 (int[] A) {
        // edge case
        if (A == null || A.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int product = 1;
        // first go from left to right
        for (int i = 0; i < A.length; i++) {
            product *= A[i];
            if (product > max)
                max = product;
            if (product == 0)
                product = 1; // reset if encounter 0
        }
        // then go from right to left
        product = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            product *= A[i];
            if (product > max)
                max = product;
            if (product == 0)
                product = 1; // reset if encounter 0
        }
        return max;
    }
}
