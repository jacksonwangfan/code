package com.wf.code.未知分类;

import java.util.HashMap;
import java.util.Map;

/**
 * 要求时间复杂度 O(n) 空间复杂度 O(1)
 * @auter wf
 * @date 2021/1/23
 */
public class 有序的数组中找出两个数的和等于给定的数字 {

    public static void main(String[] args) {
        int[] arr= {0,1,2,3,4,5,11,12,15};
        System.out.println(searchSum(arr, 5));
    }

    //假设是升序
   private static Map<Integer,Integer> searchSum(int[] arr,int target){
       if (arr==null || arr.length==0) return null;
       Map map = new HashMap();
       int low = 0;
       int hight = arr.length-1;
       while (low<hight){
           int sum = arr[low]+arr[hight];
           if (sum==target) {
               map.put(arr[low],arr[hight]);
               ++low;
               continue;
           }
           if (sum>target) {
               --hight;
           }else {
               ++low;
           }
       }
       return map;
   }

}
