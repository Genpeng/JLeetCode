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
public class Solution1 {
    /**
     * Approach 1: Recursion
     * Suppose dp[i][j] represents the length of longest common subsequence between s1[0 ... i-1]
     * and s2[0 ... j-1], so the state transition equation can be written as follow:
     *            / 0, i * j = 0 (i = 0 or j = 0)
     * dp[i][j] = - dp[i-1][j-1], i * j > 0 and s1[i-1] = s2[j-1]
     *            \ max{dp[i-1][j], dp[i][j-1]}, i * j > 0 and s1[i-1] != s2[j-1]
     *
     * Complexity Analysis:
     * Time Complexity: O(2 ^ (m+n))
     * Space Complexity: O(m + n)
     *
     * @param s1 String, a string
     * @param s2 String, another string
     * @return int, the length of the longest common subsequence (LCS) of two input strings
     */
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1, s1.length(), s2, s2.length());
    }

    /**
     * The auxiliary function to calculate dp[i][j].
     *
     * @param s1 String, a string
     * @param i int, the rightmost index in s1
     * @param s2 String, another string
     * @param j int, the rightmost index in s2
     * @return int, the length of longest common subsequence (LCS) between s1[0 ... i-1] and s2[0 ... j-1]
     */
    private int lcs(String s1, int i, String s2, int j) {
        if (i * j == 0) {
            return 0;
        }
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            return 1 + lcs(s1, i-1, s2, j-1);
        } else {
            return Math.max(lcs(s1, i-1, s2, j), lcs(s1, i, s2, j-1));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        Solution1 solu = new Solution1();
        System.out.println(solu.longestCommonSubsequence(s1, s2));
    }
}