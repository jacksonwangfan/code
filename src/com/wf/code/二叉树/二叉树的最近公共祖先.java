package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉树的最近公共祖先 {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
