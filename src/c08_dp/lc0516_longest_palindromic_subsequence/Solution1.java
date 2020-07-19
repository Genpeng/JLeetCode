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
 * Difficulty: Medium
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int maxLen;

    /**
     * Approach 1: Brute Force
     * Enumerate all the subsequences, judge whether they are palindromic, and save the length of current
     * longest palindromic subsequence.
     *
     * Complexity Analysis:
     * Time Complexity: O(2 ^ N * N)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        maxLen = 0;
        helper(s, 0, new StringBuilder());
        return maxLen;
    }

    private void helper(String s, int idx, StringBuilder currStr) {
        if (idx == s.length()) {
            if (isPalindromic(currStr)) {
                maxLen = Math.max(maxLen, currStr.length());
            }
            return;
        }
        currStr.append(s.charAt(idx));
        helper(s, idx+1, currStr);
        currStr.deleteCharAt(currStr.length() - 1);
        helper(s, idx+1, currStr);
    }

    private boolean isPalindromic(StringBuilder sb) {
        for (int i = 0, j = sb.length() - 1; i < j; ++i, --j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution1 solu = new Solution1();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}