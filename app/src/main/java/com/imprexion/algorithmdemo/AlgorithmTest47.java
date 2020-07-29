package com.imprexion.algorithmdemo;

import com.imprexion.tree.TreeNodeDemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class AlgorithmTest47 {

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


    /**
     * 采用两个栈实现
     *
     * @param pRoot
     * @return
     */
    static ArrayList<ArrayList<Integer>> Print(TreeNodeDemo.TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        int layer = 1;
        Deque<TreeNodeDemo.TreeNode> oddDeque = new ArrayDeque<>();
        Stack<TreeNodeDemo.TreeNode> evenStack = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        oddDeque.offer(pRoot);
        while (!oddDeque.isEmpty() || !evenStack.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!oddDeque.isEmpty()) {
                    TreeNodeDemo.TreeNode node = oddDeque.pollFirst();
                    if (node.left != null) {
                        evenStack.push(node.left);
                    }
                    if (node.right != null) {
                        evenStack.push(node.right);
                    }
                    arrayList.add(node.val);
                }
                System.out.println("-----------------------------------------");
                System.out.println("evenStack " + evenStack);
                System.out.println("oddDeque " + oddDeque);
                System.out.println("-----------------------------------------");
                if (arrayList.size() > 0) {
                    list.add(arrayList);
                    layer++;
                }
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!evenStack.isEmpty()) {
                    TreeNodeDemo.TreeNode node = evenStack.pop();
                    if (node.right != null) {
                        oddDeque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        oddDeque.offerFirst(node.left);
                    }
                    arrayList.add(node.val);
                }

                System.out.println("-----------------------------------------");
                System.out.println("evenStack " + evenStack);
                System.out.println("oddDeque " + oddDeque);
                System.out.println("-----------------------------------------");

                if (arrayList.size() > 0) {
                    list.add(arrayList);
                    layer++;
                }
            }
        }
        System.out.println(list);
        return list;
    }


}


