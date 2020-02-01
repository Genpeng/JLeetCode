package string.lc0409_longest_palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 409 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-palindrome/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 * that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法1
     * 解题思路：统计字符中出现次数为偶数的字符的长度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Palindrome.
     * Memory Usage: 37.4 MB, less than 6.67% of Java online submissions for Longest Palindrome.
     *
     * @param s, String, the input string
     * @return int, the length of the longest palindromes
     */
    public int longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        int[] counts = new int[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            ++counts[c];
            if ((counts[c] & 1) == 0) {
                len += 2;
            }
        }
        return len < s.length() ? len + 1 : len;
    }

    /**
     * 解法1
     * 解题思路：统计字符中出现次数为偶数的字符的长度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * Runtime: 6 ms, faster than 26.94% of Java online submissions for Longest Palindrome.
     * Memory Usage: 37.8 MB, less than 6.67% of Java online submissions for Longest Palindrome.
     *
     * @param s, String, the input string
     * @return int, the length of the longest palindromes
     */
    public int longestPalindromeV2(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        Map<Character, Integer> counts = new HashMap<>();
        int len = 0;
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            if ((counts.get(c) & 1) == 0) {
                len += 2;
            }
        }
        return len < s.length() ? len + 1 : len;
    }
}