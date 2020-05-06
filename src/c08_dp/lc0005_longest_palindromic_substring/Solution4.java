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
public class Solution4 {
    /**
     * Approach 4: Expand Around the center
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(1)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        int L = s.length();
        if (L < 2) {
            return s;
        }
        int idx = 0, maxLen = 0;
        for (int i = 0; i < L; ++i) {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i+1);
            int l = Math.max(l1, l2);
            if (l > maxLen) {
                idx = l1 > l2 ? i - l1 / 2 : i - l2 / 2 + 1;
                maxLen = l;
            }
        }
        return s.substring(idx, idx + maxLen);
    }

    private int expand(String s, int si, int ei) {
        for (; si >= 0 && ei < s.length(); --si, ++ei) {
            if (s.charAt(si) != s.charAt(ei)) {
                break;
            }
        }
        return ei - si - 1;
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution4 solu = new Solution4();
        System.out.println(solu.longestPalindrome(s));
    }
}