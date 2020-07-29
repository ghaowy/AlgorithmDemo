package com.imprexion.algorithmdemo;

import com.imprexion.tree.TreeNodeDemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class AlgorithmTest46 {

    public static void main(String[] args) {
        TreeNodeDemo.TreeNode treeNode = new TreeNodeDemo.TreeNode(8);
        TreeNodeDemo.TreeNode treeNode1 = new TreeNodeDemo.TreeNode(6);
        treeNode1.left = new TreeNodeDemo.TreeNode(5);
        treeNode1.right = new TreeNodeDemo.TreeNode(7);
        TreeNodeDemo.TreeNode treeNode2 = new TreeNodeDemo.TreeNode(10);
        treeNode2.left = new TreeNodeDemo.TreeNode(9);
        treeNode2.right = new TreeNodeDemo.TreeNode(11);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        Print(treeNode);
    }

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();


    static ArrayList<ArrayList<Integer>> Print(TreeNodeDemo.TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        System.out.println(list);
        return list;
    }

    private static void depth(TreeNodeDemo.TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;
        if (depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth - 1).add(root.val);
        System.out.println(list);
        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }

}


