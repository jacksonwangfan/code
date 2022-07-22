package com.wf.code.sort;

import java.util.Arrays;

/**
 * 快排回顾
 */
public class QS2 {

    public static void main(String[] args) {
        int[] arr = {1,4,5,8,23,4,6,90,3,234,454,5565,4343,1,23,9,-5,7,5,6};
        quickSort(arr, 0 ,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }
    
    private static void quickSort(int[] arr,int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high); 
        }
    }
    
    private static int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;

        /**
         * 这样也可以
         * arr[high] = temp;
         * return high;
         */
    }

}
