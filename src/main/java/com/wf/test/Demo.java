package com.wf.test;


/**
 * @auter wf
 * @date 2021/2/25
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,3,4,56,78,99,101,102};
        System.out.println(findMax(arr));
    }

   static int findMax(int [] array){
        if (array==null || array.length==0) return -1;
       int left = 0;
       int right = array.length-1;
       while (left<right){
           int mid = left+(right-left)/2;
           int max = array[mid];
           if (array[mid+1]<max && array[mid-1]<max){
               return array[mid];
           }
           //说明是递增的。
           if (array[mid]<array[mid+1]){
               left = mid+1;
           }else {
               right = mid-1;
           }
       }
       return -1;
    }

    //dev的提交1
}
