package c02_string.lc0003_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 3 problem in the LeetCode,
 * the website of the problem is as follows:
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
public class Solution2 {
    /**
     * 方法2：滑动窗口
     * 用一个长度可变的「窗口」在字符串上滑动。最初，窗口的左右边界索引都位于
     * 字符串的起始字符。之后，右边界向右滑动一个字符，如果窗口内的子串不包含
     * 重复字符时，右边界继续向右滑动一个字符；如果窗口内的子串包含重复字符，
     * 则左边界向右滑动一个字符。如此循环往复，直到右边界到达字符串的末尾字符。
     * 每次滑动之后，都会保存当前子串的最大长度。
     *
     * 复杂度分析：
     * - 时间复杂度：O(L)
     * - 空间复杂度：O(L)
     * 其中，L 表示字符串的长度
     *
     * @param s String, the input string
     * @return int, the length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("the input string is null");
        }
        final int L = s.length();
        if (L <= 1) {
            return L;
        }
        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            char c = s.charAt(ri);
            while (window.contains(c)) {
                window.remove(s.charAt(li));
                ++li;
            }
            window.add(c);
            maxLen = Math.max(maxLen, ri - li + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
