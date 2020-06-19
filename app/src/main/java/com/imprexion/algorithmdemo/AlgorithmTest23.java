package com.imprexion.algorithmdemo;

import android.text.TextUtils;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
    如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class AlgorithmTest23 {


    public static void main(String[] args) {

    }

    public int FirstNotRepeatingChar(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int[] arr = new int[58];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int index = str.charAt(i) - 65;
            arr[index] = arr[index] + 1;
        }

        for (int i = 0; i < length; i++) {
            if (arr[str.charAt(i) - 65] == 1 && (str.charAt(i) - 65) < 26 && (str.charAt(i) - 65) > 31) {
                return i;
            }
        }

        return -1;
    }

}
