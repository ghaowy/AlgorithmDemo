package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class AlgorithmTest37 {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }

    public static int Sum_Solution(int n) {
        int sum = 0;
        boolean result = (n > 0) && (sum = (n + Sum_Solution(n - 1))) > 0;
        return sum;
    }


}
