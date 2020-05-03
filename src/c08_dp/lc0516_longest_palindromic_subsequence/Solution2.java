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
public class Solution2 {
    /**
     * Approach 2: Recursion with memoization
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N ^ 2)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        int L = s.length();
        int[][] memo = new int[L][L];
        return lps(s, 0, L-1, memo);
    }

    private int lps(String s, int si, int ei, int[][] memo) {
        if (si > ei) {
            return 0;
        }
        if (si == ei) {
            return 1;
        }
        if (memo[si][ei] == 0) {
            if (s.charAt(si) == s.charAt(ei)) {
                memo[si][ei] = 2 + lps(s, si+1, ei-1, memo);
            } else {
                memo[si][ei] = Math.max(lps(s, si+1, ei, memo), lps(s, si, ei-1, memo));
            }
        }
        return memo[si][ei];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution2 solu = new Solution2();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}