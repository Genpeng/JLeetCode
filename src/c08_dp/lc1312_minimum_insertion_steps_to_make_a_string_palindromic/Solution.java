package c08_dp.lc1312_minimum_insertion_steps_to_make_a_string_palindromic;

/**
 * This is the solution of No. 1312 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 * Example 1:
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 *
 * Example 2:
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 *
 * Example 3:
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 *
 * Example 4:
 * Input: s = "g"
 * Output: 0
 *
 * Example 5:
 * Input: s = "no"
 * Output: 1
 *
 * Constraints:
 * - 1 <= s.length <= 500
 * - All characters of s are lower case English letters.
 * ==========================================================================================================
 *
 * Tags: dp;string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * Approach 1: find out the length of longest palindromic subsequence (LPS)
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * @param s String, the input string
     * @return int, the minimum number of steps to make s palindrome
     */
    public int minInsertions(String s) {
        return s.length() - lengthOfLPS(s);
    }

    private int lengthOfLPS(String s) {
        int L = s.length();
        if (L < 2) {
            return L;
        }
        char[] ca = s.toCharArray();
        int[] curr = new int[L];
        int[] prev = new int[L];
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
}