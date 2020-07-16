package c08_dp.lc1143_longest_common_subsequence;

/**
 * This is the solution of No. 1143 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 * - 1 <= text1.length <= 1000
 * - 1 <= text2.length <= 1000
 * - The input strings consist of lowercase English characters only.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Recursion with memoization (Top-down)
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * Result of Submission:
     * Runtime: 26 ms, faster than 9.26% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 43.7 MB, less than 100.00% of Java online submissions for Longest Common Subsequence.
     *
     * @param s1 String, a string
     * @param s2 String, another string
     * @return int, the length of the longest common subsequence (LCS) of two input strings
     */
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                memo[i][j] = -1;
            }
        }
        return lcs(s1, m, s2, n, memo);
    }

    private int lcs(String s1, int i, String s2, int j, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            memo[i][j] = 1 + lcs(s1, i-1, s2, j-1, memo);
        } else {
            memo[i][j] = Math.max(lcs(s1, i-1, s2, j, memo), lcs(s1, i, s2, j-1, memo));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        Solution2 solu = new Solution2();
        System.out.println(solu.longestCommonSubsequence(s1, s2));
    }
}