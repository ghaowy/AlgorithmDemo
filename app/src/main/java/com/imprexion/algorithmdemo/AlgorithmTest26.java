package com.imprexion.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 */
public class AlgorithmTest26 {


    public static void main(String[] args) {
//        coinChange(new int[]{1 , 2 , 5} , 11);
//        int minIndex = 11;
//        for (ArrayList<Integer> list : listAll) {
//            if (minIndex > list.size()) {
//                minIndex = list.size();
//            }
//        }
//        System.out.println(minIndex);
        coinChange(new int[]{1, 2, 5}, 11);
    }


    public static int coinChangeTwo(int[] coins, int amount) {
        return 0;
    }


    //----------------------------------------------------------------------------------------
    // 第一种思路 递归思想
    static List<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    static List<Integer> list = new ArrayList<>();

    public static List<ArrayList<Integer>> coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return listAll;
        }
        int length = coins.length;
        for (int i = 0; i < length; i++) {
            list.add(coins[i]);
            // 无解
            if (amount < coins[i]) {
                list.remove(list.size() - 1);
                continue;
            }
            if (amount == coins[i]) {
                listAll.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
                continue;
            }
            coinChange(coins, amount - coins[i]);
            list.remove(list.size() - 1);
        }
        int minIndex = amount;
        for (ArrayList<Integer> list : listAll) {
            if (minIndex > list.size()) {
                minIndex = list.size();
            }
        }
        return listAll;
    }

}
