package com.wf.code.二叉树;

import javafx.scene.layout.Priority;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = new TreeNode(5);
        System.out.println(kth(node1, 1));
    }

    //第一种方法利用一个PriorityQueue 构造大顶堆实现
 public static Integer  kth(TreeNode root,int k){
     //默认构造的是小顶堆，这里我们用大顶堆不用小顶堆
     PriorityQueue<Integer> smallHeap = new PriorityQueue();
     //构造大顶堆
    // PriorityQueue maxHeap = new PriorityQueue(k,Collections.reverseOrder());
     List<TreeNode> list = new ArrayList();
     List<TreeNode>  preList = pre(root, list);
     for (TreeNode node : preList) {
            if (smallHeap.size()==k){
                if (node.value>smallHeap.peek()){
                    smallHeap.poll();
                    smallHeap.add(node.value);
                }
            }else {
                smallHeap.add(node.value);
            }
     }
     return smallHeap.peek();
 }
    //第二种中序遍历这个二叉排序树 返回遍历的倒数第k个节点

    //遍历二叉树工具方法 这里为了简便就随便来先序吧
    public static List pre(TreeNode root,List  list){
            if (root==null){
                return list;
            }
            list.add(root);
            pre(root.left,list);
            pre(root.right,list);
            return list;
    }

}
