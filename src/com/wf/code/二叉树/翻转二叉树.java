package com.wf.code.二叉树;

import java.util.LinkedList;
import java.util.Queue;

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
        flipTreeNode1(node1);
        System.out.println("*******************翻转后*******************");
        TreeNode.print(node1);
    }
    //递归版本实现
    public static void flipTreeNode(TreeNode root){
        if (root==null) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        flipTreeNode(root.left);
        flipTreeNode(root.right);
    }

    //非递归版本，也就是借鉴层序遍历
    public static void flipTreeNode1(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            change(node);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }

    public static void change(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
