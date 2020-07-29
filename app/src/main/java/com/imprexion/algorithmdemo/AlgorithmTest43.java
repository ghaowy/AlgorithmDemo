package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class AlgorithmTest43 {

    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{10, 14, 12, 11}, 1));
    }


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int left = 0;
        int right = 0;
        int length = num.length;
        int max = num[left];
        while (right < length && left < length) {
            if (right >= left && right - left < size - 1) {
                max = Math.max(max, num[right]);
                right++;
            } else {
                System.out.println("left= " + left + " right= " + right);
                System.out.println("max= " + max);
                max = Math.max(max, num[right]);
                arrayList.add(max);
                left++;
                if (left < length) {
                    max = num[left];
                }
            }
        }
        return arrayList;
    }

}
