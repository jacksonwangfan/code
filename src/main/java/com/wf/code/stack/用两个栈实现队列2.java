package com.wf.code.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 用两个栈实现队列2 {

    private static Stack<Integer> stack1 = new Stack();
    private static Stack<Integer> stack2 = new Stack();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    /*    for (int i = 0; i < arr.length; i++) {
            System.out.println(pop());
        }*/
        for (int i : arr) {
            push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(poll());
        }
        
    }
    
    private static void push(int e) {
        stack1.push(e);
    }
    
    private static int poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer popValue = stack1.pop();
                stack2.push(popValue);
            }
            return stack2.pop();
        }
        return stack2.pop();
    }
    
}
