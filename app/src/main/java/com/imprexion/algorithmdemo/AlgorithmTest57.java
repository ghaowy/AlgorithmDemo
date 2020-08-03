package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 */
public class AlgorithmTest57 {
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

        postorderTraversal(treeNode);
    }


    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write code here
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        /**
         * 定义 currentNode = root
         * 将currentNode 入栈 ，并且currentNode 指向其左子节点
         * 直到currentNode = null
         * 查看栈顶元素 右子节点是否为null
         * null 则出栈
         * 不为null 则 将右子节点赋值为 currentNode
         */
        TreeNode currentNode = root;
        TreeNode preNode = null;
        while (currentNode != null || !treeNodes.isEmpty()) {
            System.out.println("节点 " + (currentNode == null ? "null" : currentNode.val));
            if (currentNode != null) {
                treeNodes.push(currentNode);
                System.out.println("进栈  " + currentNode.val);
                currentNode = currentNode.left;
            } else {
                TreeNode node = treeNodes.peek();
                System.out.println("取出 " + (node == null ? "null" : node.val));
                if (node.right != null && preNode != node.right) {
                    currentNode = node.right;
                } else {
                    TreeNode pop = treeNodes.pop();
                    System.out.println("出栈  " + pop.val);
                    preNode = pop;
                    arrayList.add(pop.val);
                }
            }
        }

        System.out.println(arrayList);
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


