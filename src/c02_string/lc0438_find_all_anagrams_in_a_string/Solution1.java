package c02_string.lc0438_find_all_anagrams_in_a_string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 438 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p
 * will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
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
 *
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
class Solution1 {
    /**
     * Approach 1: Sliding Window (fixed window)
     *
     * @param s String, the input string
     * @param p String, the pattern string
     * @return List<Integer>, all the start indices of p's anagrams in s
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        // 步骤1：统计 p 中所有字符的频次
        Map<Character, Integer> freqMap = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // 步骤2：用一个长度为 p.length() 的窗口向右滑动，当窗口中的子串是 p 的排列时，
        // 将窗口的左边界加入到结果中
        int matched = 0;
        char c;
        for (int li = 0, ri = 0; ri < s.length(); ++ri) {
            c = s.charAt(ri);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    ++matched;
                }
            }
            if (matched == freqMap.size()) {
                result.add(li);
            }
            if (ri >= p.length() - 1) {
                c = s.charAt(li++);
                if (freqMap.containsKey(c)) {
                    if (freqMap.get(c) == 0) {
                        --matched;
                    }
                    freqMap.put(c, freqMap.get(c) + 1);
                }
            }
        }
        return result;
    }
}