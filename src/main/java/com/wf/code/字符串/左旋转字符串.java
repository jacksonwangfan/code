package com.wf.code.字符串;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auter wf
 * @date 2021/1/17
 */
public class 左旋转字符串 {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int)'A');
        System.out.println((int)'z');
        System.out.println((int)'Z');
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}
