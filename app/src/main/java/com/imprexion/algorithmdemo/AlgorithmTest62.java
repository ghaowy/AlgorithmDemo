package com.imprexion.algorithmdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 */
public class AlgorithmTest62 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("aaaa");
        strings.add("aa");
        System.out.println(wordBreak("aaaaaaa", strings));
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        return breakHelper(s, dict);
    }

    public static boolean breakHelper(String s, Set<String> dict) {
        System.out.println(s);
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return false;
        }

        if (dict.contains(s)) {
            return true;
        }

        // 确定字符串的长度
        int length = s.length();
        for (int i = 0; i <= length; i++) {
            // 找到切字符串的位置
            String value = s.substring(0, i);
            // 字典中包含字符串则 递归 后面字符串
            if (dict.contains(value)) {
                if (i == length) {
                    return true;
                } else {
                    return breakHelper(s.substring(i), dict);
                }
            }
        }
        return false;
    }
}


