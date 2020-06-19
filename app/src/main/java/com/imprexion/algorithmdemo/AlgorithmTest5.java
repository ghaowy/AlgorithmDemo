package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest5 {

    public static void main(String[] args) {
        reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        // 从后往前遍历
        for (int i = length - 1; i >= 0; i--) {
            // 当为基数时才需要比较计算上一个的位置
            int j = i;
            if ((array[i] % 2) != 0) {
                while (j > 0) {
                    j--;
                    // 找到前面第一个偶数 并与该数交换位置 结束循环
                    if ((array[j] % 2) == 0) {
                        int temp = array[j];
                        for (int k = j; k < i; k++) {
                            array[k] = array[k + 1];
                        }
                        array[i] = temp;
                        break;
                    }
                }
            }
        }


    }

    private static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


}
