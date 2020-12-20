package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 对称的二叉树 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
            if (root==null){
                return true;
            }
            return helper(root.left,root.right);
    }

    public static boolean  helper(TreeNode node1,TreeNode node2){
        if (node1==null && node2==null){
            return true;
        }
        if (node1==null || node2==null){
            return false;
        }
        if (node1.val ==node2.val && helper(node1.left,node2.right) && helper(node1.right,node2.left)){
            return true;
        }
        return false;
    }

}
