package com.wf.code.设计模式.责任链;

/**
 * 第三层应该是 公司boss来审批
 * @auter wf
 * @date 2021/1/20
 */
public class HandlerThird extends AbstartHanlder {
    public HandlerThird(String leaderName) {
        super(leaderName);
    }

    @Override
    public void hanle(Leave leave) {
        if (leave.days<=boss_day){
            System.out.println(this.name+"批准，请假"+leave.days+"天");
        }
        //boss都处理不了，建议离职，这也是过滤链最后一条可能执行的逻辑
        else {
            System.out.println("请假时间长，建议办理离职。");
        }
    }
}
