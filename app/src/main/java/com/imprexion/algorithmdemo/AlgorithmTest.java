package com.imprexion.algorithmdemo;

import java.util.Arrays;

/**
 * @author : gongh
 * @date : 2020/5/22 11:13
 * @desc : TODO
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0 || pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        int length = in.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        // 证明存在左子树
        if (index > 0) {
            // 分割左子树位置
            root.left = new TreeNode(pre[1]);
            reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        }
        // 证明存在右子树
        if (index < in.length - 1) {
            root.right = new TreeNode(index + 1);
            reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        }

//        root.subsequece();
        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void subsequece() {
            subsequenceNode(this);
        }

        private void subsequenceNode(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                subsequenceNode(node.left);
            }

            if (node.right != null) {
                subsequenceNode(node.right);
            }
            System.out.println(node.val);
        }
    }
}


