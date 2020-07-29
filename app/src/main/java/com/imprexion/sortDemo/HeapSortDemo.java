package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/22 17:14
 * @desc : 堆排序
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 8, 9, 1, 2, 5, 6};
        heapSort(arr, arr.length);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    private static void heapSort(int[] arr, int length) {
        if (arr == null || length < 2) {
            return;
        }
        //1、遍历非叶子节点 构建大顶堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            if (2 * i + 1 < length) {
                if (arr[i] < arr[2 * i + 1]) {
                    swap(arr, i, 2 * i + 1);
                }
            }

            if (2 * i + 2 < length) {
                if (arr[i] < arr[2 * i + 2]) {
                    swap(arr, i, 2 * i + 2);
                }
            }
        }

        // 构建为大顶堆后，最大的元素就在第一个，移动到最后一个的位置
        swap(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));
        // 移除最大节点后，再将其他元素进行堆排序
        heapSort(arr, length - 1);

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
