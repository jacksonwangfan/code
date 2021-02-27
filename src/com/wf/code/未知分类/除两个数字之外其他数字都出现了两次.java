package com.wf.code.未知分类;

import java.util.Arrays;

/**
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * @auter wf
 * @date 2021/2/27
 */
public class 除两个数字之外其他数字都出现了两次 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,2,4,4,77,77,11,5};
        int[] ints = singleNumbers(arr);
        Arrays.stream(ints).forEach(i->{
            System.out.println(i);
        });
    }

    public static int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int ab = 0;
        for (int i = 0; i < nums.length; i++) {
            ab ^= nums[i];
        }
        //提取最右边的第一个一
        int flag = ab&(~ab+1);
        System.out.println(flag);
        for (int i = 0; i < nums.length; i++) {
            if ((flag&nums[i])==0){
                res[0] ^= nums[i];
            }else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
