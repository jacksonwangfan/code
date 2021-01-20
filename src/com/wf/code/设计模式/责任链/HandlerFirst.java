package com.wf.code.设计模式.责任链;

/**
 * 第一层应该是主管来审批
 * @auter wf
 * @date 2021/1/20
 */
public class HandlerFirst extends AbstartHanlder {

    public HandlerFirst(String leaderName) {
        super(leaderName);
    }

    @Override
    public void hanle(Leave leave) {
            //请假的天数在主管可审批的范围内，通过审批
            if (this.supervisor_day>=leave.days){
                System.out.println(this.name+"批准，请假"+leave.days+"天");
            }else {
                //自己处理不了就交给下一级领导来处理
                this.nextHanlder.hanle(leave);
            }
    }
}
