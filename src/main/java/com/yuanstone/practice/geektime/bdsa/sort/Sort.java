package com.yuanstone.practice.geektime.bdsa.sort;

public class Sort {

    public static void main (String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        int[] array2 = {2, 1};

//        printArray(array);
//        printArray(array2);

        selectionSort(array);
        selectionSort(array2);

        printArray(array);
        printArray(array2);
    }

    // 冒泡排序
    public static void bubbleSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = length - 1; i > 0; i--) {
            // 每一轮冒泡排序前的交换操作标记，初始为false，代表没有交换操作
            boolean exchange = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    // 标记有交换操作
                    exchange = true;
                }
            }
            if (!exchange) {
                // 如果没有交换操作，数组已经有序，返回
                return;
            }
        }
    }

    // 插入排序
    public static void insertionSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = array[i + 1];
            int j = i;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    // 选择排序
    public static void selectionSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    private static void printArray (int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty array");
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i != array.length - 1) {
                    System.out.print(" -> ");
                }
            }
        }
        System.out.println();
    }
}
