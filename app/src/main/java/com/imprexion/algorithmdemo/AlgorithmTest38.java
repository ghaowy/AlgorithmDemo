package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class AlgorithmTest38 {

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, new int[1]));
    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        duplication[0] = -1;

        int index = 0;

        while (index <= length - 1) {
            int value = numbers[index];
            if (index != value) {
                if (numbers[value] != value) {
                    swap(numbers, index, value);
                } else {
                    duplication[0] = value;
                    break;
                }
            } else {
                index++;
            }
        }

        System.out.println("value= " + duplication[0]);

        if (duplication[0] != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void swap(int[] arr, int index, int index1) {
        int tmp = arr[index];
        arr[index] = arr[index1];
        arr[index1] = tmp;
    }


}
