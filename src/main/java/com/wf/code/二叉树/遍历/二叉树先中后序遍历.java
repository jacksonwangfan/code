package com.wf.code.二叉树.遍历;

import com.wf.code.二叉树.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @auter wf
 * @date 2020/12/19
 */
public class 二叉树先中后序遍历 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = new TreeNode(5);
       /* BFS(node1).stream().forEach(i->{
            System.out.println(i);
        });*/

        postOrder(node1).stream().forEach(i -> {
            System.out.println(i);
        });
        postOrder1(node1).stream().forEach(i -> {
            System.out.println(i);
        });


    }


    //层序遍历 利用队列层序遍历
    public static List BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    //先序遍历 用栈
    public static List PreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<TreeNode> list = new LinkedList();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                list.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return list;
    }

    //中序遍历
    public static List minOrder(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            //这里访问
            list.add(curr);
            curr = curr.right;
        }
        return list;
    }

    //后序遍历、
    public static List postOrder(TreeNode root) {
        List<TreeNode> list = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        //prev用来记录后续遍历过程中的前一个节点，如果前一个节点是当前遍历节点的右节点的话，这时候采才进行有效遍历
        TreeNode prev = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.peek();
            //temp.right == null && temp.right == prev 右子节点为空或者右子节点指向 之前访问过的节点，表明可以访问根节点
            if (temp.right == null || temp.right == prev) {
                list.add(temp);
                prev = temp;
                stack.pop();
                curr = null; //让栈不断弹出，因为已经访问完成左右子节点了, 得让栈一直弹出
            }else {
                curr = temp.right;
            }
        }
        return list;
    }

    /******************************************二叉树遍历模板代码（先 中）***************************************************/
    //先序
    public void pre(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr!=null){
                while (curr!=null){
                    stack.push(curr);
                    //在这一行访问是元素curr就是先序
                    curr = curr.left;
                }
                curr = stack.pop();
                //在这一行访问元素curr就是中序
                curr = curr.right;
        }
    }
    /******************************************二叉树遍历模板代码（后）***************************************************/

    public static List<TreeNode> postOrder1(TreeNode root){
            Stack<TreeNode> stack = new Stack();
            List<TreeNode> list = new ArrayList();
            TreeNode curr = root;
            TreeNode pre = null;
            while (!stack.isEmpty() || curr!=null){
                while (curr!=null){
                    stack.push(curr);
                    curr = curr.left;
                }
                TreeNode temp = stack.peek();
                if (temp.right==null || temp.right==pre){
                    //add
                    list.add(temp);
                    pre = temp;
                    stack.pop();
                    curr = null;
                }else {
                    curr = temp.right;
                }
            }
            return list;
    }
    /*********************************************下面纯属练习区域**********************************************************/
    public void postOrder2(TreeNode root){
        if (root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.peek();
            if (temp.right==null || temp.right==pre){
                System.out.println(temp);
                pre = temp;
                stack.pop();
                curr = null;
            }else {
                curr = curr.right;
            }
        }
    }


}
