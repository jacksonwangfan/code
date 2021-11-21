package com.wf.code.设计模式.策略;

/**
 * @auter wf
 * @date 2021/1/20
 */
public class Caller {
    //统一的策略接口
    AbstractStrategy strategy;
    public Caller(AbstractStrategy strategy){
        this.strategy = strategy;
    }

    public void call(){
        System.out.println(strategy.spStrategy());
    }

    public static void main(String[] args) {
        Caller caller1 = new Caller(new StrategyImplFirst());
        caller1.call();
        Caller caller2 = new Caller(new StrategyImplSecond());
        caller2.call();
        Caller caller3 = new Caller(new StrategyImplThird());
        caller3.call();
    }

}
