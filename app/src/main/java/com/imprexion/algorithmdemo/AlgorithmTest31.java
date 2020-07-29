package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class AlgorithmTest31 {

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }


    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList listAll = new ArrayList<ArrayList<Integer>>();
        if (sum == 0) {
            return listAll;
        }

        int left = 1;
        int right = 1;
        while (right < sum) {
            int sumTmp = 0;
            for (int i = left; i <= right; i++) {
                sumTmp += i;
            }

            if (sumTmp < sum) {
                right++;
                continue;
            }

            if (sumTmp > sum) {
                left++;
                continue;
            }

            if (sumTmp == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    arrayList.add(i);
                }
                listAll.add(arrayList);
                left++;
            }
        }
        return listAll;

    }


}
