package com.wf.code;

import org.openjdk.jol.info.ClassLayout;

import java.lang.instrument.Instrumentation;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @auter wf
 * @date 2020/12/10
 */
public class test {

    public static void main(String[] args) throws Exception {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        
        /*T1 T1 = new T1();
        T2 t2 = new T2();
        T1.start();
        t2.start();*/



/*        System.out.println(String.join(",","223312313"));
        System.out.println( new  IllegalArgumentException() instanceof  Throwable );
        ko:
        for (int i = 0; i < 100; i++) {
            b0:
            for (int j = 0; j < 100; j++) {
                break b0;
            }
        }*/
    }

    private static List list;

   static class T1 extends Thread{
       @Override
       public void run() {
           Object o = null;
           synchronized (o){
               System.out.println(222);
           }
               list = Collections.synchronizedList(new LinkedList<>());
               try {
                   TimeUnit.SECONDS.sleep(5);
                   System.out.println(5);
                   list = null;
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

       }
   }

    static class T2 extends Thread{
        @Override
        public void run() {
           while (true){
               if (list==null) {
                   System.out.println(222);
                   break;
               }
           }
            System.out.println("end");
        }
    }

    //接雨水的提交中修改文件
}
