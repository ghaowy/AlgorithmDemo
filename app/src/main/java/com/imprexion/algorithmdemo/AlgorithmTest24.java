package com.imprexion.algorithmdemo;

import java.util.HashMap;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class AlgorithmTest24 {


    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int count = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }

        HashMap hashMap = new HashMap();
        hashMap.put("" , "");
        hashMap.get("key");


        return count % 1000000007;

    }

}
