package com.imprexion.algorithmdemo;

import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest10 {

    public static void main(String[] args) {
        System.out.println("IsPopOrder= " + IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    // 采用一个辅助栈实现
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int popIndex = 0;

        while (i < pushA.length) {
            int value = pushA[i];
            if (popA[popIndex] != value) {
                stack.push(value);
            } else {
                popIndex++;
            }
            i++;
        }

        for (int j = popIndex; j < popA.length; j++) {
            if (popA[j] == stack.pop()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
