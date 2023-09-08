package com.wf.code.回溯法;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 *
 * https://leetcode.cn/problems/palindrome-partitioning/
 */
public class 分割回文串 {

    private static List<List<String>> result = new ArrayList<>();

    private static LinkedList<String> temp = new LinkedList<>();

    public static void main(String[] args) {

        backtracking("a", 0);
        for (List<String> re : result) {
            for (String s : re) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
    }

    public static void backtracking(String str, int startIndex) {
        if (str == null || str.length() == 0){
            return;
        }
        if (str.length()==startIndex){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < str.length(); i++) {
            //aab
            String substring = str.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            temp.addLast(substring);

            //todo
            backtracking(str, i+1);
            temp.removeLast();

        }

    }

    private static boolean isPalindrome(String str){
        if (str.length() == 1) {
            return true;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length-i-1]) {
                    return false;
            }
        }
        return true;
    }
}
