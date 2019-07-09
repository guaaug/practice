package com.yuanstone.practice.geektime.bdsa.algorithm;

public class Search {

    public static void main (String[] args) {
        int[] array = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        Sort.printArray(array);

        int index = binarySearch2(array, 19);

        System.out.println(index == -1 ? null : array[index]);

        // --------------------
        int[] a1 = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Sort.printArray(a1);

        index = binarySearch4First(a1, 8);
        System.out.println(index);
        index = binarySearch4First2(a1, 8);
        System.out.println(index);

        index = binarySearch4Last(a1, 8);
        System.out.println(index);

        // --------------------
        int[] a2 = {3, 5, 6, 8, 9, 10};
        Sort.printArray(a2);

        index = binarySearch4FirstGtOrEq(a2, 6);
        System.out.println(index);

        index = binarySearch4LastLtOrEq(a2, 7);
        System.out.println(index);

        // --------------------
        int[] a3 = {6, 8, 10, 1, 3, 5};
        Sort.printArray(a3);

        index = binarySearch4Circle(a3, 3);
        System.out.println(index);
    }

    // 有序且无重复数组
    public static int binarySearch (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
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

    // 有序且无重复数组，递归
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

    // 有序数组，可能存在重复数字，寻找第一个
    public static int binarySearch4First (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] > value) {
                high = middle - 1;
            } else if (array[middle] < value) {
                low = middle + 1;
            } else {
                if (middle == 0 || array[middle - 1] != value) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch4First2 (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            System.out.println("low " + low + " middle " + middle + " high " + high);
            if (array[middle] >= value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        System.out.println("low " + low + " high " + high);

        if (low < array.length && array[low] == value) return low;
        else return -1;
    }


    // 有序数组，可能存在重复数字，寻找最后一个
    public static int binarySearch4Last (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] > value) {
                high = middle - 1;
            } else if (array[middle] < value) {
                low = middle + 1;
            } else {
                if (middle == array.length - 1 || array[middle + 1] != value) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    // 有序数组，可能存在重复数字，寻找第一个不小于value的
    public static int binarySearch4FirstGtOrEq (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] >= value) {
                if (middle == 0 || array[middle - 1] < value) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    // 有序数组，可能存在重复数字，寻找最后一个不大于value的
    public static int binarySearch4LastLtOrEq (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] <= value) {
                if (middle == array.length - 1 || array[middle + 1] > value) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    // 无重复循环有序数组，二分查找value
    public static int binarySearch4Circle (int[] array, int value) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        return binarySearch4CircleInternally(array, 0, array.length - 1, value);
    }

    private static int binarySearch4CircleInternally (int[] array, int low, int high, int value) {
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] == value) {
                return middle;
            } else if (array[low] < array[middle]) {
                // low 半部分数组有序
                if (value >= array[low] && value < array[middle]) {
                    // value 在有序区间内
                    return binarySearchInternally(array, low, middle - 1, value);
                } else {
                    return binarySearch4CircleInternally(array, middle + 1, high, value);
                }
            } else {
                // high 半部分数组有序
                if (value > array[middle] && value <= array[high]) {
                    // value 在有序区间内
                    return binarySearchInternally(array, middle + 1, high, value);
                } else {
                    return binarySearch4CircleInternally(array, low, middle - 1, value);
                }
            }
        }
        return -1;
    }
}
