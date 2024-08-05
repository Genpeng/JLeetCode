package c02_string.lc0438_find_all_anagrams_in_a_string;

import java.util.*;

/**
 * This is the solution of No. 438 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p
 * will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
class Solution1 {
    /**
     * Approach 1: Sliding Window (fixed window)
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * @param s String, the input string
     * @param p String, the pattern string
     * @return List<Integer>, all the start indices of p's anagrams in s
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 题意：
        // 已知两个字符串 s 和 p，要求找出 s 中所有 p 的异位词（anagram），并返回它们的起始位置

        // 解法1：滑动窗口（固定窗口）
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(1)

        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return ans;
        }

        // 步骤1：统计字符串 p 中字符的频次
        Map<Character, Integer> freq = new HashMap<>(26);
        char c;
        for (int i = 0; i < n; ++i) {
            c = p.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 步骤2：用一个长度为 n（字符串 p 的长度）的窗口向右滑动，每次向右滑动一步，
        // 如果当前窗口是 p 的异位词，则将起始位置加入到结果中
        int matched = 0;
        for (int li = 0, ri = 0; ri < m; ++ri) {
            c = s.charAt(ri);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    ++matched;
                }
            }
            if (ri >= n-1) {
                if (matched == freq.size()) {
                    ans.add(li);
                }
                c = s.charAt(li++);
                if (freq.containsKey(c)) {
                    if (freq.get(c) == 0) {
                        --matched;
                    }
                    freq.put(c, freq.get(c) + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(solu.findAnagrams("abab", "ab")); // [0, 1, 2]
    }
}