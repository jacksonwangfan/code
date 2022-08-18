package com.wf.code.链表.单向链表;

public class 两数相加 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int currVal1 = l1 == null ? 0 : l1.val;
            int currVal2 = l2 == null ? 0 : l2.val;
            int sum = currVal1 + currVal2 + carry;
            int currVal = sum % 10;
            if (head == null){
                head = tail = new ListNode(currVal);
            }else {
                tail.next = new ListNode(currVal);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 将数组构造为一个链表（构造链表套路）
     */
    public static ListNode buildListNode(int[] arr){
        ListNode head = null, tail = null;
        for (int i = 0; i < arr.length; i++) {
            if (head == null){
                head = tail = new ListNode(arr[i]);
            }else {
                tail.next = new ListNode(arr[i]);
                tail = tail.next;
            }
        }
        return head;
    }
}
