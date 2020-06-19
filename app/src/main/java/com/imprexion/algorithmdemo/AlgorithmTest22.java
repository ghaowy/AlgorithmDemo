package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class AlgorithmTest22 {


    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }

    public static int GetUglyNumber_Solution(int index) {
        int[] arr = new int[index];
        arr[0] = 1;
        int currentIndex = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        int minValue = 0;

        while (currentIndex < index) {
            int value1 = arr[index1] * 2;
            int value2 = arr[index2] * 3;
            int value3 = arr[index3] * 5;

            minValue = Math.min(value1, Math.min(value2, value3));
            if (value1 == minValue) index1++;
            if (value2 == minValue) index2++;
            if (value3 == minValue) index3++;
            arr[currentIndex] = minValue;
            currentIndex++;
        }
        return arr[currentIndex - 1];
    }

}
