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
public class Solution4 {
    /**
     * Approach 4: Dynamic Programming with memory optimization
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * @param s String, the input string
     * @return int, the minimum cuts needed for a palindrome partitioning
     */
    public int minCut(String s) {
        int L = s.length();
        if (L == 0) {
            return 0;
        }
        char[] ca = s.toCharArray();
        int[] dp = new int[L];
        boolean[] ip = new boolean[L];
        for (int i = 0; i < L; ++i) {
            dp[i] = i;
            for (int j = 0; j <= i; ++j) {
                ip[j] = ca[j] == ca[i] && (i-j < 3 || ip[j-1]);
                if (ip[j]) {
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        return dp[L-1];
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution4 solu = new Solution4();
        System.out.println(solu.minCut(s));
    }
}