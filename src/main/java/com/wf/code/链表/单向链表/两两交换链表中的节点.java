package com.wf.code.链表.单向链表;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @auter wf
 * @date 2021/3/2
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;
        printNode(node1);
        System.out.println();
        Node node = swapPairs(node1);
        printNode(node);
    }

    public static void  printNode(Node node){
        Node curr = node;
        while (curr!=null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    public static Node swapPairs(Node head) {
        Node pre = new Node(-1);
        pre.next = head;
        Node temp = pre;
        while (temp.next!=null && temp.next.next!=null){
            Node node1 = temp.next;
            Node node2 = temp.next.next;

            temp.next = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return pre.next;
    }
    
    public static void swapPairs1(Node node) {
        Node nodePre = node, next = node.next;
        
    }
    
}
