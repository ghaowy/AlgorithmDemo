package com.imprexion.sortDemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/6/18 17:55
 * @desc : 归并排序
 */
public class MergeSortDemo {

    public static void main(String[] args) {
//        int[] newArr = mergeSort(new int[]{5, 1, 4, 2, 51, 69, 48, 20});
        int[] newArr = mergeSort1(new int[]{5, 1, 4, 2, 51, 69, 48, 20});

        System.out.println(Arrays.toString(newArr));
    }

    private static int[] mergeSort1(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 1) {
            return arr;
        }

        int[] leftArr = mergeSort1(Arrays.copyOfRange(arr, 0, arr.length / 2));
        int[] rightArr = mergeSort1(Arrays.copyOfRange(arr, arr.length / 2, arr.length));


        int length = leftArr.length + rightArr.length;
        int[] newArr = new int[length];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < length; i++) {
            if (leftIndex >= leftArr.length) {
                newArr[i] = rightArr[rightIndex];
                rightIndex++;
                continue;
            }
            if (rightIndex >= rightArr.length) {
                newArr[i] = leftArr[leftIndex];
                leftIndex++;
                continue;
            }

            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                newArr[i] = leftArr[leftIndex];
                leftIndex++;
            } else {
                newArr[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
        return newArr;
    }


    /**
     * 算法思想：
     * 将数组拆开为若干个小数组,再将小数组一个个合并为一个有序的数组
     * 时间复杂度o(nlogn)
     * 空间复杂度o(n)
     *
     * @param arr
     * @return
     */
    private static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int index = arr.length / 2;
        if (index == 0) {
            return arr;
        }
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, index));
        int[] right = mergeSort(Arrays.copyOfRange(arr, index, arr.length));
        System.out.println("left= " + Arrays.toString(left));
        System.out.println("right= " + Arrays.toString(right));
        int[] newArr = new int[left.length + right.length];
        int indexNew = 0;
        int indexLeft = 0;
        int indexRight = 0;

        while (indexNew < newArr.length) {
            System.out.println(Arrays.toString(newArr));
//            System.out.println("indexNew= " + indexNew + " indexLeft= " + indexLeft + " indexRight= " + indexRight);
            if (indexLeft == left.length) {
                newArr[indexNew] = right[indexRight];
                indexRight++;
            } else if (indexRight == right.length) {
                newArr[indexNew] = left[indexLeft];
                indexLeft++;
            } else {
                if (left[indexLeft] <= right[indexRight]) {
                    newArr[indexNew] = left[indexLeft];
                    indexLeft++;
                } else {
                    newArr[indexNew] = right[indexRight];
                    indexRight++;
                }
            }
            indexNew++;
        }
        return newArr;
    }
}
