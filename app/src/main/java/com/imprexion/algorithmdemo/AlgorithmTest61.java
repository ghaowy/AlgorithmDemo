package com.imprexion.algorithmdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * 返回的结果为["cats and dog", "cat sand dog"].
 */
public class AlgorithmTest61 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("cat");
        strings.add("cats");
        strings.add("and");
        strings.add("sand");
        strings.add("dog");
        System.out.println(wordBreak("catsanddog", strings));
    }

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return breakHelper(s, dict, map);
    }

    public static ArrayList<String> breakHelper(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return new ArrayList<>();
        }

        if (map.get(s) != null) {
            return (ArrayList<String>) map.get(s);
        }

        if (dict.contains(s)) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(s);
            return strings;
        }

        // 确定字符串的长度
        ArrayList<String> strings = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 找到切字符串的位置
            String value = s.substring(0, i);
            // 字典中包含字符串则 递归 后面字符串
            if (dict.contains(value)) {
                StringBuilder stringBuilder = new StringBuilder();
                if (i != length - 1) {
                    List<String> child = breakHelper(s.substring(i), dict , map);
                    if (child.size() != 0) {
                        stringBuilder.append(value);
                        for (String data : child) {
                            stringBuilder.append(" ")
                                    .append(data);
                        }
                        strings.add(stringBuilder.toString());
                    }
                }
            }
        }
        map.put(s, strings);
        return strings;
    }
}


