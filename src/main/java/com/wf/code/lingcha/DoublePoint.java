package com.wf.code.lingcha;

//双指针类问题
public class DoublePoint {

    //固定指针的双指针类问题

    /**
     * 给你字符串 s 和整数 k 。
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     */
    public int maxVowels(String s, int k) {
        if ("".equals(s) || k <= 0) {
            return 0;
        }

        int res = 0;
        //收集第一个窗口的答案
        for (int i = 0 ;i < k; i++) {
            if (isVowels(s.charAt(i))) {
                res++;
            }
        }

        int temp = res;
        //开始滑动 i是右边界 i-k 是左边界 k是窗口大小
        for (int i = k; i < s.length(); i++) {
            //遇到元音字符 结果+1
            if (isVowels(s.charAt(i))) {
                temp ++;
            }

            //左侧遇到非元音字符 结果-1
            if (isVowels(s.charAt(i - k))) {
                temp --;
            }

            //每滑动一次收集一次答案
            res = Math.max(res, temp);
        }
        //返回结果
        return res;
    }

    public boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    /**
     * 643. 子数组最大平均数 I
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     *
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     */
    public double findMaxAverage(int[] nums, int k) {

        return 0.0;
    }

}
