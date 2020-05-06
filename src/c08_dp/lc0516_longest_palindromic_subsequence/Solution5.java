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
public class Solution5 {
    /**
     * Approach 5: Dynamic Programming with memory optimization
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return int, the length of longest palindromic subsequence
     */
    public int longestPalindromeSubseq(String s) {
        char[] ca = s.toCharArray();
        int L = s.length();
        int[] prev = new int[L];
        int[] curr = new int[L];
        for (int i = L - 1; i >= 0; --i) {
            curr[i] = 1;
            for (int j = i + 1; j < L; ++j) {
                if (ca[i] == ca[j]) {
                    curr[j] = 2 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return prev[L-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution5 solu = new Solution5();
        System.out.println(solu.longestPalindromeSubseq(s));
    }
}