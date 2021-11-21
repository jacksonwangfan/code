package com.wf.code.stack;

import javax.sound.midi.Soundbank;
import java.util.Stack;

/**
 * @auter wf
 * @date 2020/12/8
 */
public class 用两个栈实现队列 {

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    /*    for (int i = 0; i < arr.length; i++) {
            System.out.println(pop());
        }*/
        for (int i : arr) {
            push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(pop());
        }
    }

    private static Stack<Integer> stackA = new Stack();
    private static Stack<Integer> stackB = new Stack();

    //出栈
    public static Integer pop() throws Exception {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                throw new Exception("No elements!!");
            }
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        } else {
            return stackB.pop();
        }
    }

    //入栈
    public static void push(Integer value) {
        stackA.push(value);
    }


}
