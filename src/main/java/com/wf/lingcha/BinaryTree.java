package com.wf.lingcha;

import com.wf.code.二叉树.TreeNode;

//二叉树相关问题
public class BinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = BinaryTree.DeepTree(root);
        
        System.out.println("二叉树的最大深度为: " + depth); // 输出：3
    }

    public static int DeepTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = DeepTree(root.left);
        int rightDeep = DeepTree(root.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
