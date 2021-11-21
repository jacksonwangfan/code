package com.wf.code.设计模式.责任链;

/**
 * @auter wf
 * @date 2021/1/20
 */
public class Caller {
    public static void main(String[] args) {
        //搞出来每一个领导处理器
        AbstartHanlder l1 = new HandlerFirst("直接主管");
        AbstartHanlder l2 =  new HandlerSecond("部门领导");
        AbstartHanlder l3 =  new HandlerThird("总经理");

        //组织领导处理链
        l1.nextHanlder = l2;
        l2.nextHanlder = l3;

        //实验开始
        l1.hanle(new Leave(2,"em2"));
        l1.hanle(new Leave(7,"em7"));
        l1.hanle(new Leave(10,"em10"));
        l1.hanle(new Leave(15,"em15"));
        l1.hanle(new Leave(30,"em15"));
        l1.hanle(new Leave(31,"em15"));
        /**
         * 执行结果：
         * 小领导批准，请假2天
         * 大领导批准，请假7天
         * 大领导批准，请假10天
         * boss批准，请假15天
         * boss批准，请假30天
         * 请假时间长，建议办理离职。
         */
    }

}
