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
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Dynamic Programming with memory optimization
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n))
     *
     * Result of Submission:
     * Runtime: 16 ms, faster than 20.14% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Longest Common Subsequence.
     *
     * @param s1 String, a string
     * @param s2 String, another string
     * @return int, the length of the longest common subsequence (LCS) of two input strings
     */
    public int longestCommonSubsequence(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 < l2) {
            return longestCommonSubsequence(s2, s1);
        }
        int[][] dp = new int[2][l2+1];
        for (int i = 1; i <= l1; ++i) {
            for (int j = 1; j <= l2; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i%2][j] = 1 + dp[(i-1) % 2][j-1];
                } else {
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[i%2][j-1]);
                }
            }
        }
        return dp[l1%2][l2];
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        Solution4 solu = new Solution4();
        System.out.println(solu.longestCommonSubsequence(s1, s2));
    }
}