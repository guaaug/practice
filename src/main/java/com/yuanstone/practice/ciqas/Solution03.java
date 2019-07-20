package com.yuanstone.practice.ciqas;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 */
public class Solution03 {

    public static void main (String[] args) {
        int[] a1 = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findDuplicate(a1));

        int[] a2 = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(findDuplicate2(a2));
    }

    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 ~ n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * <p>
     * 例如：
     * 现有长度为7的数组 [2,3,1,0,2,5,3]，那么对应的输出是重复的数字2或者3。
     */
    public static int findDuplicate (int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("param empty");
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 || array[i] >= length) {
                throw new RuntimeException("param error");
            }
            while (array[i] != i) {
                if (array[array[i]] == array[i]) {
                    return array[i];
                }
                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;
            }
        }
        throw new RuntimeException("no duplicate");
    }

    /**
     * 在一个长度为 n+1 的数组里的所有数字都在 1 ~ n 的范围内，所以数组中至少有一个数字是重复的。
     * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
     * <p>
     * 例如：
     * 现有长度为8的数组 [2,3,5,4,3,2,6,7]，那么对应的输出是重复的数字2或者3。
     */
    public static int findDuplicate2 (int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("param empty");
        }
        Map<Integer, Boolean> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                return array[i];
            }
            map.put(array[i], true);
        }
        throw new RuntimeException("param error");
    }
}
