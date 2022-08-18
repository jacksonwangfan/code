package com.wf.code.动态规划;

public class 机器人路径 {

    /**
     * 一个机器人位于一个 m*n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？
     */
    //二维数组动态规划
    public static int findPaths(int m, int n){
        //初始化
        int[][] res = new int[m][n];
        //边界处理
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        //初始化值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        //返回想要的结果
        return res[m-1][n-1];
    }
}
