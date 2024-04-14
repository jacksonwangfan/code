package com.wf.code.未知分类;



import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        //List result = 三数之和.threeSum(nums);
        //System.out.println(result.toString());
        System.out.println(三数之和.test("l    love you "));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(null == nums || nums.length < 3) {
            return list;
        }

        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //对i去重
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0 ) break;

            int R = nums.length - 1;
            int L = i + 1;
            while (L < R) {
                //target = nums[i] + nums[L] + nums[R]
                int tempVal = (nums[i] + nums[L] + nums[R]);
                if (tempVal == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[L], nums[R]);
                    list.add(temp);
                    //对Left去重
                    while (L < R && (nums[L + 1] == nums[L])) ++L;
                    //对Right去重
                    while (L < R && nums[R - 1] == nums[R] ) --R;
                    L++;
                    R--;
                } else if (tempVal > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        return list;
    }

    /** 三数之和**/
    /*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    你返回所有和为 0 且不重复的三元组。*/
    private List<List<Integer>> getThreeNumbersSum(int[] array){
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (null == array || array.length == 0) {
            return lists;
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i >= 1 && array[i-1] == array[i]){
                continue;
            }

            int L = i+1, R = array.length - 1;
            while (L < R) {
                int res = array[i] + array[L] + array[R];
                if (res == 0) {
                    //收集答案
                    List<Integer> integers = Arrays.asList(array[i], array[L], array[R]);
                    lists.add(integers);
                    while (L < R && array[L] == array[L+1]) L++;
                    while (L < R && array[R] == array[R-1]) R--;
                    R--;
                    L++;
                }

                if (res > 0) R--;
                if (res < 0) L++;
            }
        }

        return lists;
    }


    /**
     * 最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    private int threeSumClosest(int[] nums, int target){
        if (null == nums || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int mockValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i-1] == nums[i]) {
                i++;
                continue;
            }

            int L = i+1, R = nums.length - 1;
            while (L < R) {
                 int sum = nums[i] + nums[L] + nums[R];
                 if (Math.abs(target - sum) < Math.abs(target - mockValue)) {
                     mockValue = sum;
                 }

                while (L < R && nums[R] == nums[R-1]) R--;
                while (L < R && nums[L] == nums[L+1]) L++;

                 if (sum > target) {
                     while (L < R && nums[R] == nums[R-1]) R--;
                     R--;
                 }

                 if (sum < target) {
                     while (L < R && nums[L] == nums[L+1]) L++;
                    L++;
                 }

                 if (sum == target) {
                     return mockValue;
                 }
            }
        }

        return mockValue;
    }

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * 四数之和
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }

        for (int i = 0; i < nums.length; i++) {
            //去重
            if (i >= 1 && nums[i-1] == nums[i]){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                //去重
                if (j >= 1 && nums[j-1] == nums[j]){
                    continue;
                }

                int L = j+1, R = nums.length-1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[L], nums[R]);
                        lists.add(result);
                        while (L < R && nums[L] == nums[L+1]) L++;
                        while (L < R && nums[R] == nums[R-1]) R--;
                    }

                    if (sum > target) {
                        R--;
                    }

                    if (sum < target) {
                        L++;
                    }
                }
            }
        }

        return lists;
    }

    /**
     * 无重复字符的最长子串
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        Map<Character ,Integer> map = new HashMap<Character ,Integer>();
        int size = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character item = chars[i];
            if (map.containsKey(item)) {
                left = Math.max(left, map.get(item) + 1);
            }

            map.put(item, i);
            size = Math.max(size, i - left +1);
        }

        return size;
    }


    /**
     * 最长回文字串 从种间向两侧扩散，
     * 每一个字符都要扩散一遍，向左找到第一个和基准不一样的字符，然后向右找到第一个和基准不一样的，
     * 最后左右比较左右两侧的，字符是否一样，如果一样就满足回文子串。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || "".equals(s) || s.length() == 1) {
            return s;
        }

        int left = 0;
        int L = 0;
        int R = 0;
        int size = 0;
        int maxSize = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            L = i - 1;
            R = i + 1;
            while(L >= 0 && chars[i] == chars[L]) {
                L--;
                size++;
            }

            while(R < chars.length && chars[i] == chars[R]) {
                R++;
                size++;
            }

            while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
                L--;
                R++;
                size += 2;
            }

            if (maxSize < size) {
                maxSize = size;
                left = L;
            }

            size = 1;
        }

        return s.substring(left+1, left + maxSize + 1);
    }

    //网易终面题，
    public static String test(String s){
        s = s.trim();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if (i>= 1 && chars[i-1] == ' ' && chars[i] == ' ') {

                for (int j = i; j < chars.length-1; j++) {
                    chars[j] = chars[j+1];
                }
            }else {
                i++;
            }
        }

        return String.valueOf(chars);
    }



    /**
     * https://leetcode.cn/problems/zigzag-conversion/description/
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (null == s || "" .equals(s) || s.length() < numRows || s.length() < 2){
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        int i = 0, step = -1;
        for (char aChar : chars) {
            list.get(i).append(aChar);
            if (i == 0 || i == numRows - 1) {
               step = -step;
            }

            i = i + step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }

        return result.toString();
    }

}
