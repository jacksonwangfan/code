package com.wf.code.设计模式.单例;

/**
 * @auter wf
 * @date 2021/1/10
 */
public class 饿汉式 {
    private static 饿汉式 instance = new 饿汉式();
    private 饿汉式(){}
    public static 饿汉式 getInstance(){
        return instance;
    }
}
