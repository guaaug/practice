package com.yuanstone.practice.geektime.bdsa.algorithm;

public class Search {

    public static void main (String[] args) {
        int[] array = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        Sort.printArray(array);

        int index = binarySearch2(array, 19);

        System.out.println(index == -1 ? null : array[index]);
    }

    public static int binarySearch (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            System.out.println("low=" + low + " middle=" + middle + " high=" + high);
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2 (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        return binarySearchInternally(array, 0, array.length - 1, value);
    }

    private static int binarySearchInternally (int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearchInternally(array, low, middle - 1, value);
        } else {
            return binarySearchInternally(array, middle + 1, high, value);
        }
    }
}
