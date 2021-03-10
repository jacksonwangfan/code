package com.wf.code.动态规划;

import java.util.Arrays;

/**
 * 给定数组arr,返回arr的最长递增子序列长度，比如arr=[2,1,5,3,6,4,8,9,7],那么最长递增子序列为[1,3,4,8,9] ]，所以返回这个最长递增子序列的长度5。
 * 基本思路就是创建dp[]数组，每个位置记录该位置的最长递增子序列
 * @auter wf
 * @date 2021/1/22
 */
public class 最长递增子序列 {

   private static int getLIS1(int[] arr){
        if (arr==null|| arr.length==0) return -1;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
       for (int i = 1; i < arr.length; i++) {
           dp[i] = 1;
           for (int j = 0; j < i; j++) {
               //比对前面的dp值，找到最优解
               if (arr[j]<arr[i] && dp[j]>dp[i]-1){
                   dp[i] = dp[j]+1;
               }
           }
       }
       return dp[arr.length-1];
   }

    public static void main(String[] args) {
        /**
         * 1 2 3 4
         * 4 5 6 5
         * 7 8 9 6
         * 1 2 3 4
         *
         * 7 4 1
         * 8 5 2
         * 9 6 3
         */

        int[] arr = {2,1,5,3,6,4,8,9,7,6,11,1,2,3,4,5,6,7,8,9,10};
        System.out.println(getLIS1(arr));
    }

}
