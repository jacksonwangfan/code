package com.wf.code.sort;

import java.util.Arrays;

/**
 * @auter wf
 * @date 2020/12/8
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 56, 1, 3, 9, 3, 9, 3, 8, 46, -1, 356};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(s -> System.out.println(s));
    }

    public static void quickSort(int arr[], int low, int hight) {
        if (low < hight) {
            int index = getIndex(arr, low, hight);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, hight);
        }
    }

    public static int getIndex(int arr[], int low, int hight) {
        //获取基准值，将low位置值设置基准值
        int temp = arr[low];
        //循环处理使值均匀的分布在基准值两侧
        while (low < hight) {
            //遍历右侧，找到一个比基准值temp小的跳出循环
            while (low < hight && arr[hight] >= temp) {
                hight--;
            }
            //放到low号坑位去（temp已经保存了[low]位置的值）
            arr[low] = arr[hight];
            //遍历数组左侧，找到一个比基准值temp大的数，跳出while
            while (low < hight && arr[low] <= temp) {
                low++;
            }
            //放到 hight 的坑位里面去
            arr[hight] = arr[low];
        }
        //当上面的操作把数组划分为比基准值大和小的两个区域时，这事low和hight 相遇（指向基准值的位置，而temp是我们定义的基准，直接把基准值放在中间）
        arr[low] = temp;
        /*这样写也可以 表达的语义都是一样的
        arr[hight] = temp;
        return hight;*/
        return low;
    }

}
