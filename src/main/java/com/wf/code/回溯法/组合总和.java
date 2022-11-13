package com.wf.code.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
 *
 * 示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
 */
public class 组合总和 {

    private static LinkedList<Integer> temp = new LinkedList<>();
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int []arr = {2,3,5};

        backtracking(arr, 8, 0, 0);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }

    private static void backtracking(int []arr, int target, int currSum, int startIndex) {
        // base case
        if (currSum > target) {
            return;
        }

        if (currSum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        //将不符合条件的剪枝掉
        for (int i = startIndex; (i < arr.length && (currSum + arr[i]) <= target); i++) {
            temp.addLast(arr[i]);
            currSum += arr[i];
            backtracking(arr, target, currSum, i);
            currSum -= arr[i];
            temp.removeLast();
        }

    }

}
