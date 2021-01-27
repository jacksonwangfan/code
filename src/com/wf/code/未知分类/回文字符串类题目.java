package com.wf.code.未知分类;

/**
 * @auter wf
 * @date 2021/1/24
 */
public class 回文字符串类题目 {

    public static void main(String[] args) {
        System.out.println(getMaxSubLength("dccaccd"));
    }
    //求一个字符串中子串是是回文子串的最长的串的长度 时间复杂度O(n^2)
    public static int getMaxSubLength(String s){
        if ("".equals(s) || null==s) return 0;
        int max = 0;
        StringBuilder builder = new StringBuilder();
        builder.append('#');
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i)).append('#');
        }
        for (int i = 0; i < builder.toString().length(); i++) {
            int range = getRange(builder.toString(), i);
          max =  Math.max(max,range);
        }
        return max;
    }
    private static int getRange(String str,int index){
        int maxlength = 0;
        for (int i=index,j=index;i>=0 && j<str.length();i--,j++){
            if (str.charAt(i)==str.charAt(j)) {
               maxlength = Math.max(j-i,maxlength);
            }else {
                break;
            }
        }
        return maxlength/2;
    }


}
