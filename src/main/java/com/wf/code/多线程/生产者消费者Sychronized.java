package com.wf.code.多线程;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @auter wf
 * @date 2021/1/17
 */
public class 生产者消费者Sychronized {

    //锁要用final修饰
    private static final Object lock = new Object();

    //因为list共享在堆内存，所以不存在数据不一致问题，两个线程共享的是同一份内存。
    private static final  LinkedList list = new LinkedList();

    private static class Provder extends Thread{
        public void run(){
            synchronized (lock){
            while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(list.size());
                        list.add(list.size()+1);
                        if (list.size()%5==0){
                            lock.notify();
                            lock.wait();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Consumer extends Thread{
        public void run(){
            synchronized (lock){
            while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        list.remove(list.size()-1);
                        System.out.println(list.size());
                        if (list.size()==0){
                            lock.notify();
                            lock.wait();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Provder provder = new Provder();
        Consumer consumer = new Consumer();
        provder.start();
        consumer.start();
    }
}
