package com.wf.code.链表.单向链表;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 合并两个有序的链表 {

    public static void main(String[] args) {
        //1->2->4, 1->3->4
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        n1.next=n2;
        n1.next.next=n4;
        Node m1 = new Node(0);
        Node m3 = new Node(1);
        Node m4 = new Node(7);
        m1.next = m3;
        m1.next.next = m4;
        Node node = mergeOrder1(n1, m1);
        Node.print(node);
    }
      public static Node mergeOrder(Node l1,Node l2){
          if (l1==null && l2==null) return null;
          if (l1==null) return l2;
          if (l2==null) return l1;
          if (l1.val>l2.val){
                l1.next = mergeOrder(l1.next,l2);
                return l1;
          }else {
                l2.next = mergeOrder(l1,l2.next);
                return l2;
          }
      }
      
      public static Node mergeOrder1(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) { 
            l1.next = mergeOrder1(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeOrder1(l1, l2.next);
            return l2;
        }
      }
}
