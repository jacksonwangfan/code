package com.wf.code.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class n中所有可能的k个数的组合 {

    /**
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */

    public static List<List<Integer>> res = new ArrayList<>();
    public static LinkedList<Integer> path = new LinkedList<>();


    public static void backtracking(int n, int k, int startIndex){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        backtracking(6, 2 , 1);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

}
