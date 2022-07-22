package com.wf.code.二叉树.遍历;

import com.wf.code.二叉树.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 二叉树先中后序遍历2刷 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        //bfs(node1);
        //preOrder(node1);
        //midOrder(node1);
        postOrder(node1);
    }
    

    /**
     * 层序遍历
     */
    private static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 非递归先序遍历 
     */
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                System.out.println(curr.val);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            //System.out.println(pop.val);
            curr = pop.right;
        }
    }
    
    /**
     * 非递归中序遍历
     */
    private static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr!=null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode pop = (TreeNode) stack.pop();
            System.out.println(pop.val);
            curr = pop.right;
        }
    }
    
    /**
     * 非递归后序遍历
     */
    public static void postOrder(TreeNode root){
        if (root == null) {
            return;
        }
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(0, pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        for (TreeNode treeNode : list) {
            System.out.println(treeNode.val);
        }
    }

    /**
     * 递归先序遍历
     */

    /**
     * 递归中序遍历
     */

    /**
     * 递归后序遍历
     */
    
}
