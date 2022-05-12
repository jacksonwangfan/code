package com.wf.code.二叉树.二刷;

import com.wf.code.二叉树.TreeNode;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉搜索树的最近公共祖先 {

    /*
     *           5
     *       3       8
     *    0      4
     * */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node0;
        node2.right = node4;

        System.out.println(lowestCommonAncestor(node1, node4, node3));
        System.out.println(lowestCommonAncestor(node1, node3, node4));

    }

    //二刷
    //说明:
    //所有节点的值都是唯一的。
    //p、q 为不同节点且均存在于给定的二叉搜索树中。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
      if (root == null) return  null;
      if (root.val == left.val) return left;
      if (root.val == right.val) return right;
      if (left.val < root.val && right.val > root.val) {
          return root;
      }
      if (left.val < root.val && right.val < root.val) {
          return lowestCommonAncestor(root.left, left, right);
      } else {
          return lowestCommonAncestor(root.right, left, right);
      }
    }

   
}
