package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class AlgorithmTest53 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{new int[]{1, 3, 1,2}, new int[]{1, 5, 1,4}, new int[]{4, 2, 1,6}}));
    }


    /**
     * 解题思路， 从n-1，m-1 位置开始遍历，保存到 该顶点 最短距离
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }


        int cols = grid.length;
        // 总的列数
        int rows = grid[0].length;
        int[][] result = new int[cols][rows];
        int col = grid.length - 1;
        int row = grid[0].length - 1;
        // 总的行数

        // 当还在矩阵范围内；
        while (col >= 0 && row >= 0) {
            int tmp = grid[col][row];
            if (col + 1 < cols) {
                tmp = grid[col][row] + result[col + 1][row];
            }
            if (row + 1 < rows) {
                if (tmp == grid[col][row]) {
                    tmp = grid[col][row] + result[col][row + 1];
                } else {
                    tmp = Math.min(tmp, grid[col][row] + result[col][row + 1]);
                }
            }
            result[col][row] = tmp;
            if (row == 0 && col != 0) {
                col--;
                row = rows - 1;
            } else {
                row--;
            }
        }

        return result[0][0];
    }


    public static int pathSum(int col, int row, int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 总的行数
        int cols = grid.length;
        // 总的列数
        int rows = grid[0].length;

        if (col == cols - 1 && row == rows - 1) {
            return grid[col][row];
        }

        int resultCol = 0;
        if (col + 1 < cols) {
            resultCol = grid[col][row] + pathSum(col + 1, row, grid);
        }
        int resultRow = 0;
        if (row + 1 < rows) {
            resultRow = grid[col][row] + pathSum(col, row + 1, grid);
        }
//        System.out.println("col= " + col + " row= " + row + " result= " + Math.min(resultCol, resultRow));

        int result = 0;
        if (resultRow > 0 && resultCol > 0) {
            result = Math.min(resultCol, resultRow);
        } else {
            result = Math.max(resultCol, resultRow);
        }

        System.out.println("col= " + col + " row= " + row + " result= " + result);
        return result;

    }

}


