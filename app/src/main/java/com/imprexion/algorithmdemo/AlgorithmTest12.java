package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest12 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 9, 5, 16, 17, 15, 19, 18, 12};
//        TreeNode treeNode = VerifySquenceOfBST(arr);
//        treeNode.midShow();

        System.out.println(createBstTree(arr));
    }


    private static boolean createBstTree(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int length = sequence.length;
        int value = sequence[length - 1];
        // 找到左右子树的分界index
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (sequence[i] >= value) {
                index = i;
                break;
            }
        }

        for (int i = index; i < length - 1; i++) {
            if (value >= sequence[i]) {
                return false;
            }
        }
        boolean resultLeft = true;
        if (index != 0) {
            // 校验左子树
            resultLeft = createBstTree(Arrays.copyOfRange(sequence, 0, index));
        }
        boolean resultRight = true;
        if (index != length - 1) {
            // 校验右子树
            resultRight = createBstTree(Arrays.copyOfRange(sequence, index, length - 1));
        }

        return resultLeft && resultRight;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }


        public void midShow() {
            if (left != null) {
                left.midShow();
            }
            System.out.println(val);
            if (right != null) {
                right.midShow();
            }
        }
    }

}
