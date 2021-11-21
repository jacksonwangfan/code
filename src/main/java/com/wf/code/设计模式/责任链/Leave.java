package com.wf.code.设计模式.责任链;

/**
 * 请假 内容
 * @auter wf
 * @date 2021/1/20
 */
public class Leave {
    //请假天数
    Integer days;
    //请假人姓名
    String name;

    public Leave(Integer days, String name) {
        this.days = days;
        this.name = name;
    }
}
