package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 求给定的二叉树的前序遍历
 * 用递归来解这道题太没有新意了，可以给出迭代的解法么？
 */
public class AlgorithmTest58 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        preorderTraversal(treeNode);
    }

    // 前序遍历树
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            arrayList.add(node.val);

            if (node.right != null) {
                treeNodes.push(node.right);
            }

            if (node.left != null) {
                treeNodes.push(node.left);
            }
        }

        return arrayList;
    }

    public static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


}


