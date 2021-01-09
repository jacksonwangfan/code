package com.wf.code.链表.单项链表;

import java.util.HashSet;
import java.util.Set;

/**
 * @auter wf
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * @date 2021/1/9
 */
public class 两个链表的第一个公共节点 {
    /**
     * hashset做就能A过 不过力扣 效率有点低啊
     * 执行用时：10 ms, 在所有 Java 提交中击败了 9.36%的用户
     * 内存消耗：42.1 MB , 在所有 Java 提交中击败了 8.52% 的用户
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        Set<Node> set = new HashSet();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
