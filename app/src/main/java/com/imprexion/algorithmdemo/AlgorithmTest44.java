package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */
public class AlgorithmTest44 {

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());

    }

    static int[] array;
    static int currentIndex = 0;

    public static void Insert(Integer num) {
        if (array == null) {
            array = new int[10];
        }
        if (currentIndex >= array.length) {
            // 每次扩容一倍
            int[] newArray = new int[2 * array.length];
            int length = array.length;
            for (int i = 0; i < length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        // 采用插入排序的方式 将 元素放进数组
        int index = 0;
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (num < array[i]) {
                array[i + 1] = array[i];
            } else {
                index = i + 1;
                break;
            }
        }
        array[index] = num;
        currentIndex++;
        System.out.println("currentIndex= " + currentIndex);
        System.out.println(Arrays.toString(array));
    }

    public static Double GetMedian() {
        if (currentIndex % 2 == 0) {
            return (array[currentIndex / 2] + array[(currentIndex / 2) - 1]) / 2d;
        }
        return array[currentIndex / 2] * 1d;

    }


}
