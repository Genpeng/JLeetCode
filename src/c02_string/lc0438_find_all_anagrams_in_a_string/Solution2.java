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
class Solution2 {
    /**
     * Approach 2: Sliding Window (variable window)
     *
     * @param s String, the input string
     * @param p String, the pattern string
     * @return List<Integer>, all the start indices of p's anagrams in s
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 题意：
        // 已知两个字符串 s 和 p，要求找出 s 中所有 p 的异位词（anagram），并返回它们的起始位置

        // 解法2：滑动窗口（可变窗口）
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(1)

        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) {
            return ans;
        }
        // 步骤1：统计 p 中所有字符的出现频次
        int[] freq = new int[128];
        for (int i = 0; i < n; ++i) {
            ++freq[p.charAt(i)];
        }
        // 步骤2：维护一个大小可变的窗口，一开始先尽可能向右滑动，直到包含字符串 p 的异位词（anagram），
        // 然后开始收缩（左边界），收缩时，判断当前窗口是否为 p 的异位词，如果是的话，加入结果中
        int count = n;
        char c;
        for (int li = 0, ri = 0; ri < m; ++ri) {
            c = s.charAt(ri);
            if (freq[c]-- > 0) {
                --count;
            }
            while (count == 0) {
                if (ri - li + 1 == n) {
                    ans.add(li);
                }
                c = s.charAt(li++);
                if (freq[c]++ == 0) {
                    ++count;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(solu.findAnagrams("abab", "ab")); // [0, 1, 2]
    }
}