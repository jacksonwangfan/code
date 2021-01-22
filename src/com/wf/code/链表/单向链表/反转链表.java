package com.wf.code.链表.单向链表;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 反转链表 {

    public static void main(String[] args) {
        //1->2->4
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n4 = new Node(0);
        n1.next=n2;
        n1.next.next=n4;
        Node.print(filpNodeList(n1));
        Node.print(filpNodeList1(n1));
    }


   public static Node filpNodeList(Node head){
        Node pre = null,next = null;
        Node curr = head;
        while (curr!=null){
            //保存当前节点的下一个节点
            next = curr.next;
            //指向前驱
            curr.next = pre;
            //前驱后移
            pre = curr;
            //当前节点后移，使用上面的next就行
            curr = next;
        }
        return pre;
   }

   //跟上面的那个方法一样
    public static Node filpNodeList1(Node node){
        Node pre=null,curr = node,next=null;
        while (curr!=null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
