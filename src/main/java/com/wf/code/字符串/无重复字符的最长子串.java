package com.wf.code.字符串;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    /**
     * 无重复字符的最长子串
     */
    public static int maxLength(String s) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (set.contains(chars[j])){
                    set.clear();
                    break;
                } else {
                    set.add(chars[j]);
                    int size = set.size();
                    res = Math.max(size, res);
                }
            }
        }
        return res;
    }

    /**
     * 无重复字符的最长子串(滑动窗口)
     */
    public static int maxLength1(String s) {
        if (null == s){
            return 0;
        }
        int left = 0, right = 0, res = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            while (set.contains(chars[i])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[i]);
            int temp = right - left + 1;
            right++;
            res = Math.max(res, temp);
        }
        return res;
    }
}
