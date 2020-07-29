package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/24 17:38
 * @desc : TODO 计数排序
 */
public class CountSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 8, 9, 1, 2, 5, 6};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 时间复杂度 o(N + M) M为数字区间范围
     * 控件复杂度为o(M +N)
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 1、查找获取元素最大值
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            if ((2 * i + 1) < arr.length && arr[2 * i + 1] > arr[i]) {
                swap(arr, 2 * i + 1, i);
            }
            if ((2 * i + 2) < arr.length && arr[2 * i + 2] > arr[i]) {
                swap(arr, 2 * i + 2, i);
            }
        }
        int max = arr[0];
        System.out.println(max);
        System.out.println(Arrays.toString(arr));

        // 1、查找获取元素最小值
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            if ((2 * i + 1) < arr.length && arr[2 * i + 1] < arr[i]) {
                swap(arr, 2 * i + 1, i);
            }
            if ((2 * i + 2) < arr.length && arr[2 * i + 2] < arr[i]) {
                swap(arr, 2 * i + 2, i);
            }
            System.out.println(Arrays.toString(arr));
        }

        int min = arr[0];
        System.out.println(min);
        System.out.println(Arrays.toString(arr));
        int[] countArr = new int[max - min + 1];
        // 统计原数组中所有元素出现的个数
        for (int value : arr) {
            countArr[value - min]++;
        }

        // 将统计结果重新解构放入新数组
        int count = 0;
        int arrIndex = 0;
        while (count < countArr.length) {
            while (countArr[count] != 0) {
                arr[arrIndex] = count + min;
                countArr[count]--;
                arrIndex++;
            }
            count++;
        }
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
