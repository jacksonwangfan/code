package com.wf.test;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @auter wf
 * @date 2021/2/25
 */
public class Demo {
    String name ;

    public static void main(String[] args) {
        try {
            String s = new String("jhghgjkh".getBytes(), "UTF-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("the sky      is bule".split(" ").length);
        Demo demo = new Demo();
        demo.name = "测试";
        Demo demo1 = demo.getDemo();

        System.out.println(demo.name);
        System.out.println(demo1.name);
        System.out.println(demo1==demo);
    }

    public Demo getDemo(){
        return this;
    }
}
