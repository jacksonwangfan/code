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
        System.out.println(isSymmetric1(node1));
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
    /**************************对称的二叉树*****************************/
   public static boolean isSymmetric1(TreeNode root){
       if (root==null) return false;
       return helper1(root.left,root.right);
   }

   public static boolean helper1(TreeNode n1,TreeNode n2){
       if (n1==null && n2==null) return true;
       if (n1==null || n2==null) return false;
       if (n1.val==n2.val && helper(n1.left,n2.right) && helper(n1.right,n2.left)){
           return true;
       }else {
           return false;
       }
   }




}
