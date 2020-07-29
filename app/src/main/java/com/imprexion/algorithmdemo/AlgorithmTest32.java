package com.imprexion.algorithmdemo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class AlgorithmTest32 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(FindNumbersWithSum(arr, 15));
    }


    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = array.length;
        int total = 0;
        for (int i = 0; i < length; i++) {
            int value = array[i];
            if (map.get(sum - value) == null) {
                map.put(value, value);
            } else {
                if (total == 0) {
                    arrayList.add(Math.min(value, sum - value));
                    arrayList.add(Math.max(value, sum - value));
                    total = (value) * (sum - value);
                } else {
                    if (value * (sum - value) > total) {
                        continue;
                    } else {
                        total = value * (sum - value);
                        arrayList.clear();
                        arrayList.add(Math.min(value, sum - value));
                        arrayList.add(Math.max(value, sum - value));
                    }
                }
            }
        }
        return arrayList;
    }


}
