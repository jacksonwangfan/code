package com.wf.code.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @auter wf
 * @date 2021/1/9
 */
public class A线程加入到B的线程中执行 {
   public static A a = new A();
   public static B b = new B();
    public static void main(String[] args) {
        a.start();
        b.start();
    }

    public static class A extends Thread{
        public void run(){

            System.out.println(1);
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }
    }
    public static class B extends Thread{
        public void run(){
            System.out.println(2);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
