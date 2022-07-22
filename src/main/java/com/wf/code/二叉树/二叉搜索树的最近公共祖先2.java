package com.wf.code.二叉树;

public class 二叉搜索树的最近公共祖先2 {
    
    
    public TreeNode parent(TreeNode treeNode, TreeNode node1, TreeNode node2) {
        if (treeNode == null) {
            return null;
        }
        if (node1.val == treeNode.val || node2.val == treeNode.val) {
            return treeNode;
        }
        if (node1.val < treeNode.val && node2.val > treeNode.val) {
            return treeNode;
        }
        if (node1.val < treeNode.val && node2.val < treeNode.val) {
            return parent(treeNode.left, node1, node2);
        }
        return parent(treeNode.right, node1, node2);
    }
    
}
