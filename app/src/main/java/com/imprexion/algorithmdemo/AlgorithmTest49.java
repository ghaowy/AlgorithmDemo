package com.imprexion.algorithmdemo;

import com.imprexion.tree.TreeNodeDemo.TreeNode;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class AlgorithmTest49 {

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


//        isSymmetrical(treeNode);
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right == null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            } else {
                if (isRight(pNode, pNode.next)) {
                    return null;
                } else {
                    return pNode.next.next;
                }
            }
        } else {
            return getLeftNode(pNode.right);
        }
    }

    private static boolean isRight(TreeLinkNode node, TreeLinkNode parentNode) {
        if (parentNode == null) {
            return false;
        }
        if (parentNode.next == null) {
            return parentNode.right == node;
        } else {
            return isRight(parentNode, parentNode.next);
        }


    }

    private static TreeLinkNode getLeftNode(TreeLinkNode right) {
        if (right.left == null) {
            return right;
        }

        return getLeftNode(right.left);
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}


