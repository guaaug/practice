package com.yuanstone.practice.leetcode;

import com.yuanstone.practice.geektime.bdsa.algorithm.Sort;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * <p>
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 注意：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * <p>
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 */
public class Solution0239 {

    public static void main (String[] args) {
//        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] array = {1, 3, 1, 2, 0, 5};
        int[] result = maxSlidingWindow(array, 3);
        Sort.printArray(result);
    }

    public static int[] maxSlidingWindow (int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 滑动窗口最大值数组
        int[] result = new int[nums.length - k + 1];
        // 初始化滑动窗口双端队列
        Deque<Integer> deque = new LinkedList();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        // 滑动窗口并填充结果到数组
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
