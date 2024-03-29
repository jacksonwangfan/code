package com.wf.code.面试遇到的算法.滴滴;

import com.wf.code.二叉树.TreeNode;

/**
 * 滴滴二面，判断一棵树书否是平衡二叉树
 */
public class BalanceTree {

    public static void main(String[] args) {
        
    }
    
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left))-Math.abs(depth(root.right))>1){
            return false;
        }
        if (isBalance(root.left) && isBalance(root.right)) {
            return true;
        }
        return false;
    }
    
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left)+1, depth(root.right)+1);
    }
}
