package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉树的最大深度 {


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
        System.out.println(Depth(node1));
        System.out.println(maxdepth(node1));
    }
   public static int Depth(TreeNode root){
       if (root!=null){
           int left = Depth(root.left)+1;
           int right = Depth(root.right)+1;
           return left>right?left:right;
       }else {
           return 0;
       }
   }
   /*********************************二刷*************************************/
   //二叉树的最大深度
    public static int maxdepth(TreeNode root){
        if (root==null) return 0;
       return Math.max(maxdepth(root.left)+1,maxdepth(root.right)+1);
    }

}
