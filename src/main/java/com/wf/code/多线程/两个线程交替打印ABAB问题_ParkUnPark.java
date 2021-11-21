package com.wf.code.多线程;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class 两个线程交替打印ABAB问题_ParkUnPark {
  static  A a = new A();
  static   B b = new B();
    public static void main(String[] args) {
        a.start();
        b.start();
    }

    public static class A extends Thread{
        public void run(){
            while (true) {
                System.out.println("A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(b);
                LockSupport.park();
            }
        }
    }
    public static class B extends Thread{
        public void run(){
            while (true) {
                LockSupport.park();
                System.out.println("B");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(a);
            }
        }
    }
}
