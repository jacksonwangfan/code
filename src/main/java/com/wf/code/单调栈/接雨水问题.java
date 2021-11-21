package com.wf.code.单调栈;

import java.util.Stack;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * |
 * |               _
 * |       _       _ _    _
 * |   _   _ _   _ _ _ _  _  _
 * + _ _ _ _ _ _ _ _ _ _  _  _   _
 *   0 1 2 3 4 5 6 7 8 9 10  11  12
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 接雨水问题 {
    /*
    * 使用单调递减栈的方式，维护一个单调递减栈。每次将数组的的值与栈顶的元素比较，如果第i个数组的值比栈顶元素大（右边界高度），栈顶元素出栈记录一下当前值（中间高度也就是桶底的厚度），
    * 然后栈顶元素在出栈（左边界高度），然后找到左边界和右边界中较小的值（较小的的值即为桶能装水得最大高度），然后计算高度和宽度（右边界-左边界-1）
    * */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        Integer are = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                //记录桶底的厚度所在的位置
                int bottomIndex = stack.pop();
                //如果栈为空就不可能有左边界了（也就不能装下水，直接跳出循环）
                if (stack.isEmpty()) {
                    break;
                }
                //找到桶底左右 较小的边界既是桶装水的深度(找桶的水的深度)
                int h = Math.min(height[stack.peek()],height[i])-height[bottomIndex];
                //找到桶有多宽
                int w = i-stack.peek()-1;
                are += h*w;
            }
            stack.push(i);
        }
        return are;
    }

}
