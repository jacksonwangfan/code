package com.wf.code.前缀树;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @auter wf
 * @date 2021/1/22
 */
public class Trie {
    //这里说明一下，实际上这个就是一个数组里面包了一个数组，一直包下去
    Trie[] arr = new Trie[26];
    boolean isEnd = false;
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if (curr.arr[c]==null) curr.arr[c] = new Trie();
            curr = curr.arr[c];
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            if (curr.arr[c]==null) return false;
            curr = curr.arr[c];
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i)-'a';
            if (curr.arr[c]==null) return false;
            curr = curr.arr[c];
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("afcgjklkjljkl");
        System.out.println(trie.search("afcgjklkjljkl"));
        System.out.println(trie.startsWith(""));
    }
}
