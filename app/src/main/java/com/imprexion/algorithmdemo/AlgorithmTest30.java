package com.imprexion.algorithmdemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class AlgorithmTest30 {

    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{10, 2, 3, 3, 8, 11, 2, 10}, new int[1], new int[1]);
    }


    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null) {
                return;
            }
            int length = array.length;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < length; i++) {
                if (hashMap.get(array[i]) == null) {
                    hashMap.put(array[i], i);
                } else {
                    hashMap.remove(array[i]);
                }
            }

            Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (count == 0) {
                    num1[0] = entry.getKey();
                } else {
                    num2[0] = entry.getKey();
                }
                count++;
        }
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }


}
