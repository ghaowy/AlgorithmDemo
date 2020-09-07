package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest_Max_Queqe {

    public static void main(String[] args) {
        MaxQueue myMinStack = new MaxQueue();

        myMinStack.push_back(5);
        myMinStack.push_back(6);
        myMinStack.push_back(4);
        myMinStack.push_back(2);
        myMinStack.push_back(3);
        myMinStack.push_back(1);

        System.out.println("min= " + myMinStack.max_value());
        System.out.println("pop= " + myMinStack.pop_front());
        System.out.println("pop= " + myMinStack.pop_front());
        System.out.println("pop= " + myMinStack.pop_front());
        System.out.println("pop= " + myMinStack.pop_front());
        System.out.println("min= " + myMinStack.max_value());
        System.out.println("top= " + myMinStack.pop_front());
    }


    static class MaxQueue {
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> mQueue = new ArrayDeque<>();

        public MaxQueue() {

        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.getFirst();
        }

        public void push_back(int value) {
            while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
                maxQueue.removeLast();
            }
            maxQueue.add(value);
            mQueue.offer(value);
        }

        public int pop_front() {
            if (mQueue.isEmpty()) {
                return -1;
            }
            Integer pop = mQueue.pop();
            if (!maxQueue.isEmpty() && maxQueue.peekFirst().equals(pop)) {
                maxQueue.removeFirst();
            }
            return pop;
        }
    }

}
