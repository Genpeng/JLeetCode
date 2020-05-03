package c08_dp.lc0516_longest_palindromic_subsequence;

/**
 * This is the solution of No. 516 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that
 * the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 * ==========================================================================================================
 *
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N ^ 2)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        int L = s.length();
        int[][] dp = new int[L][L];
        for (int i = 0; i < L; ++i) {
            dp[i][i] = 1;
        }
        for (int i = L - 2; i >= 0; --i) {
            for (int j = i + 1; j < L; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][L-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution3 solu = new Solution3();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}