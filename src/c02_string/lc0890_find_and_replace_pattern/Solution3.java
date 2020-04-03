package c02_string.lc0890_find_and_replace_pattern;

import java.util.*;

/**
 * This is the solution of No. 890 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x
 * in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 * Note:
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * 题意解读：
     * a word matches pattern <=> 在pattern和word之间存在一对一的映射 <=> pattern和word之间不能有一对多和多对一的情况
     *
     * 解法三：转换成位置编码的比较
     * 解法三的思路与解法一是一致的，只是为了判断pattern和word之间是否是一对一映射，采用了另一种方式——将pattern和word
     * 转换成位置编码，如果pattern和word是一对一的，那么位置编码应该是一致的。
     *
     * 时间复杂度：O(N * K)，其中N是字符串的数目，K表示字符串的长度
     * 空间复杂度：O(K)
     *
     * Runtime: 2 ms, faster than 58.96% of Java online submissions for Find and Replace Pattern.
     * Memory Usage: 38.7 MB, less than 7.69% of Java online submissions for Find and Replace Pattern.
     *
     * @param words String[], a list of words
     * @param pattern String, a string represents a pattern
     * @return String[], a list of the words that match the given pattern
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("[ERROR] The input pattern must not be null!!!");
        }
        List<String> ans = new LinkedList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
        for (String word : words) {
            if (isMatch(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean isMatch(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        return Arrays.equals(transpose(word), transpose(pattern));
    }

    private int[] transpose(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int[] encoding = new int[n];
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, map.size());
            }
            encoding[i] = map.get(c);
        }
        return encoding;
    }
}