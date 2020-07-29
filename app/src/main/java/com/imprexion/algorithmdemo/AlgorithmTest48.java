package com.imprexion.algorithmdemo;

import com.imprexion.tree.TreeNodeDemo.TreeNode;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */
public class AlgorithmTest48 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(6);
        treeNode2.left = new TreeNode(5);
        treeNode2.right = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        System.out.println(isSymmetrical(treeNode));
//        isSymmetrical(treeNode);
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }


    static boolean isSymmetrical(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null ^ nodeRight == null) {
            return false;
        }

        if (nodeLeft == null) {
            return true;
        }

        if (nodeLeft.val != nodeRight.val) {
            return false;
        }

        return isSymmetrical(nodeLeft.left, nodeRight.left) && isSymmetrical(nodeLeft.right, nodeRight.right);

    }
}


