package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class AlgorithmTest34 {

    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }


    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        // 翻转整个语句
        int length = str.length();
        ReverseWord(chars, 0, length - 1);
        System.out.println(String.valueOf(chars));
        int left = 0;
        int right = 0;

        while (left < length) {
            System.out.println("left= " + left);
            for (int i = left; i < length; i++) {
                if (chars[i] == ' ') {
                    right = i - 1;
                    ReverseWord(chars, left, right);
                    left = i + 1;
                    break;
                }


                if (i == length - 1) {
                    right = length - 1;
                    ReverseWord(chars, left, right);
                    left = i + 1;
                }
            }
        }
        return String.valueOf(chars);
    }


    public static void ReverseWord(char[] str, int startIndex, int endIndex) {
        if (str == null || startIndex >= endIndex) {
            return;
        }

        System.out.println("-------------------------------------------");
        System.out.println(Arrays.toString(str));
        System.out.println("startIndex= " + startIndex + " endIndex= " + endIndex);

        while (startIndex < endIndex) {
            swap(str, startIndex++, endIndex--);
        }
        System.out.println(Arrays.toString(str));
        System.out.println("-------------------------------------------");
    }

    private static void swap(char[] str, int index, int index1) {
        char tmp = str[index];
        str[index] = str[index1];
        str[index1] = tmp;
    }


}
