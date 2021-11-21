package com.wf.code.设计模式.责任链;

/**
 * 抽象的处理类 以公司请假流程来 模拟
 * @auter wf
 * @date 2021/1/20
 */

public abstract class AbstartHanlder {
    //Supervisor 直接主管最多审批三天假
    protected static final Integer supervisor_day = 3;
    //Department manager 部门领导 最多可以审批七天假期
    protected static final Integer departmentManager_day = 10;
    //boss 总经理 可以批一个月的假期
    protected static final Integer boss_day = 30;
    //一个月以上 可以回家了

    //各级别领导名子
    String name;
    //请假详情
   public Leave leave;

   public AbstartHanlder(String leaderName){
       this.name = leaderName;
   }

    protected AbstartHanlder nextHanlder;
    public abstract void hanle(Leave leave);
}
