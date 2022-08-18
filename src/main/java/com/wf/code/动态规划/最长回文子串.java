package com.wf.code.动态规划;

/**
 * 最长回文子串
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cabaca"));
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (s == null){
            return null;
        }
        if (length < 2){
            return s;
        }
        int begin = 0, offset = 0;
        boolean[][] res = new boolean[length][length];
        char[] chars = s.toCharArray();
        //回文字符串长度枚举，最长的回文串为chars.length-1
        for (int Length = 1; Length <= chars.length-1; Length++) {
            //从左侧开始枚举
            for (int left = 0; left < length; left++) {
                //右侧 = 左侧索引 + 枚举的字符串长度 - 1;
                int right = left + Length - 1;
                if (left - Length < 2){
                    res[left][right] = true;
                }
                if (right > length) {
                    break;
                }
                if (chars[left] != chars[right]){
                    res[left][right] = false;
                }else {
                    if (right -left < 3){
                        res[left][right] = true;
                    }else {
                        res[left][right] = res[left+1][right-1];
                    }
                }
                if (res[left][right] && right-left + 1 > offset){
                    offset = right - left + 1;
                    begin = left;
                }
            }
        }
        return s.substring(begin, offset);
    }
}
