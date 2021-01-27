package com.wf.code.未知分类;

/**
 * 在不消耗额外空间的情况下 判断，负数一定不是回文数字
 * @auter wf
 * @date 2021/1/23
 */
public class 回文数字 {
    public static void main(String[] args) {
        System.out.println( (char) ('a'-32));
        System.out.println(isbackNum(123321));
    }

    public static boolean isbackNum(int num){
        int temp = 0;
        if (num==0) return true;
        if (num<0 || num%10==0) return false;
        while (num>temp){
            temp = num%10+temp*10;
            num = num/10;
        }
        return num == temp || num == temp/10;
    }
}
