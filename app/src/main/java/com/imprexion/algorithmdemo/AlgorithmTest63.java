package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * <p>
 * <p>
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AlgorithmTest63 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{3, 0, 1, 4, 2}, new int[]{5, 6, 3, 2, 1}, new int[]{1, 2, 0, 1, 5}, new int[]{4, 1, 0, 1, 7}, new int[]{1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(2, 1, 4, 3);
        System.out.println(param_1);
    }

    static class NumMatrix {
        int[][] dp = null;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            // 列
            int row = matrix[0].length;
            // 行
            int col = matrix.length;

            dp = new int[col][row];
            dp[0][0] = matrix[0][0];
            for (int i = 0; i < col; i++) {

                for (int j = 0; j < row; j++) {
                    if (i == 0 && j - 1 >= 0) {
                        dp[0][j] = dp[0][j - 1] + matrix[0][j];
                    }

                    if (j == 0 && i - 1 >= 0) {
                        dp[i][0] = dp[i - 1][0] + matrix[i][0];
                    }

                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < col; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return dp[row2][col2];
            }
            if (col1 == 0) {
                return dp[row2][col2] - dp[row1 - 1][col2];
            } else if (row1 == 0) {
                return dp[row2][col2] - dp[row2][col1 - 1];
            } else {
                return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
            }
        }
    }
}


