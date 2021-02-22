package c09_design.lc0208_implement_trie_prefix_tree;

/**
 * This is the solution of No. 208 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * - You may assume that all inputs are consist of lowercase letters a-z.
 * - All inputs are guaranteed to be non-empty strings.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.containsKey(c)) {
                curr.put(c, new TrieNode());
            }
            curr = curr.get(c);
        }
        curr.setEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.containsKey(c)) {
                curr = curr.get(c);
            } else {
                curr = null;
                break;
            }
        }
        return curr;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple") == true);
        System.out.println(trie.search("app") == false);
        trie.insert("app");
        System.out.println(trie.search("app") == true);
    }
}

class TrieNode {
    /**
     * The number of children
     */
    private static final int N = 26;

    private boolean isEnd;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[N];
    }

    public boolean containsKey(char c) {
        return get(c) != null;
    }

    public TrieNode get(char c) {
        return children[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        children[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}