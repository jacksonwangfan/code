package com.wf.code.单调栈;

import java.util.Stack;

/**
 *
 * @auter wf
 * @date 2020/12/26
 *
 * 用单调 递增的栈的方式
 * 整体思想，挨个遍历数组,当数组里面的元素大于栈顶就直接把蒜素添加进去，如果元素小于栈顶元素，栈顶元素出栈直到数组当前元素大于栈顶元素，
 * 注意在出栈的时候，是意味着前面产生了最大面积，没出栈一次计算一次面积，记录那个最大面积即可。
 * 最后栈可能会剩下一个递增的栈，此时只要计算遍历弹出这个栈的元素，每弹出一次记录一次面积，还是把原来的面积拿来比较，保存最大的就可以。。多看啊
 * 这里要注意一点就是 栈内部存储的是下标，计算长度记时候 直接用下表相减就行！
 */
public class 直方图中最大矩形的面积 {

    public static void main(String[] args) {
        int[] area = {0,1,0,2,1,0,1,20,5,1,2,1};
        System.out.println(largestRectangleArea(area));
    }

    public static int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            //保证严格单调递增栈,
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                //当遇到比栈顶小的数的时候前面就有可能形成 最大面积区域
                int currMax = stack.pop(); //获取目前最大的值（目前直方图最大高度下标），也是右边界
                if (stack.isEmpty()){
                    break;
                }
                //左边界(目前直方图的次最大高度下标)
                int left = stack.peek();
                //计算 长
                int h = currMax-left;
                //计算高
                int w = heights[currMax];
                //每次栈弹出的时候就计算一次面积然后和上次计算的面积相比较，保存最大的面积
                res = Math.max(res,h*w);
            }
            stack.push(i);
        }
        //剩下的全部都是严格单增栈
        while (!stack.isEmpty()){
            int curr = stack.pop();
            if (stack.isEmpty()){
                break;
            }
            // curr 和  left 在栈里虽然是相邻的，但是他们的值的差的含义是直方图的长跨度
            int left = stack.peek();
            res = Math.max(res,(heights.length-left-1)*heights[curr]);
        }
        return res;
    }

}
