package com.wf.code.未知分类;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List result = 三数之和.threeSum(nums);
        System.out.println(result.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(null == nums || nums.length < 3) {
            return list;
        }

        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //对i去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0 ) break;

            int R = nums.length - 1;
            int L = i + 1;
            while (L < R) {
                //target = nums[i] + nums[L] + nums[R]
                int tempVal = (nums[i] + nums[L] + nums[R]);
                if (tempVal == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[L], nums[R]);
                    list.add(temp);
                    //对Left去重
                    while (L < R && (nums[L + 1] == nums[L])) ++L;
                    //对Right去重
                    while (L < R && nums[R - 1] == nums[R] ) --R;
                    L++;
                    R--;
                } else if (tempVal > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        return list;
    }

    /** 三数之和**/
    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    你返回所有和为 0 且不重复的三元组。*/
    private List<List<Integer>> getThreeNumbersSum(int[] array){
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (null == array || array.length == 0) {
            return lists;
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i >= 1 && array[i-1] == array[i]){
                continue;
            }

            int L = i+1, R = array.length - 1;
            while (L < R) {
                int res = array[i] + array[L] + array[R];
                if (res == 0) {
                    //收集答案
                    List<Integer> integers = Arrays.asList(array[i], array[L], array[R]);
                    lists.add(integers);
                    while (L < R && array[L] == array[L+1]) L++;
                    while (L < R && array[R] == array[R-1]) R--;
                    R--;
                    L++;
                }

                if (res > 0) R--;
                if (res < 0) L++;
            }
        }

        return lists;
    }


}
