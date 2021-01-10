package com.wf.code.二叉树;

import sun.reflect.generics.tree.Tree;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {
        /*
         *        5
         *      3   8
         *    0   4
         * */
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = new TreeNode(4);
        System.out.println(lowestCommonAncestor(node1, node4, node3));
        System.out.println(lowestCommonAncestor1(node1, node3, node4));
        System.out.println(lowestCommonAncestor(node1, node4, null));
        System.out.println(lowestCommonAncestor1(node1, node4, node4));
    }

   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //如果一个 p挂载在q的下面  或者q挂载在p的下面  返回第一个找到的就行
        if (p == root || q == root) {
            return root;
        }
        //先去左子树找第一个能找到的
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //再去右子树找第一个能找到的
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    /****************************二叉树的最近公共祖先 二刷****************************/
    //(假设n1 n2要在这个树中)
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode n1,TreeNode n2){
        //整体思路就是先找到谁谁就是祖先，或者n1 n2的父节点就是祖先节点
        if (root==null) return null;
        if (root==n1 || root==n2) return root;
        if (root.left==n1 && root.right==n2) return root;
        if (root.left==n2 && root.right==n1) return root;
        TreeNode node = lowestCommonAncestor1(root.left, n1, n2);
        TreeNode node1 = lowestCommonAncestor1(root.right,n1,n2);
        if (node==null) {
            return node1;
        }else if (node1==null){
            return node;
        }else {
            return root;
        }
    }
}
