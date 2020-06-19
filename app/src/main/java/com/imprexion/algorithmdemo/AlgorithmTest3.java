package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO
 */
public class AlgorithmTest3 {

    private static int ways;

    public static void main(String[] args) {
        System.out.println(" target= " + JumpFloorII(5));
    }


    public static int JumpFloorII(int target) {
        ways = 0;
        createTree(target);
        return ways;
    }


    public static void createTree(int target) {
        if (target == 0) {
            ways++;
            return;
        }

        while (target > 0) {
            createTree(target - 1);
            target--;
        }
    }

    // 计算第n项的值
    public static int JumpF(int target) {
        int originalTarget = target;

        if (target == 1) {
            System.out.println("JumpF target= " + target + " sumWay= " + 1);
            return 1;
        }

        if (target == 2) {
            System.out.println("JumpF target= " + target + " sumWay= " + 2);
            return 2;
        }

        int sumWay = 0;
        int lastWayOne = 2;
        int lastWayTwo = 1;
        while (target > 2) {
            sumWay = lastWayTwo + lastWayOne;
            lastWayTwo = lastWayOne;
            lastWayOne = sumWay;
            target--;
        }

        System.out.println("JumpF target= " + originalTarget + " sumWay= " + (sumWay));
        return sumWay;
    }
}
