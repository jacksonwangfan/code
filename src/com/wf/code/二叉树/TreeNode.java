package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/19
 */

public class TreeNode {
   public int val;
   public  TreeNode left;
   public  TreeNode right;

   public TreeNode(int val){
       this.val = val;
   }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                '}';
    }
}
