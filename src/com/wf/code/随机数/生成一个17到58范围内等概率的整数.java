package com.wf.code.随机数;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @auter wf
 * @date 2021/1/23
 */
public class 生成一个17到58范围内等概率的整数 {
    //构造一个等概率 返回0 1发生器
    private int get(){
        int ans = 0;
        do {
            //等概率生成1-5范围内的整数
            ans = (int) (Math.random()*5+1);
        }while (ans==3);
        return ans<3?0:1;
    }

    //构造一个0-41范围内的数字随机生成方法
    private int random41(){
        int ans = 0;
        //0-41最少由六位二进制表示，此方法就是获取每一位的值（0或1）
        do {
            ans = (get()<<5)+(get()<<4)+(get()<<3)+(get()<<2)+(get()<<1)+(get());
        }while (ans>41);
        return ans;
    }
    public int getRandom58(){
        return random41()+17;
    }

    int c = 100000;
    @Test
    public void test(){
        int[] count = new int[42];
        for (int i = 0; i < c; i++) {
            int random58 = getRandom58();
            count[random58-17]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println("数字 "+(i+17)+" 出现了 "+count[i]+" 次");
        }
    }

}
