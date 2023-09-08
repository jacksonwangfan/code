package com.wf.code.回溯法;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 */
public class 复原IP地址 {

    private List<String> res = new ArrayList<>();

    private LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        复原IP地址 a = new 复原IP地址();
        a.backtracking("25525511135", 0);
        for (String re : a.res) {
            System.out.print(re+"\t");
            System.out.println();
        }
    }

    public void backtracking(String s, int startIndex){
       if (startIndex>=s.length()){
           StringBuilder temp = new StringBuilder();
           for (String s1 : path) {
               temp.append(s1);
           }
           res.add(temp.toString());
       }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            //（每个整数位于 0 到 255 之间组成，且不能含有前导 0）
            if (isSupport(substring)){
                path.addLast(substring+".");
            }
            backtracking(s, i+1);
            path.removeLast();
        }
    }

    private boolean isSupport(String substring){
        char c = substring.charAt(0);
        if (c == '0') {
            return false;
        }
        int num = Integer.parseInt(substring);
        if ( num > 255) {
            return false;
        }
        return true;
    }



}
