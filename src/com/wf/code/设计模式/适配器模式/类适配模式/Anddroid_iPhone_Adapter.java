package com.wf.code.设计模式.适配器模式.类适配模式;

/**
 * 要把安卓的充电器转换给苹果用
 * 目标是转为 lightning 接口
 * @auter wf
 * @date 2021/1/21
 */
public class Anddroid_iPhone_Adapter extends AndroidLine implements Line{

    @Override
    public void charging_Cable() {
        type_C();
        System.out.println("将安卓充电线插上转接头");
        System.out.println("适配完成");
    }
}
