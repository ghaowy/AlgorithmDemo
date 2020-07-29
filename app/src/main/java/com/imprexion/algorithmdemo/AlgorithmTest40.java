package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class AlgorithmTest40 {

    public static void main(String[] args) {
        System.out.println(match(new char[]{'a', 'b', 'b', 'a'}, new char[]{'a', 'b', '*', 'a'}));
    }


    public static boolean match(char[] str, char[] pattern) {
        if (pattern == null || pattern.length == 0) {
            return true;
        }
        if (pattern.length > 2 && pattern[1] == '*') {
            return match(str, Arrays.copyOfRange(pattern, 1, pattern.length));
        }
        if (str == null || str.length == 0) {
            return false;
        }
        int length = str.length;
        int patternIndex = 0;
        int length1 = pattern.length;
        boolean result = false;
        int index = 0;
        while (index < length) {
            System.out.println("匹配 " + str[index] + " 模板 " + pattern[patternIndex]);
            if (str[index] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                patternIndex++;
                index++;
            } else if (pattern[patternIndex + 1] == '*') {
                patternIndex = patternIndex + 2;
            } else if (pattern[patternIndex] == '*') {
                if (patternIndex - 1 >= 0) {
                    if (str[index] != pattern[patternIndex - 1] && pattern[patternIndex - 1] != '.') {
                        // pattern 索引前进一次
                        patternIndex++;
                    } else {
                        index++;
                    }
                } else {
                    patternIndex = 0;
                    index++;
                }
            } else {
                patternIndex = 0;
                index++;
            }
        }
        if (patternIndex == length1) {
            result = true;
        }
        return result;
    }

}
