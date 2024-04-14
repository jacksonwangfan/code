package com.wf.code.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * @auter wf
 * @date 2021/1/10
 */
public class QS {
    public static void main(String[] args) {

       int[] nums1 = {1,2,3,0,0,0};
       int[] nums2 = {2,5,6};
       QS.merge(nums1,1, nums2,2);
        /*int[] arr = {1, 3, 4, 2, 56, 1, 3, 9, 3, 9, 3, 8, 46, -1, 356};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(s -> System.out.println(s));*/


    }


    public static void sort(int[] arr,int low,int hight){
        if (low<hight){
            int index = getIndex(arr,low,hight);
            sort(arr,low,index-1);
            sort(arr,index+1,hight);
        }
    }

    public static int getIndex(int[]arr,int low,int height){
        int temp = arr[low];
        while (low<height){
            while (low<height && arr[height]>=temp){
                height--;
            }
            arr[low] = arr[height];
            while (low<height && arr[low]<=temp){
                low++;
            }
            arr[height] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i< nums2.length ;i++) {
            int item = nums2[i];
            for (int j = 0; j< nums1.length ; j++){
                if (nums1[j] == 0){
                    nums1[j] = item;
                    break;
                }

                if (nums1[j] > item){
                    for (int index = nums1.length-1; j < index; index--){
                        nums1[index] = nums1[index-1];
                    }

                    nums1[j] = item;
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
