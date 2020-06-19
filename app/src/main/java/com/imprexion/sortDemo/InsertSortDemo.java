package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 16:36
 * @desc : TODO 插入排序
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        insertSortDemo(new int[]{5, 1, 4, 2, 51, 69, 48, 20, -1, 6, 2});
    }

    /**
     * 算法思想： 构建有序数组队列，从后往前进行比较
     * 时间复杂度 o(n^2)
     * 空间复杂度 o(1)
     *
     * @param arr
     */
    private static void insertSortDemo(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        // 1、已i作为有序数组队列分界点，i前面队列为有序，后面为无序
        for (int i = 0; i < length; i++) {
            // 存储插入元素的值
            int field = arr[i];
            // 存储插入的索引
            int currentIndex = i;
            while (currentIndex - 1 >= 0 && arr[currentIndex - 1] > field) {
                arr[currentIndex] = arr[currentIndex - 1];
                currentIndex -= 1;
            }
            arr[currentIndex] = field;
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
