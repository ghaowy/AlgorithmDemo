package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest13 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(9);
        treeNode2.left = treeNode3;
        treeNode2.right = new TreeNode(11);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode3.left = new TreeNode(2);

        System.out.println(FindPath(treeNode, 29));
    }


    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        if (root.val - target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }

        FindPath(root.left, target - root.val);
        FindPath(root.right, target - root.val);
        list.remove(list.size() - 1);

        return listAll;
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
