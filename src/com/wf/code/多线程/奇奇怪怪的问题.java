package com.wf.code.多线程;

import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @auter wf
 * @date 2021/1/16
 */
public class 奇奇怪怪的问题 {

    public static void main(String[] args) throws Exception {

        Hashtable  hashtable = null;
        ConcurrentHashMap concurrentHashMap = null;
        T1 t1 = new T1();
        t1.start();

        T2 t2 = new T2();
        Thread t3 = new Thread(t2);
        t3.start();
        T3 t31 = new T3();
        String call = t31.call();
        System.out.println(call);
    }

    /*一个线程start两次会发生什么，试试*/
    //会抛异常，因为一个线程状态不回退
   public static class T1 extends Thread{
        ThreadLocal local = new ThreadLocal();
        public void run(){
            local.set("111");
            System.out.println(local.get());
            System.out.println("start 两次");
        }
    }

    public static class T2 implements Runnable{
       public void run(){
           System.out.println(1);
       }
    }

    public static class T3 implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "yes";
        }
    }
}
