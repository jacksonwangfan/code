package com.wf.code.单调队列;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @auter wf
 * @date 2020/12/26
 *
 * 用单调队列（也就是双端队列）来做 保证单调队列的头到尾是单调递减的
 */
public class 滑动窗口的最大值 {

    public static void main(String[] args) {
       int[]arr = {1,3,-1,-3,5,3,6,7};
       int[] l =  maxSlidingWindow(arr,3);
        Arrays.stream(l).forEach(System.out::print);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //准备好 存储结果的数组
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList();
        if (nums.length == 0) return res;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //队首元素不能过期，为什么只能担心队首元素不能过期呢，因为每循环一次 我们都取队首元素作为 窗口内的最大值
            // i-deque.peekFirst() 判断队首元素距离窗口长度 ，如果长度大于窗口长度那么移除队首元素
            //为什么不用判断队首的后一个元素也过期了呢，因为我们每次入队的时候只是入了一个元素，由于窗口大小固定，那么过期元素最多也只能是一个，
            //所以只用从队首开始判断第一个元素是否过期就可以。
            if (!deque.isEmpty() && i-deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            //开始向单调队列中添加
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //满足窗口大小， 我们就收集一次答案。。i从零开始的 ，所以为了和k比较要给 i 加 1
            if (i+1>=k){
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}