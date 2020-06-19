package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class AlgorithmTest21 {

    static int min = -1;
    static StringBuilder mBuilder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(PrintMinNumberTwo(new int[]{30, 35, 311}));
    }


    public static String PrintMinNumberTwo(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                builder.setLength(0);
                Integer integer1 = Integer.parseInt(builder.append(numbers[i]).append(numbers[j]).toString());
                builder.setLength(0);
                Integer integer2 = Integer.parseInt(builder.append(numbers[j]).append(numbers[i]).toString());
                if (integer1 > integer2) {
                    swap(i, j, numbers);
                }
            }
            builder1.append(numbers[i]);
        }

        return builder1.toString();
    }


    //----------------------------------------------------------------------------------------------------------
    public static String PrintMinNumberOne(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        printAllNumber(0, numbers);

        return String.valueOf(min);
    }

    public static void printAllNumber(int index, int[] arr) {
        if (arr == null || index < 0 || index >= arr.length) {
            return;
        }
        if (index == arr.length - 1) {
            int i = 0;
            while (i < arr.length) {
                mBuilder.append(arr[i]);
                i++;
            }
            if (min == -1) {
                min = Integer.parseInt(mBuilder.toString());
            } else {
                min = Math.min(Integer.parseInt(mBuilder.toString()), min);
            }
            mBuilder.setLength(0);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            printAllNumber(index + 1, arr);
            swap(i, index, arr);
        }
    }

    public static void swap(int i, int j, int[] arr) {
        if (arr == null) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
