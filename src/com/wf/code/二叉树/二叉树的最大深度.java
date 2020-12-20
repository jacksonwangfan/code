package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉树的最大深度 {

   public static int Depth(TreeNode root){
       if (root!=null){
           int left = Depth(root.left)+1;
           int right = Depth(root.right)+1;
           return left>right?left:right;
       }else {
           return 0;
       }
   }

}
