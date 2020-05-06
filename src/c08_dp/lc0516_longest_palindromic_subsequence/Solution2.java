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
     * Approach 2: Recursion
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
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        return lps(s, 0, s.length() - 1);
    }

    /**
     * An auxiliary function to calculate LPS(i, j)
     *
     * @param s String, an input string
     * @param i int, the start index
     * @param j int, the end index
     * @return int, the length of longest palindromic subsequence in the string s[i ... j]
     */
    private int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + lps(s, i+1, j-1);
        } else {
            return Math.max(lps(s, i+1, j), lps(s, i, j-1));
        }
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution2 solu = new Solution2();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}