package com.wf.lingcha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

//双指针类问题
public class DoublePoint {

    //固定指针的双指针类问题

    /**
     * 给你字符串 s 和整数 k 。
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     */
    public int maxVowels(String s, int k) {
        if ("".equals(s) || k <= 0) {
            return 0;
        }

        int res = 0;
        //收集第一个窗口的答案
        for (int i = 0 ;i < k; i++) {
            if (isVowels(s.charAt(i))) {
                res++;
            }
        }

        int temp = res;
        //开始滑动 i是右边界 i-k 是左边界 k是窗口大小
        for (int i = k; i < s.length(); i++) {
            //遇到元音字符 结果+1
            if (isVowels(s.charAt(i))) {
                temp ++;
            }

            //左侧遇到非元音字符 结果-1
            if (isVowels(s.charAt(i - k))) {
                temp --;
            }

            //每滑动一次收集一次答案
            res = Math.max(res, temp);
        }
        //返回结果
        return res;
    }

    public boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    /**
     * 643. 子数组最大平均数 I
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     *
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     */
    public double findMaxAverage(int[] nums, int k) {
        //因为是固定窗口大小，平均数最大意味着，他们的和最大。
        if (nums == null || nums.length == 0 || k == 0) {
            return 0.0;
        }

        int sum = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }

        res = sum;
        for (int i = k; i < nums.length; i++) {
            //左侧的减掉
           sum = sum - nums[i - k];
           //右侧的加上
           sum = sum + nums[i];

           res = Math.max(res, sum);
        }
        return 1.0 * res / k;
    }

    /**
     * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
     * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
     * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr == null || k == 0) {
            return 0;
        }

        int sum = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            sum  += arr[i];
        }

        threshold = threshold * k;
        if (sum >= threshold) {
            res++;
        }

        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k];
            if (sum >= threshold) {
                res++;
            }
        }

        return res;
    }

    /**
     * 2090. 半径为 k 的子数组平均值
     * 中等
     * 提示
     * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
     * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
     * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
     * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
     * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
     */
    public int[] getAverages(int[] nums, int k) {
        return new int[0];
    }

    /**
     * 862. 和至少为 K 的最短子数组
     * 困难
     * 相关标签
     * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
     * 子数组 是数组中 连续 的一部分。
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums.length + 1;
        int left = 0;
        int s = 0;
        for (int r = 0; r < nums.length; r++) {
            s += nums[r];
            //这个while都是符合预期的
            while (s - nums[left] >= target) {
                s = s- nums[left];
                left ++;
            }

            //如果找到了第一个不符合预期的，那么就收集一次答案
            if (s>=target) ans = Math.min(ans, r - left + 1);
        }

        return ans <= nums.length ? ans : 0;

    }

    /**
     * 2958. 最多 K 个重复元素的最长子数组
     * 给你一个整数数组 nums 和一个整数 k 。
     * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
     * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
     * 请你返回 nums 中 最长好 子数组的长度。
     * 子数组 指的是一个数组中一段连续非空的元素序列。
     */
    public int maxSubarrayLength(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            map.put(nums[i], ++cnt);
            while (map.get(nums[i]) > k) {
                Integer cnt1 = map.get(nums[left]);
                map.put(nums[left], --cnt1);
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }

    /**
     * 找到最长的半重复子字符串
     * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
     * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。
     */
    public int longestSemiRepetitiveSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }

        int same = 0;
        int left = 0;
        int res = 0;
        for (int r = 1; r < s.length(); r++) {
            if(s.charAt(r) == s.charAt(r-1)) {
                same++;
            }

            if (same > 1){
                left++;
                while (s.charAt(left) != s.charAt(left-1)) {
                    left++;
                }
                same--;
            }

            res = Math.max(res, r - left + 1);
        }

        return res;
    }

    /**
     * 最大连续1的个数 III
     * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
     */
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int cnt0 = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cnt0++;//要翻转几个0
            }

            while (cnt0 > k) {
                if (nums[left] == 0) {
                    cnt0--;
                }

                left++;
            }

            res = Math.max(res, r -  left + 1);
        }
        return res;
    }

    /**
     * 2962. 统计最大元素出现至少 K 次的子数组
     * 给你一个整数数组 nums 和一个 正整数 k 。
     * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
     * 子数组是数组中的一个连续元素序列。
     */
    public long countSubarrays(int[] nums, int k) {
        if (nums == null || k == 0) {
            return 0L;
        }

        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int maxCnt = 0;
        long res = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
                if (maxVal == nums[i]){
                    maxCnt++;
                }

                while (maxCnt == k) {
                    if (nums[left] == maxVal) {
                        maxCnt--;
                    }
                    left++;
                }
                //这里是关键
                res = res + left;
        }

        return res;
    }

    /**
     * 2302. 统计得分小于 K 的子数组数目
     * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
     *
     * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
     * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
     * 子数组 是数组中的一个连续元素序列。
     */
    public long countSubarrays(int[] nums, long k) {
        if (nums == null || k == 0) {
            return 0L;
        }

        long sum = 0;
        int left = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while ((sum * (i - left + 1)) >= k){
                sum = sum - nums[left];
                left++;
            }

            //因为[i 至 left] 数组的分数是 严格小于k的，所以里面的所有子数组 ，也是严格小于K的，也就是有 i - left + 1 个
            res = res + (i - left + 1);
        }

        return res;
    }

    /**
     * 1658. 将 x 减到 0 的最小操作数
     * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
     * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
     */
    public int minOperations(int[] nums, int x) {

            return 0;
    }

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串
     */
    public String minWindow(String s, String t) {
        if ("".equals(s) || "".equals(t)) {
            return "";
        }

        int ansLeft = -1, ansRight = s.length();
        int left = 0;
        //初始化目标数组
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer cnt = target.get(t.charAt(i)) == null ? 0 : target.get(t.charAt(i));
            cnt++;
            target.put(t.charAt(i), cnt);
        }

        Map<Character, Integer> window = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            int count = window.get(c) == null ? 0 : window.get(c);
            window.put(c, ++count);

            //如果涵盖，移动左指针，让其不涵盖
            while(isCovered(target, window)){
                //收集答案，如果更短 收集答案
                if (r - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = r;
                }

                Integer cnt = window.get(s.charAt(left));
                cnt--;
                window.put(s.charAt(left), cnt);
                left++;
            }
        }

        return ansLeft < 0 ? "" : s.substring(left, ansRight + 1);
    }

    public boolean isCovered(Map<Character, Integer> target, Map<Character, Integer> window) {
        Set<Character> characters = window.keySet();
        for (Character c : characters) {
            if (! window.get(c).equals(target.get(c))) {
                return false;
            }
        }

        return true;
    }



}
