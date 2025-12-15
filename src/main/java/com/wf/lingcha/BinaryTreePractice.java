package com.wf.lingcha;

import com.wf.code.二叉树.TreeNode;

import java.util.*;

/**
 * //二叉树练习抽查练习
 */


public class BinaryTreePractice {
    //判断一棵二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricSub(root.left, root.right);
    }

    public boolean isSymmetricSub(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isSymmetricSub(left.left, right.right) && isSymmetricSub(left.right, right.left);
    }


}
