package com.imprexion.algorithmdemo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest11 {

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
        PrintFromTopToBottom(treeNode);
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            if (node.left != null) {
                treeNodes.offer(node.left);
            }
            if (node.right != null) {
                treeNodes.offer(node.right);
            }
            arrayList.add(node.val);
        }
        return arrayList;
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
