package com.wf.code.设计模式.适配器模式.类适配模式;


/**
 * @auter wf
 * @date 2021/1/21
 */
public class Callear {
    public static void main(String[] args) {
        Line line = new Anddroid_iPhone_Adapter();
        line.charging_Cable();
    }
}
