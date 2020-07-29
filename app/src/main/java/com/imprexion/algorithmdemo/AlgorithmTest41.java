package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 */
public class AlgorithmTest41 {

    public static void main(String[] args) {
        System.out.println(cutRope(15));
    }


    /**
     * 定义 f（n） 为最长度为n的绳子的最大乘积
     * 假设切了一刀 i 则 f（n） = max{f（n-i） * f（i）}
     * 则 n-i 必须为最优解 才满足条件
     *
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        if (target == 0) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        if (target == 2) {
            return 1;
        }

        if (target == 3) {
            return 2;
        }
        int[] multi = new int[target + 1];
        multi[0] = 0;
        multi[1] = 1;
        multi[2] = 2;
        multi[3] = 3;
        for (int i = 4; i <= target; i++) {
            int max = multi[0];
            for (int j = 0; j <= i / 2; j++) {
                max = Math.max(max, multi[j] * multi[i - j]);
            }
            multi[i] = max;
        }

        return multi[target];
    }

}
