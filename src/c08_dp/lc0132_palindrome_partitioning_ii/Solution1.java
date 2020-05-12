package c08_dp.lc0132_palindrome_partitioning_ii;

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
public class Solution1 {
    /**
     * Approach 1: Recursion
     * Time Complexity: O(2 ^ N) ??? Why?
     * Space Complexity: O(N)
     *
     * The state transition equation is as follow:
     *         / 0, i <= 0
     * MC(i) = - 0, i > 0 and IP(0, i) = true
     *         \ min{ MC(j-1) + 1 | j = [1, ..., i], IP(j, i) = true }, i > 0 and IP(0, i) = false
     * where MC(i) represents the minimum cuts to make each pieces in s[0 ... s] is a palindrome,
     * IP(i, j) represents whether the substring s[i ... j] is a palindrome.
     *
     * @param s String, the input string
     * @return int, the minimum cuts needed for a palindrome partitioning
     */
    public int minCut(String s) {
        return minCut(s, s.length() - 1);
    }

    private int minCut(String s, int i) {
        if (i <= 0 || isPalindromic(s, 0, i)) {
            return 0;
        }
        int minNum = i;
        for (int j = 1; j <= i; ++j) {
            if (isPalindromic(s, j, i)) {
                minNum = Math.min(minNum, minCut(s, j-1) + 1);
            }
        }
        return minNum;
    }

    public boolean isPalindromic(String s, int i, int j) {
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution1 solu = new Solution1();
        System.out.println(solu.minCut(s));
    }
}