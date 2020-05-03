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
public class Solution1 {
    /**
     * Approach 1: Brute Force (Recursion)
     * The state transition equation is as follow:
     *              / 0, i > j
     *              / 1, i = j
     * LPS(i, j) =  - LPS(i+1, j-1), i < j and s[i] = s[j]
     *              \ max(LPS(i+1, j), LPS(i, j-1)), i < j and s[i] != s[j]
     * where the LPS(i, j) represents the length of longest palindromic subsequence in the string s[i ... j]
     *
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        return lps(s, 0, s.length() - 1);
    }

    /**
     * An auxiliary function to calculate LPS(i, j)
     *
     * @param s String, an input string
     * @param si int, the start index
     * @param ei int, the end index
     * @return int, the length of longest palindromic subsequence in the string s[i ... j]
     */
    private int lps(String s, int si, int ei) {
        if (si > ei) {
            return 0;
        }
        if (si == ei) {
            return 1;
        }
        if (s.charAt(si) == s.charAt(ei)) {
            return 2 + lps(s, si+1, ei-1);
        } else {
            return Math.max(lps(s, si+1, ei), lps(s, si, ei-1));
        }
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution1 solu = new Solution1();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}