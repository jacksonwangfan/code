package com.wf.code.面试遇到的算法.滴滴;

import java.util.ArrayList;
import java.util.List;

/**
 * 滴滴一面
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 要点：
 * 当前左右括号都有大于 00 个可以使用的时候，才产生分支；
 * 产生左分支的时候，只看当前是否还有左括号可以使用；
 * 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
 * 在左边和右边剩余的括号数都等于 0 的时候结算。
 *
 */
public class 括号生成 {

    public static void main(String[] args) {
        List<String> strings = buildBrackets(4);
        for (String string : strings) {
            System.out.println(string);
        }
    }

   static List<String> res = new ArrayList<>();

    public static List<String> buildBrackets(int n){
        if (n == 0){
            return res;
        }
        buildBrackets("", n, n);
        return res;
    }

    private static void buildBrackets(String brackets, int left, int right){
        if (left == 0 && right == 0){
            res.add(brackets);
            return;
        }
        if (left > 0){
            buildBrackets(brackets + "(" , left-1, right);
        }
        if (right > left){
            buildBrackets(brackets + ")" , left, right-1);
        }
    }



}
