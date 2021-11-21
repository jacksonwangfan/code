package com.wf.code.枚举类;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        //eg1();
        eg2();
    }

    /**
     * 这个函数输出如下：
     * 枚举类构造函数执行
     * 枚举类构造函数执行
     * 枚举类构造函数执行
     * ONE
     */
    private static void eg1(){
        System.out.println(构造函数Demo.ONE);
    }

    /**
     * 此函数输出如下：
     * 1
     * 0
     * 2
     * 3
     */
    private static void eg2(){
        System.out.println(构造函数Demo.ONE.ordinal());
        System.out.println(构造函数Demo.ZERO.ordinal());
        System.out.println(构造函数Demo.TWO.ordinal());
        System.out.println(构造函数Demo.THREE.ordinal());

     Arrays.stream(构造函数Demo.values()).forEach(i->{
            System.out.print(i+"\t");
        });
    }
}
