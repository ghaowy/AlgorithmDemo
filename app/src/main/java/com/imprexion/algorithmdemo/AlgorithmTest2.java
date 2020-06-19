package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO
 */
public class AlgorithmTest2 {

    public static void main(String[] args) {

    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;

        while (right > left) {
            int mid = (left + right) / 2;

            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }

            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }

            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return 0;
    }
}
