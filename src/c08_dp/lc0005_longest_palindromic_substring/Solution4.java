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
     * 一个字符串如果是回文的，它一定会关于中心对称，当字符串的数目是奇数的时候，中心即为中间点，
     * 而当字符串的数目为偶数时，中心位于中间两个字符串之间。这种解法的思路就是遍历所有可能的中心，
     * 找出该中心对应的最长回文子串，每次都更新最长的回文子串，遍历结束后就可以找出所有中心中
     * 最长的回文子串，也就是字符串最长的回文子串。
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