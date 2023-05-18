package c08_dp.lc0005_longest_palindromic_substring;

/**
 * This is the solution of No. 5 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming with memory optimization
     * The state transition equation is as follow:
     *            / true, s[i] == s[j] and (j - i < 3 or dp[i+1][j-1] = true)
     * dp[i][j] =
     *            \ false, others
     * where dp[i][j] represents whether s[i ... j] is palindromic substring
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        final int L = s.length();
        char[] ca = s.toCharArray();
        boolean[] dp = new boolean[L];
        int startIndex = 0, maxLen = 0;
        for (int i = L-1; i >= 0; --i) {
            for (int j = L-1; j >= i; --j) {
                dp[j] = ca[i] == ca[j] && (j - i < 3 || dp[j-1]);
                if (dp[j] && j-i+1 > maxLen) {
                    startIndex = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(startIndex, startIndex+maxLen);
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution3 solu = new Solution3();
        System.out.println(solu.longestPalindrome(s));
    }
}