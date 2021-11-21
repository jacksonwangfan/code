package com.wf.code.查找;

public class 二分查找 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 11, 19};
        System.out.println(binarySearch1(19, array, 0, array.length - 1));
    }

    //非递归方式
    public static int binarySearch1(int target,int arr[],int left,int right){
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (arr[mid]==target){
                return mid;
            }
            if (arr[mid]>target) {
                right = mid - 1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    //递归方式
    public static int binarySearch(int target, int arr[], int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(target, arr, left, mid - 1);
        } else {
            return binarySearch(target, arr, mid + 1, right);
        }

    }

}
