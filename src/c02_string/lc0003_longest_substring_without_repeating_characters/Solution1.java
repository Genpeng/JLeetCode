package c02_string.lc0003_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 003 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 方法 1：暴力法
     * 暴力枚举所有的子串，然后判断子串是否包含重复字符，对于不包含重复字符的子串，
     * 将它的长度与当前的最长长度进行比较，保存较大者
     *
     * 复杂度分析
     * 时间复杂度：O(L^3)
     * 空间复杂度：O(L)
     * 其中，L 表示字符串的长度
     *
     * @param s String, the input string
     * @return int, the length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        final int L = s.length();
        int maxLen = 0;
        for (int i = 0; i < L; ++i) {
            for (int j = i; j < L; ++j) {
                if (isAllUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    private boolean isAllUnique(String s, int si, int ei) {
        Set<Character> set = new HashSet<>();
        for (int i = si; i <= ei; ++i) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
