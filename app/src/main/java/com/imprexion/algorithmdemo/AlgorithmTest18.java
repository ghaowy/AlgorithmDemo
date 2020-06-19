package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc :链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?f=discussion
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class AlgorithmTest18 {

    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8} , 4));
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> minValue = new ArrayList<>();
//        int[] minValue = new int[k];
        int length = input.length;
        for (int i = 0; i < length; i++) {
            if (i >= k) {
                compareAndSaveMinValue(input[i], minValue);
            } else {
                minValue.add(input[i]);
//                minValue[i] = input[i];
            }
        }
        return minValue;
    }

    private static void compareAndSaveMinValue(int value, ArrayList<Integer> minValue) {
        if (minValue == null || minValue.size() <= 0) {
            return;
        }
        int length = minValue.size();

        int maxIndex = 0;
        int maxValue = minValue.get(0);
        for (int j = 1; j < length; j++) {
            if (maxValue < minValue.get(j)) {
                maxValue = minValue.get(j);
                maxIndex = j;
            }
        }

        if (value < minValue.get(maxIndex)) {
            minValue.set(maxIndex, value);
        }

    }


}
