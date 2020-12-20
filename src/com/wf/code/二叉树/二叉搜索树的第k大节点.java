package com.wf.code.二叉树;

import java.util.*;

/**
 * @auter wf
 * @date 2020/12/20
 */
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = new TreeNode(4);
        System.out.println(kth2(node1, 2));
        System.out.println(kth(node1, 2));
    }

    //第一种方法利用一个PriorityQueue 构造大顶堆实现
    public static Integer kth(TreeNode root, int k) {
        //默认构造的是小顶堆，这里我们用大顶堆不用小顶堆
        PriorityQueue<Integer> smallHeap = new PriorityQueue();
        //构造大顶堆
        // PriorityQueue maxHeap = new PriorityQueue(k,Collections.reverseOrder());
        List<TreeNode> list = new ArrayList();
        List<TreeNode> preList = pre(root, list);
        for (TreeNode node : preList) {
            if (smallHeap.size() == k) {
                if (node.val > smallHeap.peek()) {
                    smallHeap.poll();
                    smallHeap.add(node.val);
                }
            } else {
                smallHeap.add(node.val);
            }
        }
        return smallHeap.peek();
    }
    //第二种中序遍历这个二叉排序树 返回遍历的倒数第k个节点
    public static int kth2(TreeNode root,int k){
        List<TreeNode> list = new ArrayList();
        List<TreeNode> list1 = midOrder(root, list);
        return list1.get(list1.size()-k).val;
    }

    //中序遍历方法，为了练习我们就写非递归遍历吧
    public static List midOrder(TreeNode root,List list){
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr!=null){
           while (curr!=null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr);
            curr = curr.right;
        }
        return list;
    }

    //遍历二叉树工具方法 这里为了简便就随便来先序吧
    public static List pre(TreeNode root, List list) {
        if (root == null) {
            return list;
        }
        list.add(root);
        pre(root.left, list);
        pre(root.right, list);
        return list;
    }

}
