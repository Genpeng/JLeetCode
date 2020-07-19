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
public class Solution1 {
    /**
     * Approach 1: Dynamic Programming
     * Suppose `dp[i][j]` represents whether the substring `s[0 ... i-1]` and the pattern `p[0 ... j-1]`
     * is matching, so the state transition equation can be written as follow:
     *            / dp[i-1][j-1], i > 0, j > 0, s[i-1] = p[j-1] or p[j-1] = '?'
     *            / dp[i-1][j] | dp[i][j-1], i > 0, j > 0, p[j-1] = '*'
     * dp[i][j] = - true, i = 0, j = 0
     *            \ true, i = 0, j > 0, V 0 < k <= j, p[k-1] = '*'
     *            \ false, others
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
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i-1) != '*') {
                break;
            }
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.isMatch("", "") == true);
        System.out.println(solu.isMatch("aa", "a") == false);
        System.out.println(solu.isMatch("cb", "?a") == false);
        System.out.println(solu.isMatch("adceb", "*a*b") == true);
    }
}