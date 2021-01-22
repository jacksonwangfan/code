package com.wf.code.链表.单向链表;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 删除一个无头单链表的非尾节点 {
    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n4 = new Node(0);
        Node n5 = new Node(10);
        n1.next=n2;
        n1.next.next=n4;
        n1.next.next.next=n5;
        deleteNode(n1);
        Node.print(n1);
    }
    /**
     * 借尸还魂，把当前节点的下一个节点值覆盖掉本节点的值，然后当前节点指向下下一个节点
     * 尾巴节点是在没有头节点的情况下是不可能删掉的
     */
    public static void deleteNode(Node node){
        if (node.next==null) return;
        //把当前节点的下一个节点值覆盖掉本节点的值
        node.val = node.next.val;
        //然后当前节点指向下下一个节点
        node.next = node.next.next;
    }
}
