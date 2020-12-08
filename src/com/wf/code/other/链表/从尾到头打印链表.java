package com.wf.code.other.链表;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class 从尾到头打印链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Arrays.stream(Arrays.stream(reversePrint(node1)).toArray()).forEach(System.out::println);


    }

    //TODO
    //一种方式是利用栈；一种方式是翻转链表再遍历一遍； 还有一种是将正序遍历的链表倒放在数组里返回（最简单 hh）
    public static int[] reversePrint(ListNode head) {
        //这里使用翻转链表，栈的方式省略。。练习链表翻转代码
        ListNode listNode = flipList(head);
        int count = 0;
        while (listNode != null) {
            count++;
            listNode = listNode.next;
        }
        int[] res = new int[count];
        while (listNode != null) {
            res[count--] = listNode.val;
            listNode = listNode.next;
        }
        return res;
    }

    //头插法翻转链表
    public static ListNode flipList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode nxt = head.next;
        ListNode pre = null;

        while(nxt != null){
            pre = nxt.next;
            nxt.next = curr;
            curr = nxt;
            nxt = pre;
        }
        head.next = null;
        return curr;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
