package com.wf.code.未知分类;

/**
 * @auter wf
 * @date 2021/1/26
 */
public class 给一个数组去掉空格之后的字母变成大写 {


    public static void main(String[] args) {
        char[] arr = "hello        word   match ".toCharArray();
        trim(arr);
        for (char c : arr) {
            System.out.print(c);
        }
    }

   //去空格，整体思路就是遇到两个连续的空格，就去后方找一个不是空格的，放到第二个空格的位置
    private static void trim(char[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == ' ') {
                if (arr[i+1] == ' ') {
                    while (arr[i+1] == ' ') {
                        for (int j = i+1; j < arr.length-1; j++) {
                            arr[j] = arr[j+1];
                        }
                    }
                }
            } 
        }
    }

    //从offset位置开始是否有两个连续的空格
    private static boolean isTwoSpace(char[] arr, int offset) {
        if (arr.length < offset) return false;
        char spaceCodeValue = ' ';
        for ( ;offset < arr.length-1; offset++) {
            if (arr[offset] == spaceCodeValue) {
                if (arr[offset+1] == spaceCodeValue) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //从index向前挪动一位
    /*private static void move(char[] arr, int index) {
        if (arr.length < index) return;
        int offset = index;
        for ( ; offset < arr.length-1; offset++) {
            arr[offset] = arr[offset+1];
        }
    }*/
   
}
