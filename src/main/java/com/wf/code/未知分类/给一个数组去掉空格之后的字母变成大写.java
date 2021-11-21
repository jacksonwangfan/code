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


   public static void matchCase(char[] arr){

   }

   //去空格，整体思路就是遇到两个连续的空格，就去后方找一个不是空格的，放到第二个空格的位置
    private static void trim(char[] arr){
        int curr = 0;
        for (int i = 1; i < arr.length; i++) {
            curr = i-1;
            //遇到两个连续的空格
            if (arr[curr]==' ' && arr[i]==' '){
                while (arr[curr]==' ' && arr[i]==' ' && i<arr.length-1){
                    move(arr,i);
                }
            }
        }
    }
    //首字母大写
    public static void mach(char[] arr){

    }

    //将数组全部向后挪一位
    private static void move(char arr[],int index){
        for (int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
    }

}
