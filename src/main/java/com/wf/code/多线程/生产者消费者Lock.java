package com.wf.code.多线程;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auter wf
 * @date 2021/1/21
 */
public class 生产者消费者Lock {

    //因为list共享在堆内存，所以不存在数据不一致问题，两个线程共享的是同一份内存。
    private static final LinkedList list = new LinkedList();

    private static Lock lock = new ReentrantLock();
   static Condition producter = lock.newCondition();
   static Condition consumer = lock.newCondition();

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Consumer consumer = new Consumer();
        consumer.start();
    }

    private static class Producer extends Thread{
        public void run(){
            lock.lock();
            try {
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        list.add(list.size()+1);
                        System.out.println(list.size());
                        if (list.size()%5==0){
                            consumer.signal();
                            producter.await();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }


    private static class Consumer extends Thread{
        public void run(){
                lock.lock();
                try {
                    while (true){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println(list.size());
                            list.remove(list.size()-1);
                            if (list.size()==0){
                                producter.signal();
                                consumer.await();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }finally {
                    lock.unlock();
                }

        }
    }

}
