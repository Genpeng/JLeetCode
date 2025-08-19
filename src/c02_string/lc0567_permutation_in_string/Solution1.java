package c02_string.lc0567_permutation_in_string;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 567 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutation-in-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * Constraints:
 * - The input strings only contain lower case letters.
 * - The length of both given strings is in range [1, 10,000].
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Sliding Window (fixed window)
     * Time Complexity: O(l1 + l2)
     * Space Complexity: O(l1)
     *
     * @param s1 String, the pattern string
     * @param s2 String, the target string to find pattern
     * @return boolean, true if s2 contains the permutation of s1
     */
    public boolean checkInclusion(String s1, String s2) {
        // 题意：
        // 已知两个字符串 s1 和 s2，判断 s1 的任意一个排列是否是 s2 的子串

        // 解法1：滑动窗口（固定大小）
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(1)

        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        // 步骤1：统计字符串 s1 的字符频次
        Map<Character, Integer> freq = new HashMap<>(26);
        char c;
        for (int i = 0; i < m; ++i) {
            c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // 步骤2：维护一个大小为 m（s1 长度）的窗口，每次向右滑动一步，
        // 如果当前窗口为 s1 的排列（或者异位词），则返回 true
        int matched = 0;
        for (int li = 0, ri = 0; ri < n; ++ri) {
            c = s2.charAt(ri);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) {
                    ++matched;
                }
            }
            if (ri >= m-1) {
                if (matched == freq.size()) {
                    return true;
                }
                c = s2.charAt(li++);
                if (freq.containsKey(c)) {
                    if (freq.get(c) == 0) {
                        --matched;
                    }
                    freq.put(c, freq.get(c) + 1);
                }
            }
        }
        return false;
    }

    /**
     * Approach 1: Sliding Window (fixed window)
     * Time Complexity: O(l1 + l2)
     * Space Complexity: O(l1)
     *
     * @param s1 String, the pattern string
     * @param s2 String, the target string to find pattern
     * @return boolean, true if s2 contains the permutation of s1
     */
    public boolean checkInclusionV2(String s1, String s2) {
        // 题意：
        // 已知两个字符串 s1 和 s2，判断 s1 的任意一个排列是否是 s2 的子串

        // 解法1：滑动窗口（固定大小）
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(1)

        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        // 步骤1：统计字符串 s1 包含的字符数量，以及各个字符的频次
        int unique = 0;
        int[] freq = new int[26];
        int idx;
        for (int i = 0; i < m; ++i) {
            idx = s1.charAt(i) - 'a';
            if (freq[idx]++ == 0) {
                ++unique;
            }
        }
        // 步骤2：用一个大小为 n（s1 的长度）的窗口向右滑动，每次滑动一步，
        // 如果窗口为 s1 的排列（或者异位词），则返回 true
        int matched = 0;
        for (int li = 0, ri = 0; ri < n; ++ri) {
            idx = s2.charAt(ri) - 'a';
            if (--freq[idx] == 0) {
                ++matched;
            }
            if (ri >= m-1) {
                if (matched == unique) {
                    return true;
                }
                idx = s2.charAt(li) - 'a';
                if (freq[idx]++ == 0) {
                    --matched;
                }
                ++li;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.checkInclusion("ab", "eidbaooo") == true);
        System.out.println(solu.checkInclusion("ab", "eidboaoo") == false);
    }
}