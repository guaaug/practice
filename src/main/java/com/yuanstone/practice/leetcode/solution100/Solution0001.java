package com.yuanstone.practice.leetcode.solution100;

import com.yuanstone.practice.geektime.bdsa.algorithm.Sort;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution0001 {

    public static void main (String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum(array, 9);
        Sort.printArray(result);
    }

    public static int[] twoSum (int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // 寻找最小、最大值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("min " + min + " max " + max);
        // 按数值范围创建哈希表 (优化空间较大)
        Integer[] temp = new Integer[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("high " + (target - nums[i] - min));
            System.out.println("low " + (nums[i] + min));

            int other = target - nums[i];
            if ((other >= min) && (other <= max) && (temp[other - min] != null)) {
                return new int[]{temp[other - min], i};
            }
            temp[nums[i] - min] = i;
        }
        return null;
    }
}