package com.wf.code.二叉树;

/**
 *  输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */

import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 平衡二叉树 {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = new TreeNode(9);
        //node2.right = new TreeNode(5);
        System.out.println(isBalance(node1));
    }

    //定义左子树和右子树高度相差不为一的树为左子树
    public static boolean isBalance(TreeNode root){
        //root为空就是平衡二叉树,递归的的一个终止条件
        if (root==null){
            return true;
        }
        //左右子树相差大于一就不是 平衡二叉树，递归的第二个终止条件
        if (Math.abs(hight(root.left)-hight(root.right))>1){
            return false;
        }
        //左子树为平衡二叉树，且右边子树为平衡二叉树 开始递归
        if (isBalance(root.right) && isBalance(root.left)){
            return true;
        }
        return false;

    }


    //收集子树的高度
    public static int  hight(TreeNode node){
        if (node==null) return 0;
         else return Math.max(hight(node.left)+1,hight(node.right)+1);
    }

}
