package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2 ;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        TreeNode.print(node1);
        flipTreeNode(node1);
        System.out.println("*******************翻转后*******************");
        TreeNode.print(node1);
    }
    public static void flipTreeNode(TreeNode root){
        if (root==null) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        flipTreeNode(root.left);
        flipTreeNode(root.right);
    }
}
