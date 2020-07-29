package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class AlgorithmTest42 {

    public static void main(String[] args) {
        System.out.println(movingCount(15, 20, 20));
    }


    /**
     * 分析， 建立一个 【mxn】的二维数组， 当数组中元素为 1的时候表示 可以进入， 当数组元素为 2的时候 表示不可以进入
     * 当值不为0的时候 表示该空格已经访问过
     * 在每一个空格中都能左上右下移动
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] results = new boolean[rows][cols];

        // 定义一个result标志 该格子是否已访问过
        results[0][0] = true;
        // 定义一个数值记录可到达的格子数
        moveTo(0, 0, results, threshold);
        return count;
    }


    public static void moveTo(int col, int row, boolean[][] result, int threshold) {
        int sum = getSumOfValue(col) + getSumOfValue(row);
        int rows = result[0].length;
        int cols = result.length;
        result[col][row] = true;
        if (sum > threshold) {
            return;
        }
        count++;
        if (col - 1 >= 0 && !result[col - 1][row]) {
            moveTo(col - 1, row, result, threshold);
        }
        if (col + 1 < cols && !result[col + 1][row]) {
            moveTo(col + 1, row, result, threshold);
        }
        if (row - 1 >= 0 && !result[col][row - 1]) {
            moveTo(col, row - 1, result, threshold);
        }
        if (row + 1 < rows && !result[col][row + 1]) {
            moveTo(col, row + 1, result, threshold);
        }
    }

    private static int getSumOfValue(int value) {
        int dividend = 10;
        while (value / dividend > 0) {
            dividend *= 10;
        }

        // 被除数
        dividend = dividend / 10;

        int currentValue = value;

        int sum = 0;
        while (dividend >= 1) {
            sum += currentValue / dividend;
            currentValue = currentValue % dividend;
            dividend /= 10;
        }
        return sum;
    }

}
