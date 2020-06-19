package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest4 {

    public static void main(String[] args) {
        System.out.println("getValueCode= " + (getValueCode(-3)));

    }

    public static int getValueCode(int value) {
//        int count = 0;
//        int flag = 1;
//        while (value != 0) {
//            if ((value & flag) == 1) {
//                count++;
//            }
//            value = value >> 1;
//        }
//        return count;

        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((value & flag) != 0) {
                System.out.println("(value & flag) = " + ((value & flag)));
                count++;
            }
            flag = flag << 1;
            System.out.println("flag= " + flag);
        }

        return count;
    }


}
