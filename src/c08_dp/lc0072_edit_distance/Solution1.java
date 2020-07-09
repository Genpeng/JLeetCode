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
 * Tags: dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Recursion
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Time Complexity: O(m * n)
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 99.83% of Java online submissions for Edit Distance.
     * Memory Usage: 40 MB, less than 5.88% of Java online submissions for Edit Distance.
     *
     * @param word1 String, one word
     * @param word2 String, the other word
     * @return int, the edit distance between two strings
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m+1][n+1];
        return minDistance(word1, word2, memo, m, n);
    }

    /**
     * Calculate the edit distance between the prefixes word1[1 ... i] and word2[1 ... j].
     *
     * The state transition equation is as follow:
     *              / i + j, if i = 0 or j = 0 (i * j == 0)
     * Edit(i, j) = - Edit(i-1, j-1), if i > 0 and j > 0 and word1[i] == word2[j]
     *              \ min(Edit(i-1, j), Edit(i, j-1), Edit(i-1, j-1)) + 1, if i > 0 and j > 0 and word1[i] != word2[j]
     * where Edit(i, j) denote the edit distance between the prefixes word1[1 ... i] and word2[1 ... j].
     *
     * @param word1 String, one word
     * @param word2 String, the other word
     * @param memo int[][], the auxiliary array to memorize intermediate values
     * @param i int, the upper bound in word1
     * @param j int, the upper bound in word2
     * @return int, the edit distance between the prefixes word1[1 ... i] and word2[1 ... j]
     */
    private int minDistance(String word1, String word2, int[][] memo, int i, int j) {
        if (i * j == 0) {
            return i + j;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
            memo[i][j] = minDistance(word1, word2, memo, i-1, j-1);
        } else {
            memo[i][j] = min(minDistance(word1, word2, memo, i-1, j),
                             minDistance(word1, word2, memo, i, j-1),
                             minDistance(word1, word2, memo, i-1, j-1)) + 1;
        }
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        Solution1 solution = new Solution1();
        System.out.println(solution.minDistance(word1, word2));
    }
}