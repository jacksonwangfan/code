package com.wf.code.动态规划;

/**
 * 给定数组arr,返回arr的最长递增子序列长度，比如arr=[2,1,5,3,6,4,8,9,7],那么最长递增子序列为[1,3,4,8,9] ]，所以返回这个最长递增子序列的长度5。
 * 基本思路就是创建dp[]数组，每个位置记录该位置的最长递增子序列
 * @auter wf
 * @date 2021/1/22
 */
public class 最长递增子序列 {

    public static int getLIS(int[] arr) {
        if (arr==null || arr.length==0) return 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1]){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = dp[i-1];
            }
        }

        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(getLIS(arr));
    }

}
