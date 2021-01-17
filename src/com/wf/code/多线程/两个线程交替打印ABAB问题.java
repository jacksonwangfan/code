package com.wf.code.多线程;

import org.junit.Test;

/**
 * @auter wf
 * @date 2020/12/8
 */
public class 两个线程交替打印ABAB问题 {

    private static final Object object = new Object();

    public static void main(String[] args) {
        myThreadA myThreadA = new myThreadA();
        myThreadB myThreadB = new myThreadB();
        myThreadA.start();
        myThreadB.start();
    }

    static class myThreadA extends Thread{
        public void run(){
            synchronized(object){
                while(true){
                    try {
                        System.out.println("A");
                        Thread.sleep(500);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class myThreadB extends Thread{
        @Override
        public void run() {
            synchronized(object){
                while (true){
                    try {
                        System.out.println("B");
                        Thread.sleep(500);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

