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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/10
 */
public class Solution2 {
    /**
     * 方法2：滑动窗口
     * 用一个长度可变的“窗口”在字符串上滑动。最初，窗口的左右边界索引都位于
     * 字符串的起始字符。之后，右边界向右滑动一个字符，如果窗口内的子串不包含
     * 重复字符时，右边界继续向右滑动一个字符；如果窗口内的子串包含重复字符，
     * 则左边界向右滑动一个字符。如此循环往复，直到右边界到达字符串的末尾字符。
     * 每次滑动之后，都会保存当前子串的最大长度。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(min(n, m))，其中，n表示字符串的长度，m是不重复字符的数目
     *
     * @param s String, 输入的字符串
     * @return int, 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        Set<Character> window = new HashSet<>();
        while (right < s.length()) {
            if (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            } else {
                window.add(s.charAt(right++));
                maxLen = Math.max(right - left, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println((new Solution2()).lengthOfLongestSubstring(s));
    }
}
