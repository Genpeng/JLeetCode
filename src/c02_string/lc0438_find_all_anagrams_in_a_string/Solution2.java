package c02_string.lc0438_find_all_anagrams_in_a_string;

import java.util.LinkedList;
import java.util.List;

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
class Solution2 {
    /**
     * Approach 2: Sliding Window (variable window)
     *
     * @param s String, the input string
     * @param p String, the pattern string
     * @return List<Integer>, all the start indices of p's anagrams in s
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return result;
        }
        // 步骤1：统计 p 中所有字符的出现频次
        int[] freqMap = new int[128];
        for (char c : p.toCharArray()) {
            ++freqMap[c];
        }
        // 步骤2：用一个大小可变的窗口向右滑动
        int count = n;
        char c;
        for (int li = 0, ri = 0; ri < m; ++ri) {
            c = s.charAt(ri);
            if (freqMap[c]-- > 0) {
                --count;
            }
            while (count == 0) {
                if (ri - li + 1 == n) {
                    result.add(li);
                }
                c = s.charAt(li++);
                if (++freqMap[c] > 0) {
                    ++count;
                }
            }
        }
        return result;
    }
}