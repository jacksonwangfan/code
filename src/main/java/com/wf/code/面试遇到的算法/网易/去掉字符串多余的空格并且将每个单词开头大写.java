package com.wf.code.面试遇到的算法.网易;

/**
 * 网易技术终面，去掉字符串多余的空格并且将每个单词开头大写
 * 例如
 * 输入：hello    word
 * 输出：Hello Word
 */
public class 去掉字符串多余的空格并且将每个单词开头大写 {

    public static void main(String[] args) {
        System.out.println(processString(" my  Name   is   wang fan!    hello    word    !"));
    }

    private static String processString(String s){
        if (null == s){
            return s;
        }
        char[] chars = s.toCharArray();
        char spase = ' ';
        int moveCount = 0;
        //首字母大写处理
        if (chars.length >=2 ){
            if (chars[0] != spase){
                chars[0] = Character.toUpperCase(chars[0]);
            }
            if (chars[0]== spase && chars[1] != spase){
                chars[1] = Character.toUpperCase(chars[1]);
            }
        }
        for (int i = 0; i < chars.length-1; i++) {
            //遇到连续的两个空格
            while (spase == chars[i] && spase == chars[i+1]){
                moveCount++;
                //连续空格后面的第一个字母变成大写
                for (int j = i+1; j < chars.length; j++) {
                    if (chars[j] != spase){
                        chars[j] = Character.toUpperCase(chars[j]);
                        break;
                    }
                }
                //从i+1位置全部向前移动
                for (int j = i+1; j < chars.length-1; j++) {
                    chars[j] = chars[j+1];
                }
            }
        }
        //结尾处理
        for (int j = chars.length-1; 0 < moveCount; j--) {
            chars[j] = spase;
            moveCount --;
        }
        return String.valueOf(chars);
    }

}
