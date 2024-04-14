package com.wf.code.面试遇到的算法.MetaAPP;

/**
 * MateApp 一面第二道算法
 * 取法：只能一个一个的取或者一次性取三个，输入数字，输出一共有多少取法。
 */
public class 数字一共有多少取法 {

    public static void main(String[] args) {
        //System.out.println(getCount(10));
        int[] arr = {1,2,3,4,5,6,6,9,0,0,0};
        insert(arr, 5, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    private static int getCount(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }else {
            return getCount(n-3) + 1;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 1;
        for (int i = 0; i < nums2.length; i++) {
            int i2 = nums2[i];
            for (int j = 0; j < nums1.length-1; j++) {
                left = i;
                right = i+1;

                int temp = 0;
                if (i2 < nums1[0]) {
                    temp = nums1[right];
                }

                if (i2 >= nums1[left] && i2 < nums1[right]) {

                }

                if (i2 >= nums1[left] && i2 == 0){

                }

            }

        }
    }


    //给一个数把这个数插入数组，使数组保持有序
    private static void insert(int[] arr, int val, int left){
        for (int j = left; j < arr.length - 1; j++, left++) {
            int right = left+1;
            int temp = 0;
            if (val < arr[0]) {
                temp = arr[right];
                arr[right] = val;
                insert(arr, temp, left);
            }

            if (val >= arr[left] && val < arr[right]) {
                temp = arr[right];
                arr[right] = val;
                insert(arr, temp, left);
            }

            if (val >= arr[left] && arr[right] == 0){
                arr[right] = val;
                return;
            }
        }
    }
}
