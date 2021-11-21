package com.wf.code.设计模式.策略;

/**
 * 定义一个抽象的策略类，有一个抽象的策略方法，不同的子类有不同的实现
 * @auter wf
 * @date 2021/1/20
 */
interface AbstractStrategy<T> {
    /**
     * 策略的抽象方法，子类的策略由子类自己实现
     * @return
     */
    public abstract T spStrategy();
}
