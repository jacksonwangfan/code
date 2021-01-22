package com.wf.code.链表.单向链表;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 查找单链表的倒数第k个节点要求只能遍历一次链表 {

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n4 = new Node(0);
        n1.next=n2;
        n1.next.next=n4;
        System.out.println(getReCiprocalK(n1, 4).val);
    }
       public static Node getReCiprocalK(Node root,int k){
            Node pre = root,curr = null;
            while (pre!=null && k>0){
                pre = pre.next;
                --k;
            }
            while (pre!=null){
                pre = pre.next;
                curr = curr.next;
            }
            //如果在前面的指针都跑完了,后面的指针curr还没动，说明倒数低k个节点不存在
            if (curr==null) return new Node(-1);
            return curr;
        }
}
