package com.wf.code.面试遇到的算法.MetaAPP;

/**
 * MateApp 一面第二道算法
 * 取法：只能一个一个的取或者一次性取三个，输入数字，输出一共有多少取法。
 */
public class 数字一共有多少取法 {

    public static void main(String[] args) {
        System.out.println(getCount(10));
    }


    private static int getCount(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }else {
            return getCount(n-3) + 1;
        }
    }
}
