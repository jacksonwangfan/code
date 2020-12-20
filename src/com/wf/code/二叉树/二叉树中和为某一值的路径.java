package com.wf.code.二叉树;

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
    //思路先序遍历，在元素出栈的时候我们计算一下栈里的和是多少，若等于sum将栈转化为 数组，并添加到结果中
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode curr = root;
        long value = 0;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            curr = curr.right;
            if (curr == null) {
                if (!stack.isEmpty()) {
                    value += stack.peek().val;
                    stack1.add(stack.pop());
                }
                if (value == sum) {
                    Integer size = stack.size();
                    list = new ArrayList<>(size);
                    for (Integer i = 0; i < size; i++) {
                        list.add(i, stack1.peek().val);
                        stack.add(stack1.pop());
                    }
                }
                lists.add(list);
            }
            //栈计算完了之后 在pop()
            stack.pop();
        }
        return lists;
    }
}
