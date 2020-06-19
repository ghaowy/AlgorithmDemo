package com.imprexion.algorithmdemo;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc :
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class AlgorithmTest16 {

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }


    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        PermutationHelper(0, chars);
        Collections.sort(listAll);
        return listAll;
    }


    public static void PermutationHelper(int index, char[] chars) {
        if (index < 0 || index > chars.length) {
            return;
        }

        int length = chars.length;
        if (index == length - 1) {
            if (!listAll.contains(chars.toString())) {
                listAll.add(String.valueOf(chars));
            }
        } else {
            for (int i = index; i < length; i++) {
                swap(chars, index, i);
                PermutationHelper(index + 1, chars);
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] chars, int index, int i) {
        if (chars == null || index < 0 || index >= chars.length || i < 0 || i >= chars.length) {
            return;
        }

        char tmp = chars[index];
        chars[index] = chars[i];
        chars[i] = tmp;
    }


    //-----------------------------------------------------------------------------------------------
    static ArrayList<String> listAll = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    public static void createTree(int index, char[] chars) {
        if (index < 0 || index >= chars.length) {
            return;
        }
        sb.append(chars[index]);
        if (chars.length == 1) {
            if (!listAll.contains(sb.toString())) {
                listAll.add(sb.toString());
            }
            return;
        }
        char[] newChar = new char[chars.length - 1];
        for (int i = 0; i < chars.length; i++) {
            if (index == i) {
                continue;
            } else if (index > i) {
                newChar[i] = chars[i];
            } else {
                newChar[i - 1] = chars[i];
            }
        }
        int index1 = 0;
        while (index1 < newChar.length) {
            createTree(index1, newChar);
            sb.setLength(sb.length() - 1);
            index1++;
        }
    }


}
