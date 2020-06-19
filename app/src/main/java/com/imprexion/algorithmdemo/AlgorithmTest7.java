package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest7 {

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

        Mirror(treeNode);
    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = null;
        // 左子树不为空
        if (root.left != null) {
            Mirror(root.left);
            temp = root.right;
            root.right = root.left;
            System.out.println((root.val) + " 的右儿子 = " + (root.left.val));
        }
        // 右子树不为空
        if (temp != null) {
            Mirror(temp);
            root.left = temp;
            System.out.println((root.val) + " 的左儿子 = " + (temp.val));
        }
    }


    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        TreeNode mainNode = root1;
        boolean result = false;
        // 先找到跟节点 判断跟节点是否与 子树跟节点一致
        if (mainNode.val == root2.val) {
            result = doesTree1hasTree2(mainNode, root2);
        }

        if (mainNode.left != null && !result) {
            result = HasSubtree(mainNode.left, root2);
        }

        if (mainNode.right != null && !result) {
            result = HasSubtree(mainNode.left, root2);
        }

        return result;
    }

    // 判断两颗字数是否完全包含
    private static boolean doesTree1hasTree2(TreeNode mainNode, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (mainNode == null) {
            return false;
        }

        if (mainNode.val != root2.val) {
            return false;
        }
        return doesTree1hasTree2(mainNode.left, root2.left) && doesTree1hasTree2(mainNode.right, root2.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }


        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

    }
}
