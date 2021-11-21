package com.wf.code.动态规划;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class 青蛙跳台问题 {

    public static void main(String[] args) {
        System.out.println(numWays(46));
    }

    public static int numWays(int n) {
        int[] dp = new int[n+1];
        //定义初始值
        if(n>=0) dp[0] = 1;
        if (n>=1) dp[1] = 1;
        if (n>=2) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2]; //递推关系
            dp[i] =dp[i]%1000000007;
        }
        //返回我们想要的
        return dp[n];
    }

}
