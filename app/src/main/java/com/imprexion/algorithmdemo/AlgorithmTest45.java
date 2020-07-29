package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class AlgorithmTest45 {

    public static void main(String[] args) {


    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        midGet(pRoot, arrayList);
        return arrayList.get(k - 1);
    }

    public void midGet(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            midGet(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            midGet(node.right, list);
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}


