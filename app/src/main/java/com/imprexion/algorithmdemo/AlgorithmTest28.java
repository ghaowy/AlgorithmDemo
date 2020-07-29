package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 *
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class AlgorithmTest28 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(10);
        treeNode2.left = new TreeNode(9);
        treeNode2.right = new TreeNode(11);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        System.out.println(TreeDepth(treeNode));
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
