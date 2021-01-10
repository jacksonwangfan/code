package com.wf.code.设计模式.单例;

/**
 * @auter wf
 * @date 2021/1/10
 */
public class 静态内部类 {
    private static class Inner{
        private static final 静态内部类 INSTANCE= new 静态内部类();
    }

    public static 静态内部类 getInstance(){
        return Inner.INSTANCE;
    }
}
