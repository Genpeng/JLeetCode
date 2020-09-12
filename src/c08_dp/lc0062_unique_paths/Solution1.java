package c08_dp.lc0062_unique_paths;

/**
 * This is the solution of No. 62 problem in the LeetCode,
 * the website of the problem is as follow:
 * xxx
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Constraints:
 * - 1 <= m, n <= 100
 * - It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Dynamic Programming
     * Suppose dp[i][j] represents the number of unique paths starting from (0, 0) to (i, j),
     * the state transition equation can be written as follow:
     *            / dp[i-1][j] + dp[i][j-1], i * j > 0
     * dp[i][j] =
     *            \ 1, i * j = 0
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param m int, the number of columns
     * @param n int, the number of rows
     * @return int, the number of unique paths
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.uniquePaths(3, 2) == 3);
        System.out.println(solu.uniquePaths(7, 3) == 28);
    }
}