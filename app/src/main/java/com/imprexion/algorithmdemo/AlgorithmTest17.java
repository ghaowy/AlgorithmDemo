package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc :链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?f=discussion
 * 来源：牛客网
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class AlgorithmTest17 {

    public static void main(String[] args) {

    }


    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int value = 0;

        int times = 0;

        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (times == 0) {
                value = array[i];
                times++;
            } else {
                if (array[i] == value) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        if (times > 0) {
            times = 0;
            for (int i = 0; i < length; i++) {
                if (value == array[i]) {
                    times++;
                }
            }
        }
        if (times > array.length / 2) {
            return value;
        } else {
            return 0;
        }

    }


}
