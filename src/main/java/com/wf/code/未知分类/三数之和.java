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

}
