package com.yuanstone.practice.geektime.bdsa.sort;

public class Sort {

    public static void main (String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        int[] array2 = {2, 1};

//        printArray(array);
//        printArray(array2);

        countingSort(array);
        countingSort(array2);

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

    // 归并排序
    public static void mergeSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort (int[] array, int start, int end) {
        if (start >= end) {
            // 已拆分到最小粒度
            return;
        }
        // 取中位数
        int middle = (start + end) / 2;
        // 分治
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        // 归并
        // merge(array, start, middle, end);
        mergeWithSentry(array, start, middle, end);
    }

    private static void merge (int[] array, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = 0;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            if (array[left] <= array[right]) {
                temp[i++] = array[left++];
            } else {
                temp[i++] = array[right++];
            }
        }
        while (left <= middle) {
            temp[i++] = array[left++];
        }
        while (right <= end) {
            temp[i++] = array[right++];
        }
        for (i = 0; i <= end - start; i++) {
            array[i + start] = temp[i];
        }
    }

    private static void mergeWithSentry (int[] array, int start, int middle, int end) {
        // 复制左右子数组
        int[] left = new int[middle - start + 2];
        int[] right = new int[end - middle + 1];
        for (int i = 0; i <= middle - start; i++) {
            left[i] = array[start + i];
        }
        for (int i = 0; i < end - middle; i++) {
            right[i] = array[middle + 1 + i];
        }
        // 哨兵位
        left[middle - start + 1] = Integer.MAX_VALUE;
        right[end - middle] = Integer.MAX_VALUE;
        // 归并
        int i = 0, j = 0, k = start;
        while (k <= end) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
    }

    // 快速排序
    public static void quickSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort (int[] array, int start, int end) {
        if (start >= end) {
            // 已拆分到最小粒度
            return;
        }
        // 根据pivot，移动元素并找到分割点
        // int index = partition(array, start, end);
        int index = partition2(array, start, end);
        // 分治
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    private static int partition (int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot && j != i) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    private static int partition2 (int[] array, int start, int end) {
        int pivot = array[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    // 基数排序
    // 要求：待排序数字为非负整数
    // 适用于，数值范围较小，数字个数较多的场景
    public static void countingSort (int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        // 寻找最大值
        int max = array[0];
        for (int i = 0; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 计数数组
        int counting[] = new int[max + 1];
        for (int i = 0; i < length; i++) {
            counting[array[i]]++;
        }
        // 一次累加
        for (int i = 1; i <= max; i++) {
            counting[i] = counting[i - 1] + counting[i];
        }
        // 临时数组，存放排序后数据
        int temp[] = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int index = counting[array[i]] - 1;
            temp[index] = array[i];
            counting[array[i]]--;
        }
        // 拷贝数组
        for (int i = 0; i < length; i++) {
            array[i] = temp[i];
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
