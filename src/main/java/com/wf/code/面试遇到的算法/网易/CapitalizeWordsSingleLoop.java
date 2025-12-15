package com.wf.code.面试遇到的算法.网易;

public class CapitalizeWordsSingleLoop {
    public static int capitalizeWords(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int writeIndex = 0;        // 写入位置
        boolean newWord = true;    // 是否是新单词的开始
        boolean lastCharWasSpace = false;  // 上一个处理的字符是否是空格

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == ' ') {
                // 如果是空格
                if (writeIndex > 0 && !lastCharWasSpace) {
                    // 前面有非空格字符，且上一个不是空格，保留这个空格
                    chars[writeIndex++] = ' ';
                }
                // 更新状态
                newWord = true;
                lastCharWasSpace = true;
            } else {
                // 如果是非空格字符
                if (newWord) {
                    // 新单词的首字母大写
                    chars[writeIndex++] = Character.toUpperCase(c);
                    newWord = false;
                } else {
                    // 单词的非首字母小写
                    chars[writeIndex++] = Character.toLowerCase(c);
                }
                lastCharWasSpace = false;
            }
        }

        // 移除可能出现在末尾的空格
        if (writeIndex > 0 && chars[writeIndex - 1] == ' ') {
            writeIndex--;
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        // 测试用例
        String[] tests = {
                "hello world",
                "  multiple   spaces   between   words  ",
                "jAVA programming IS fun",
                "a",
                "",
                "   ",
                "the QUICK brown fox"
        };

        for (String test : tests) {
            char[] chars = test.toCharArray();
            System.out.print("原始: \"" + test + "\"");
            System.out.print(" -> ");

            int len = capitalizeWords(chars);
            String result = new String(chars, 0, len);
            System.out.println("\"" + result + "\" (长度: " + len + ")");
        }

        // 详细跟踪一个例子
        System.out.println("\n=== 详细跟踪处理过程 ===");
        String example = "  hello   WORLD  ";
        char[] exampleChars = example.toCharArray();
        System.out.println("输入: \"" + example + "\"");
        System.out.println("输入数组: " + java.util.Arrays.toString(exampleChars));

        int resultLen = capitalizeWords(exampleChars);
        System.out.println("输出: \"" + new String(exampleChars, 0, resultLen) + "\"");
        System.out.println("最终数组: " + java.util.Arrays.toString(exampleChars));
    }
}