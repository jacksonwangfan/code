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

        System.out.println(lowestCommonAncestor(node1, node2, node4));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //分叉了当前节点就是最近公共父节点
            if (root.val >=p.val && root.val <=q.val){
                return root;
            }
            if(root.val >=q.val && root.val <=p.val){
                return root;
            }
            else {
                if (root.val <p.val && root.val <q.val){
                 return   lowestCommonAncestor(root.right,p,q);
                }else {
                  return  lowestCommonAncestor(root.left,p,q);
                }
            }
    }
}
