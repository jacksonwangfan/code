package com.wf.code.设计模式.单例;

/**
 * @auter wf
 * @date 2021/1/10
 */
public class 懒汉式 {
    private static 饿汉式 instance;
    private 懒汉式(){}
    //线程不安全
    public static 饿汉式 getInstance(){
        if (instance==null) return instance;
        else return instance;
    }
}
