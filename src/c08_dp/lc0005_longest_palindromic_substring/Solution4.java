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
 * Difficulty: Medium
 * Tags: string;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Expand Around the center
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(1)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        int startIndex = 0, maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i+1);
            int l = Math.max(l1, l2);
            if (l > maxLen) {
                startIndex = l == l1 ? i - l1/2 : i - l2/2 + 1;
                maxLen = l;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    private int expand(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); --i, ++j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution4 solu = new Solution4();
        System.out.println(solu.longestPalindrome(s));
    }
}