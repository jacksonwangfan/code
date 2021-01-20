package com.wf.code.设计模式.责任链;

/**
 * 第二层应该是 部门领导来审批
 * @auter wf
 * @date 2021/1/20
 */
public class HandlerSecond extends AbstartHanlder {
    public HandlerSecond(String leaderName) {
        super(leaderName);
    }

    @Override
    public void hanle(Leave leave) {
        if (leave.days<= this.departmentManager_day){
            System.out.println(this.name+"批准，请假"+leave.days+"天");
        }
        //交给下一级领导处理
        else {
            this.nextHanlder.hanle(leave);
        }
    }
}
