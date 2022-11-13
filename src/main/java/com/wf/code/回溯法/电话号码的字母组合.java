package com.wf.code.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * const string letterMap[10] = {
 *     "", // 0
 *     "", // 1
 *     "abc", // 2
 *     "def", // 3
 *     "ghi", // 4
 *     "jkl", // 5
 *     "mno", // 6
 *     "pqrs", // 7
 *     "tuv", // 8
 *     "wxyz", // 9
 * };
 *
 */

public class 电话号码的字母组合 {


    private static final String []arr = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private static StringBuffer stringBuffer = new StringBuffer();

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        backtracking(0, "234");
        for (String value : result) {
            System.out.print(value + "\t");
        }
    }

    /**
     *
     * @param index
     * @param digits
     */
    private static void backtracking(int index, String digits){
        //base case 树的深度达到数字长度，例如23就是用户按了2和3两个按键
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }

        char num = digits.charAt(index);
        int s = num-'0';
        String element = arr[s];
        for (int i = 0; i < element.length(); i++) {
            stringBuffer.append(element.charAt(i));
            backtracking(index+1, digits);
            stringBuffer.deleteCharAt(index);
        }

    }

}


