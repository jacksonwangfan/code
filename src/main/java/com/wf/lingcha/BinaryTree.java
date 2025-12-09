package com.wf.lingcha;

import com.wf.code.二叉树.TreeNode;

import java.util.*;

//二叉树相关问题
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        //int depth = BinaryTree.DeepTree(root);
        int depth = BinaryTree.DeepTree2(root);
        
        System.out.println("二叉树的最大深度为: " + depth); // 输出：3
    }


    //求二叉树的最大深度问题开始
    public static int DeepTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = DeepTree(root.left);
        int rightDeep = DeepTree(root.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
    static class Value {
        int v;
    }

    //求二叉树最大深度第二种方法
    public static int DeepTree2(TreeNode root) {
        Value ans = new Value();
        DeepTree3(root, 0, ans);
        return ans.v;
    }
    public static void DeepTree3(TreeNode root, int cnt, Value ans) {
        if (root == null) {
            return;
        }

        ++cnt;
        ans.v = Math.max(ans.v, cnt);
        DeepTree3(root.left, cnt, ans);
        DeepTree3(root.right, cnt, ans);
    }
    //###########################求二叉树的最大深度问题结束###########################


/**
 * 100. 相同的树
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 101. 对称二叉树
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetricSubTree(left, right);
    }

    public boolean isSymmetricSubTree (TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == r;
        }
        return l.val == r.val && isSymmetricSubTree(l.left, r.right) && isSymmetricSubTree(l.right, r.left);
    }

    /**
     * 110. 平衡二叉树
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定一个二叉树，判断它是否是 平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = getHight(root.left);
        int rightH = getHight(root.right);
        return  !(Math.abs(leftH - rightH) > 1) && isBalanced(root.left) && isBalanced(root.right);
    }


    public int getHight(TreeNode node) {
        if (node == null) {
            return 0;
        }

       int left_deep = getHight(node.left);
       int right_deep = getHight(node.right);
       return  Math.max(left_deep, right_deep) + 1;
    }


    /**
     * 199. 二叉树的右视图
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int deep = 0;
        listBinaryTree(root, deep, map);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < map.size(); i++) {
            Integer integer = map.get(i);
            list.add(integer);
        }

        return list;
    }

    public void listBinaryTree(TreeNode root, int deep, Map<Integer, Integer> map ){
        if (root == null) {
            return;
        }

        if (!map.containsKey(deep)) {
            map.put(deep, root.val);
        }

        listBinaryTree(root.right, deep + 1, map);
        listBinaryTree(root.left, deep + 1, map);
    }


    /**
     * 二叉树的右视图，采用层序遍历的方式
     * @param root
     * @return
     */
    public List<Integer> rightSideViewLevelList(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                //最后一个收集答案
                if (i == size - 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }

    /**
     * 965. 单值二叉树
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        int val = root.val;
        return isSameValTree(root, val);

    }

    public boolean isSameValTree(TreeNode node, int val){
        if (node == null) {
            return true;
        }

        if (node.val != val) {
            return false;
        }

       return isSameValTree(node.left, val) && isSameValTree(node.right, val);
    }

    /**
     * 是否是 翻转等价二叉树
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

       return  (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
    }

    /**
     * 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        processInvertTree(root);
        return root;
    }

    public void processInvertTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }

    /**
     * 合并二叉树 https://leetcode.cn/problems/merge-two-binary-trees/
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return null;
    }



}
