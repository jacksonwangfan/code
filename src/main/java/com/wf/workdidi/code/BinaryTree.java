package com.wf.workdidi.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//二叉树
public class BinaryTree {


    // 测试 preList 方法
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // 构建测试二叉树
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        // 测试先序遍历
        List<Integer> result = binaryTree.preList(root);

        // 输出结果
        System.out.println("先序遍历结果: " + result);
        // 预期输出: [1, 2, 4, 5, 3, 6, 7]

        // 测试空树
        List<Integer> emptyResult = binaryTree.preList(null);
        System.out.println("空树遍历结果: " + emptyResult);

        // 测试单个节点
        TreeNode singleNode = new TreeNode(10);
        List<Integer> singleResult = binaryTree.preList(singleNode);
        System.out.println("单节点遍历结果: " + singleResult);
    }


    //中序 遍历二叉树
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (null == root) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }


    //先序遍历
    public List<Integer> preList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        deep(root, res);
        return res;
    }

    public void deep(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }

        res.add(treeNode.val);
        deep(treeNode.left, res);
        deep(treeNode.right, res);
    }

    /*100. 相同的树
            简单
    相关标签
    premium lock icon
            相关企业
    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
                return false;
        }

        return  isSameTree(p.left, q.left) && isSameTree(p.right, p.right);
    }
}
