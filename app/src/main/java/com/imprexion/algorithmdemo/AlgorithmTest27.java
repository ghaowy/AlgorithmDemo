package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 */
public class AlgorithmTest27 {


    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3));
    }


    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int start = 0;
        int end = array.length;
        int mid = 0;
        int lastIndex = 0;
        int endIndex = array.length;
        while (start < end) {
            mid = (start + end) / 2;
            if (array[mid] == k) {
                break;
            } else if (array[mid] > k) {
                end = mid;
            } else if (array[mid] < k) {
                start = mid + 1;
            }
        }

        if (start == end) {
            return 0;
        }

        for (int i = mid; i >= 0; i--) {
            if (array[i] != k) {
                lastIndex = i + 1;
                break;
            }
        }

        for (int i = mid; i < array.length; i++) {
            if (array[i] != k) {
                endIndex = i;
                break;
            }
        }

        return endIndex - lastIndex;
    }
}
