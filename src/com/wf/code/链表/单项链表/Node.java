package com.wf.code.链表.单项链表;

public class  Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
    public static void print(Node root){
        Node curr = root;
        while (curr!=null){
            if (curr.next!=null){
                System.out.print(curr.val+"->");
            }else {
                System.out.print(curr.val);
            }
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
