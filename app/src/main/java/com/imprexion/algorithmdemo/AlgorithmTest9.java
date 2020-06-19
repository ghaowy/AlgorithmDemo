package com.imprexion.algorithmdemo;

import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest9 {

    public static void main(String[] args) {
        MyMinStack myMinStack = new MyMinStack();

        myMinStack.push(5);
        myMinStack.push(6);
        myMinStack.push(4);
        myMinStack.push(2);
        myMinStack.push(3);
        myMinStack.push(1);

        System.out.println("min= " + myMinStack.min);
        System.out.println("pop= " + myMinStack.pop());
        System.out.println("pop= " + myMinStack.pop());
        System.out.println("pop= " + myMinStack.pop());
        System.out.println("pop= " + myMinStack.pop());
        System.out.println("min= " + myMinStack.min());
        System.out.println("top= " + myMinStack.top());
    }


    static class MyMinStack {
        Stack<Integer> normalStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int min = Integer.MAX_VALUE;


        public void push(int node) {
            normalStack.push(node);
            if (min >= node) {
                minStack.push(node);
                min = node;
            }
        }

        public Integer pop() {
            if (minStack.peek() == normalStack.peek()) {
                minStack.pop();
                min = minStack.peek();
                return normalStack.pop();
            } else {
                return normalStack.pop();
            }
        }

        public int top() {
            return normalStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
