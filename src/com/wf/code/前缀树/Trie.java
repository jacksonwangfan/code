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
    private Trie root;
    private boolean isEnd;
    private int count;
    private Trie[] dicttro;
    private Trie next;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

    /** Initialize your data structure here. */
    public Trie() {
            isEnd = true;
            count = 0;
            dicttro = new Trie[26];
            root = new Trie();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = root;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("afcg");
    }
}
