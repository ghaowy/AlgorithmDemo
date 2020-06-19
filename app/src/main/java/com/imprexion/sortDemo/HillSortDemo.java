package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 17:13
 * @desc : 希尔排序()
 */
public class HillSortDemo {

    public static void main(String[] args) {
        hillSort2(new int[]{5, 1, 4, 2, 51, 69, 48, 20});
    }

    /**
     * 算法思路,设置部长去分组采用插入排序
     * 时间复杂度o(n^logn)
     * 空间复杂度 o(1)
     *
     * @param arr
     */
    private static void hillSort2(int[] arr) {
        int len = arr.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    //--------------------------------------------------------------------------------------------------
    private static void hillSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int gap = (int) Math.floor(length / 2); gap >= 1; gap = (int) Math.floor(gap / 2)) {
            // 根据部长遍历 ，将对应元素进行插入排序
            for (int i = gap; i < length; i++) {
                int index = i - gap;
                int filed = arr[i];
                int currentIndex = i - gap;
                while (currentIndex >= 0) {
                    if (arr[currentIndex] > filed) {
                        arr[currentIndex + gap] = arr[currentIndex];
                    } else {
                        index = currentIndex + gap;
                        break;
                    }
                    currentIndex -= gap;
                }
                arr[index] = filed;
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("---------------------------------------------");
        System.out.println(Arrays.toString(arr));
    }
}
