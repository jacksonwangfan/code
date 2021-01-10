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

        int[] arr = {1, 3, 4, 2, 56, 1, 3, 9, 3, 9, 3, 8, 46, -1, 356};
        sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(s -> System.out.println(s));
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
}
