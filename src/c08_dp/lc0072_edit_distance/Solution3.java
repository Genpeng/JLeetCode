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
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming with memory optimization
     * Suppose `dp[i][j]` represents the edit distance between `word1[0 ... i-1]` and `word2[0 ... j-1]`,
     * so the state transition equation can be written as follow:
     *            / dp[i-1][j-1], i > 0, j > 0, word1[i-1] = words[j-1]
     * dp[i][j] = - min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1, i > 0, j > 0, word1[i-1] != word2[j-1]
     *            \ i + j, i * j = 0
     *
     * Complexity Analysis:
     * Time Complexity: O(m * n)
     * Time Complexity: O(min{m, n})
     *
     * Result of Submission:
     * 执行用时：5 ms, 在所有 Java 提交中击败了 98.21% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了 60.37% 的用户
     *
     * @param word1 String, one word
     * @param word2 String, the other word
     * @return int, the edit distance between two strings
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        if (m < n) {
            return minDistance(word2, word1);
        }
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for (int j = 1; j <= n; ++j) {
            prev[j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            curr[0] = i;
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                } else {
                    curr[j] = min(curr[j-1], prev[j-1], prev[j]) + 1;
                }
            }
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
            // TODO: 为什么用 swap 函数结果不一样？
//            swap(prev, curr);
        }
        return prev[n];
    }

    private void swap(int[] a, int[] b) {
        int[] tmp = a;
        a = b;
        b = tmp;
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.minDistance("horse", "ros") == 3);
        System.out.println(solu.minDistance("intention", "execution") == 5);
    }
}