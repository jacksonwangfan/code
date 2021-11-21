package com.wf.code.前缀和;

import com.apple.laf.AquaInternalFrameUI;

public class 求任意一个数组范围内的和 {

    private int[] preSum;

    public 求任意一个数组范围内的和(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = arr[i]+preSum[i-1];
        }
    }


    public int getRangeSum(int l, int r) {
        if (l<0 || r>preSum.length) return -1;
        if(l==0) return preSum[r];
        if (l>r) return -1;
        if (l==r) return preSum[l];
        return preSum[r]-preSum[l-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,89};
        求任意一个数组范围内的和 sum = new 求任意一个数组范围内的和(arr);
        System.out.println(sum.getRangeSum(2, 2));
        System.out.println(sum.getRangeSum(4,7));
    }

}
