package com.wf.code.设计模式.单例;

/**
 * @auter wf
 * @date 2021/1/10
 */
public class 双检锁 {
    private volatile static 双检锁 instance;
    private 双检锁(){}
    public static 双检锁 getInstance(){
        if (instance==null){
            synchronized (双检锁.class){
                if (instance==null){
                    instance = new 双检锁();
                }
            }
        }
        return instance;
    }

}
