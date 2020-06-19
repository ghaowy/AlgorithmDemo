package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 16:05
 * @desc : 选择排序
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        selectionSortDemo(new int[]{5, 1, 4, 2, 51, 69, 48, 20});
    }

    /**
     * 算法思想：固定首个元素与其他所有元素比较得到最大元素或最小元素，再继续使用下一个元素与其他所有元素进行比较排序
     * 时间复杂度 o(n^2)
     * 空间复杂度 o(1)
     *
     * @param arr
     */
    private static void selectionSortDemo(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr == null) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
