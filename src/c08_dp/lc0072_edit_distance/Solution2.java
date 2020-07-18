package c08_dp.lc0072_edit_distance;

/**
 * This is the solution of No. 72 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/edit-distance/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: dp;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Dynamic Programming (Bottom up)
     * Suppose `dp[i][j]` represents the edit distance between `word1[0 ... i-1]` and `word2[0 ... j-1]`,
     * so the state transition equation can be written as follow:
     *            / dp[i-1][j-1], i * j > 0, word1[i-1] = words[j-1]
     * dp[i][j] = - min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1, i * j > 0, word1[i-1] != word2[j-1]
     *            \ i + j, i * j = 0
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Time Complexity: O(m * n)
     *
     * Result of Submission:
     * Runtime: 4 ms, faster than 94.73% of Java online submissions for Edit Distance.
     * Memory Usage: 39.5 MB, less than 5.88% of Java online submissions for Edit Distance.
     *
     * @param s1 String, one word
     * @param s2 String, the other word
     * @return int, the edit distance between two strings
     */
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.minDistance("horse", "ros") == 3);
    }
}