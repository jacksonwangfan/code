package com.wf.code.链表.单向链表;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 *输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。
 *
 * @auter wf
 * @date 2021/3/3
 */
public class 合并两个链表 {


    public static Node mergeInBetween(Node list1, int a, int b, Node list2) {
        Node curr1 = list1;
        Node post = curr1;
        Node pre = curr1.next;
        while(a>0){
            post = curr1;
            pre =  curr1.next;
            curr1 = curr1.next;
            a--;
            b--;
        }
        //找到了第一个将要断开的位置
        Node n1 = post;
        while(b>=0){
            post = curr1;
            pre =  curr1.next;
            curr1 = curr1.next;
            b--;
        }
        //找到了第二个将要断开的位置
        Node n2 = pre;

        //处理第一个断开位置
        n1.next = list2;
        Node curr2 = list2;
        //找到list2的尾巴
        while(curr2.next!=null){
            curr2 = curr2.next;
        }
        //处理第二处断开位置
        curr2.next = n2;
        return list1;
    }

}
