package com.wf.code.设计模式.策略;

/**
 * @auter wf
 * @date 2021/1/20
 */
public class StrategyImplFirst implements AbstractStrategy<String> {
    @Override
    public String spStrategy() {
        return "策略一";
    }
}
