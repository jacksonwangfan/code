package com.wf.code.二叉树;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉搜索树的最近公共祖先 {

    /*
     *           5
     *       3       8
     *    0      4
     * */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node0;
        node2.right = node4;

        System.out.println(lowestCommonAncestor1(node1, node4, node3));
        System.out.println(lowestCommonAncestor1(node1, node3, node4));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //分叉了当前节点就是最近公共父节点
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        if (root.val >= q.val && root.val <= p.val) {
            return root;
        } else {
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        }
    }

    //二刷
    //说明:
    //所有节点的值都是唯一的。
    //p、q 为不同节点且均存在于给定的二叉搜索树中。
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode n1, TreeNode n2) {
        //特殊处理
        if (root == null) return null;
        //当n1 或 n2其中有一个等于跟节点时 返回根节点
        if (root.val == n1.val || root.val == n2.val) return root;
        //当n1 n2分布于根节点两侧时 返回根节点
        if (root.val > n1.val && root.val < n2.val) return root;
        //当都小于根节点时递归左子树
        if (root.val > n1.val && root.val > n2.val) {
            return lowestCommonAncestor1(root.left, n1, n2);
        }
        //当都大于根节点时递归右子树
        else {
            return lowestCommonAncestor1(root.right, n1, n2);
        }
    }
}
