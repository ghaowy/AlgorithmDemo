package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 15:57
 * @desc : TODO冒泡排序
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        bubbleSort(new int[]{5, 1, 4, 2, 51, 69, 48, 20});
    }

    /**
     * 比较两个相邻的数字，根据排序规则进行交换
     * 时间复杂度是o(n^2)
     * 空间复杂度为o(1)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (j + 1 >= length) {
                    continue;
                }
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
