package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class AlgorithmTest54 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }


    /**
     * @param tokens string字符串一维数组
     * @return int整型
     */
    public static int evalRPN(String[] tokens) {
        // write code here
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        for (String value : tokens) {
            stack.push(value);
        }
        String value = null;
        while (!stack.isEmpty() || stack1.size() > 1) {
            if (value == null) {
                // 从栈中取出元素
                value = stack.pop();
                System.out.println("从栈中取出元素 " + value);
            }

            if ("*".equals(value) || "-".equals(value) || "+".equals(value) || "/".equals(value)) {
                System.out.println("stack1进栈  " + value);
                stack1.push(value);
                value = null;
            } else {
                String peek = stack1.peek();
                boolean b = "*".equals(peek) || "-".equals(peek) || "+".equals(peek) || "/".equals(peek);
                System.out.println("上一个节点是符号  " + b);
                if (b) {
                    System.out.println("stack1进栈  " + value);
                    stack1.push(value);
                    value = null;
                    continue;
                } else {
                    String fontValue = stack1.pop();
                    String fun = stack1.pop();
                    int result = 0;
                    if ("*".equals(fun)) {
                        result = Integer.parseInt(fontValue) * Integer.parseInt(value);
                    }

                    if ("+".equals(fun)) {
                        result = Integer.parseInt(fontValue) + Integer.parseInt(value);
                    }

                    if ("-".equals(fun)) {
                        result = Integer.parseInt(fontValue) - Integer.parseInt(value);
                    }

                    if ("/".equals(fun)) {
                        result = Integer.parseInt(fontValue) / Integer.parseInt(value);
                    }
                    System.out.println("执行运算  " + fontValue + fun + value + " = " + result);
                    value = String.valueOf(result);
                }
            }
        }
        return Integer.parseInt(value);
    }

}


