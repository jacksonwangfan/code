package com.wf.code.未知分类;

/**
 * @auter wf
 * @date 2021/2/27
 */
public class 找众数 {


    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,3,3,3,3,3,3,3,4,5,2,2,2,23,4};
        System.out.println(search(arr));
    }

    /**
     * 摩尔投票法
     * 众数必须在数组出现的次数大于 n/2
     * @param arr
     * @return
     */
    public static int search(int[] arr){
        if (arr==null || arr.length==0) return -1;
        int count = 1;
        int flag = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==flag){
                count++;
            }else {
                count--;
            }
            if (count==0){
                count=1;
                flag = arr[i];
            }
        }
        return flag;
    }
}
