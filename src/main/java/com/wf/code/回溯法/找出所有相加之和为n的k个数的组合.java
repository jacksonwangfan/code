package com.wf.code.回溯法;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 找出所有相加之和为n的k个数的组合 {


    /**
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
     *
     * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */

    private static LinkedList<List<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();

    private static void backtracking(int sum, int targetSum, int k, int indexStart){
        //对不符合的结果剪枝
        if (sum > targetSum){
            return;
        }
        if (path.size() == k && targetSum == sum){
            res.add(new ArrayList<>(path));
            return;
        }
        //这里是如何剪枝的？
        //对遍历的宽度剪枝
        for (int i = indexStart; i <=  9 - (k-path.size()); i++) {
            path.add(i);
            sum = sum + i;
            backtracking(sum, targetSum, k, i+1);
            //回溯（得到一个正解之后，要把正解回退回去，方便继续下一次递归）
            path.removeLast();
            //回溯（得到一个正解之后，要把正解回退回去，方便继续下一次递归）
            sum = sum - i;
        }
    }


    public static void main(String[] args) {
        backtracking1(0,3,9, 1);
        //backtracking1(0,3,7, 1);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
     *
     * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */

    private static void backtracking1(int sum, int k, int targetSum, int startIndex) {
        if (sum > targetSum){
            return;
        }
        if (sum == targetSum && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < targetSum; i++) {
            path.add(i);
            sum += i;
            backtracking1(sum, k, targetSum, i+1);
            path.removeLast();
            sum -= i;
        }
    }

}
