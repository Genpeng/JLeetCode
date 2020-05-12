package c08_dp.lc0132_palindrome_partitioning_ii;

import java.util.Arrays;

/**
 * This is the solution of No. 132 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * ==========================================================================================================
 *
 * Tags: dp;string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Recursion with memoization
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N ^ 2)
     *
     * @param s String, the input string
     * @return int, the minimum cuts needed for a palindrome partitioning
     */
    public int minCut(String s) {
        int L = s.length();
        Integer[] dp = new Integer[L];
        Boolean[][] isPalind = new Boolean[L][L];
        return minCut(s, L - 1, dp, isPalind);
    }

    private int minCut(String s, int i, Integer[] dp, Boolean[][] isPalind) {
        if (i <= 0 || isPalindromic(s, 0, i, isPalind)) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int minNum = i;
        for (int j = 1; j <= i; ++j) {
            if (isPalindromic(s, j, i, isPalind)) {
                minNum = Math.min(minNum, minCut(s, j-1, dp, isPalind) + 1);
            }
        }
        dp[i] = minNum;
        return minNum;
    }

    public boolean isPalindromic(String s, int i, int j, Boolean[][] isPalind) {
        if (i > j) {
            return false;
        }
        if (isPalind[i][j] != null) {
            return isPalind[i][j];
        }
        if (s.charAt(i) == s.charAt(j) && (j-i < 3 || isPalindromic(s, i+1, j-1, isPalind))) {
            isPalind[i][j] = true;
        } else {
            isPalind[i][j] = false;
        }
        return isPalind[i][j];
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution2 solu = new Solution2();
        System.out.println(solu.minCut(s));
    }
}