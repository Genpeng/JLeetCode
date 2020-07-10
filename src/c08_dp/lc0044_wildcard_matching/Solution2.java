package c08_dp.lc0044_wildcard_matching;

/**
 * This is the solution of No. 44 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/wildcard-matching/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * - s could be empty and contains only lowercase letters a-z.
 * - p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: string;dp;greedy;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Greedy
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param s String, the input string
     * @param p String, the input pattern
     * @return boolean, true if and only the string is matching to the pattern
     */
    public boolean isMatch(String s, String p) {
        // TODO: add it
        return true;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.isMatch("", "") == true);
        System.out.println(solu.isMatch("aa", "a") == false);
        System.out.println(solu.isMatch("cb", "?a") == false);
        System.out.println(solu.isMatch("adceb", "*a*b") == true);
    }
}