package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * 。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class AlgorithmTest39 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new int[]{1, 2, 3, 4, 5})));
    }


    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] B = new int[A.length];
        int length = B.length;
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        System.out.println(Arrays.toString(B));

        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                System.out.println("B的 第 " + i + "项 乘以A的第 " + j + "项");
                B[i] *= A[j];
            }
        }
        return B;
    }


}
