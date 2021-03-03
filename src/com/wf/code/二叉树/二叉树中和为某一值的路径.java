package com.wf.code.二叉树;

import sun.security.provider.Sun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @auter wf
 * @date 2020/12/20
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

public class 二叉树中和为某一值的路径 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //思路先序遍历，在遍历到叶子节点的时候 我们计算一下栈里的和是多少，若等于sum将栈转化为 数组，并添加到结果中
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pre(root, sum);
        return res;
    }

   public  void pre(TreeNode root,int tar){
        if (root==null) return;
        tar-=root.val;
        path.add(root.val);
        if (root.left==null && root.right==null && tar==0){
            res.add(new LinkedList<>(path));
        }
        pre(root.left,tar);
        pre(root.right,tar);
        tar =tar+ path.removeLast();
   }
}
