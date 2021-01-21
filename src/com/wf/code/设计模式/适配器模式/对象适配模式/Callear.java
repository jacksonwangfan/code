package com.wf.code.设计模式.适配器模式.对象适配模式;

/**
 * @auter wf
 * @date 2021/1/21
 */
public class Callear {
    public static void main(String[] args) {
        AndroidLine androidLine = new AndroidLine();
        Anddroid_iPhone_Adapter adapter = new Anddroid_iPhone_Adapter(androidLine);
        adapter.lightning();
    }
}
