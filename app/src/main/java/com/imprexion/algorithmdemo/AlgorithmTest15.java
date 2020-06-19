package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest15 {

    public static void main(String[] args) {

    }

    public static TreeNode realHead;
    public static TreeNode preNode;


    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        midShow(pRootOfTree);
        return realHead;
    }


    public static void midShow(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            midShow(node.left);
        }
        if (preNode == null) {
            realHead = node;
            preNode = node;
        } else {
            preNode.right = node;
            node.left = preNode;
            node = preNode;
        }
        if (node.right != null) {
            midShow(node.right);
        }
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
