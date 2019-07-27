package com.yuanstone.practice.leetcode.solution100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution0015 {

    public static void main (String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // at least 3 numbers
        if (nums == null || nums.length < 3) return list;
        // sort
        Arrays.sort(nums);
        // pre check
        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0) return list;
        // main loop
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > 0) return list;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = length - 1;
            while (low < high) {
                int result = nums[i] + nums[low] + nums[high];
                if (result == 0) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[++low]) ;
                    while (low < high && nums[high] == nums[--high]) ;
                } else if (result < 0) {
                    ++low;
                } else {
                    --high;
                }
            }
        }
        return list;
    }
}
