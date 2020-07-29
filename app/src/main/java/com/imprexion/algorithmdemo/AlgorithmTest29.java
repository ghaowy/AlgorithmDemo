package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class AlgorithmTest29 {

    public static void main(String[] args) {

    }


    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) < 2;
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDeep = 0;
        int rightDeep = 0;
        if (root.left != null) {
            leftDeep = TreeDepth(root.left);
        }
        if (root.right != null) {
            rightDeep = TreeDepth(root.right);
        }

        return 1 + Math.max(leftDeep, rightDeep);
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
