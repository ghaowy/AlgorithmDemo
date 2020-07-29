package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class AlgorithmTest52 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');

        System.out.println(FirstAppearingOnce());
    }


    public static void Insert(char ch) {

        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
        }
        if (arrayDeque.contains(ch)) {
            arrayDeque.remove(ch);
        } else {
            arrayDeque.offerLast(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        if (arrayDeque == null) {
            return '#';
        } else {
            Character character = arrayDeque.pollFirst();
            if (character == null) {
                return '#';
            }
            return character;
        }
    }


}


