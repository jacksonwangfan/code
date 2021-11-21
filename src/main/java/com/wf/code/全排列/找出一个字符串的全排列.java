package com.wf.code.全排列;


/**
 * @auter wf
 * @date 2021/2/26
 */
public class 找出一个字符串的全排列 {

    volatile  int nextMax = -1;
    public static void main(String[] args) throws Exception {
        search("1234");
    }

    private static void sweap(char[] arr,int pre,int post){
        if (pre<0 || post>=arr.length){
            return;
        }
        arr[pre]^=arr[post];
        arr[post]^=arr[pre];
        arr[pre]^=arr[post];
/*        char temp = arr[pre];
        arr[pre] = arr[post];
        arr[post] = temp;*/
    }

    private static void search(String str) throws Exception {
        if (null==str || "".equals(str)) {
            throw  new Exception("param not be null");
        }
        char[] chars = str.toCharArray();
        System.out.println(str);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                //交换
                sweap(chars,i,j);
                //取结果
                String string = new String(chars);
                System.out.println(string);
                //还原
                sweap(chars,i,j);
            }
        }
    }
}
