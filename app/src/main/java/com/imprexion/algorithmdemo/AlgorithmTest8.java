package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest8 {

    public static void main(String[] args) {
        int[][] arr = {{1}, {2}, {3}, {4}};
        printMatrix(arr);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return null;
        }
        int column = matrix[0].length;
        //列
        int line = matrix.length;
        if (column == 0 && line == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (line == 1) {
            for (int i = 0; i < column; i++) {
                arrayList.add(matrix[0][i]);
            }
            System.out.println(arrayList);
            return arrayList;
        }

        if (column == 1) {
            for (int i = 0; i < line; i++) {
                arrayList.add(matrix[i][0]);
            }
            System.out.println(arrayList);
            return arrayList;
        }

        int left = 0;
        int top = 0;
        int right = column - 1;
        int bottom = line - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                arrayList.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                arrayList.add(matrix[i][right]);
            }

            for (int i = right - 1; i >= left; i--) {
                arrayList.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; i > top; i--) {
                arrayList.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        System.out.println(arrayList);
        return arrayList;
    }
}
