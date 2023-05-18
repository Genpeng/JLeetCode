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
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Iterate all the substrings, if a substring is palindromic, then update the start index and its length,
     * finally output the result substring.
     * 遍历所有的子串，判断每个子串是否为回文的，如果是回文的就更新起始的位置以及它的长度。
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 3)
     * Space Complexity: O(1)
     *
     * @param s String, an input string
     * @return String, the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        final int L = s.length();
        if (L == 0 || L == 1) {
            return s;
        }
        int startIndex = 0, maxLen = 1;
        for (int i = 0; i < L; ++i) {
            for (int j = i; j < L; ++j) {
                if (isPalindromic(s, i, j) && j-i+1 > maxLen) {
                    startIndex = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(startIndex, startIndex+maxLen);
    }

    private boolean isPalindromic(String s, int i, int j) {
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        Solution1 solu = new Solution1();
        System.out.println(solu.longestPalindrome(s));
    }
}