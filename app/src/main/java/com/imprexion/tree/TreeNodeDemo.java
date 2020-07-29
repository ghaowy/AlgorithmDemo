package com.imprexion.tree;


import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author : gongh
 * @date : 2020/7/18 15:32
 * @desc : TODO
 */
public class TreeNodeDemo {

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
        sequenceShow(treeNode);
    }


    /**
     * 树的中序遍历非递归算法
     * 1、先将数的所有左节点入栈
     * 2、当节点为空则取出栈顶元素，并将当前节点指向栈顶元素右节点
     * 3、直到当前节点为空，且栈内元素为空
     *
     * @param node
     */
    public static void midShow(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = node;
        while (!nodeStack.empty() || currentNode != null) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode treeNode = nodeStack.pop();
                System.out.println("node= " + treeNode.val);
                currentNode = treeNode.right;
            }
        }
    }


    /**
     * 1、先将节点入栈
     * 2、当栈不为空时，取栈顶元素，先判断如果有右节点则将右节点入栈， 再判断左节点是否为空，不为空则左节点入栈
     * 3、直到遍历结束 栈内元素为空
     *
     * @param node
     */
    public static void fontShow(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = null;
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            currentNode = nodeStack.pop();
            System.out.println("node= " + currentNode.val);
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
    }

    /**
     * 1.根节点入栈
     * 2.将根节点的左子树入栈，直到最左，没有左孩子为止
     * 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右孩子，如果存在并且没有被访问(需要做一个标志 确定之前未访问过)，则将右孩子入栈，否则，就访问栈顶元素
     *
     * @param node
     */
    public static void afterOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = node;
        TreeNode pre = null;
        while (currentNode != null || !nodeStack.isEmpty()) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                // 查看栈顶元素并且遍历是否有右子树
                TreeNode peek = nodeStack.peek();
                if (peek.right == null || pre == peek.right) {
                    TreeNode treeNode = nodeStack.pop();
                    System.out.println("node= " + treeNode.val);
                    pre = treeNode;
                } else {
                    currentNode = peek.right;
                }
            }
        }
    }

    /**
     * 二叉树的层序遍历
     * 1、创建一个队列，将节点入队列
     * 2、从队头取出节点，当队头节点的左节点不为空则加入队列，队头节点的右节点不为空则加入队列
     * 3、直到队列元素为空
     *
     * @param node
     */
    public static void sequenceShow(TreeNode node) {
        if (node == null) {
            return;
        }
        ArrayDeque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.offer(node);
        while (!nodeDeque.isEmpty()) {
            TreeNode dequeFirst = nodeDeque.pollFirst();
            if (dequeFirst.left != null) {
                nodeDeque.offerLast(dequeFirst.left);
            }

            if (dequeFirst.right != null) {
                nodeDeque.offerLast(dequeFirst.right);
            }
            System.out.println("node= " + dequeFirst.val);
        }
    }

    public static class TreeNode {
        public int val = 0;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
