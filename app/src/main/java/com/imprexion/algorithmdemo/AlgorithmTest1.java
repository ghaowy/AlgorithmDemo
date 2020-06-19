package com.imprexion.algorithmdemo;

import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/22 11:13
 * @desc : TODO
 */
public class AlgorithmTest1 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        push(5);
        push(7);
        push(2);

        System.out.println(pop());
        push(9);
        System.out.println(pop());
        push(6);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());

    }


    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}


