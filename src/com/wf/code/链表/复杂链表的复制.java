package com.wf.code.链表;

import java.util.HashMap;
import java.util.Map;


/**
 * 剑指 Offer 35. 复杂链表的复制
 * @auter wf
 * @date 2021/1/9
 */
public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     *  请实现 copyRandomList函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *  来源：力扣（LeetCode）
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node curr = head;
        Map<Node,Node> map = new HashMap<>();
        while (curr!=null){
            map.put(curr,new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr!=null){
            //这里有点绕，记一下
            //获取与当前节点对应的·新节点的下一个节点· //获取当前节点的·下一个节点对应的新节点·
            map.get(curr).next  = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
