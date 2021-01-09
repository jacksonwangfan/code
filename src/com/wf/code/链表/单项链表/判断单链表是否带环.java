package com.wf.code.链表.单项链表;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class 判断单链表是否带环 {
    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(10);
        n1.next=n2;
        n1.next.next=n3;
        n1.next.next.next=n5;
        //入环点为10(n5节点)
        n5.next = n2;
        //System.out.println(isCircular(n1));
        //求入环点
        System.out.println(getCircular1(n1).val);
    }

    //是否有环
    public static boolean isCircular(Node node){
        Node quickly = node;
        Node slowly  = node;
        while (quickly!=null){
            quickly = quickly.next.next;
            slowly = slowly.next;
            if (quickly==slowly) return true;
        }
        return false;
    }
    //求入环点 方法一
    public static Node getCircular1(Node node){
        Node quickly = node;
        Node slowly  = node;
        while (quickly!=null){
            quickly = quickly.next.next;
            slowly = slowly.next;
            //这里快慢指针相遇的点是入环的前一个点，我也不知道是为啥。
            if (quickly==slowly) {
                //所以返回入环点是相遇的下一个节点
                return quickly.next;
            }
        }
        //返回空就没有环
        return null;
    }
    //求入环点 方法二
    public static Node getCircular2(Node node){
        Node quickly = node;
        Node slowly  = node;
        while (quickly!=null){
            quickly = quickly.next.next;
            slowly = slowly.next;
            //如果相遇 快指针变为慢指针，再次相遇的点就是入环点
            if (quickly==slowly) {
                quickly = node;
                while (quickly!=null){
                    quickly = quickly.next;
                    slowly = slowly.next;
                    if (quickly==slowly){
                        return quickly;
                    }
                }
            }
        }
        //返回空就没有环
        return null;
    }

}
