package com.wf.code.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auter wf
 * @date 2021/1/11
 */
public class 一个线程加入到另一个的线程中执行 {
   private static Lock lock = new ReentrantLock();


    public static class T1 extends Thread{
        @Override
        public void run(){
            lock.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run(){

        }
    }
}
