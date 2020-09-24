package c08_dp.lc0005_longest_palindromic_substring;

/**
 * This is the solution of No. 5 problem in the LeetCode,
 * the website of the problem is as follow:
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
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution6 {
    /**
     * Approach 6: Manacher's Algorithm
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
         if (s.length() <= 1) {
            return s;
        }
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String maxS1 = maxStr(s, i, i);
            String maxS2 = maxStr(s, i, i + 1);
            s1 = s1.length() >= maxS1.length() ? s1 : maxS1;
            s2 = s2.length() >= maxS2.length() ? s2 : maxS2;
        }
        return s1.length() >= s2.length() ? s1 : s2;
    }
    
    private static String maxStr(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
    
    public static void main(String[] args) {
        String s = "bbbab";
        Solution6 solu = new Solution6();
        System.out.println(solu.longestPalindrome(s));
    }
}
