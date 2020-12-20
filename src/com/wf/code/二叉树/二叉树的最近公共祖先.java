package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = new TreeNode(5);
        System.out.println(lowestCommonAncestor(node1, node4, node2));
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
}
