package c08_dp.lc0300_longest_increasing_subsequence;

/**
 * This is the solution of No. 300 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 * - There may be more than one LIS combination, it is only necessary for you to return the length.
 * - Your algorithm should run in O(n^2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 * ==========================================================================================================
 *
 * Tags: dp;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Dynamic Programming
     * Suppose `dp[i]` is the length of LIS in `A[0 ... i]` with the `A[i]` as the last element,
     * the state transition equation can be written as follow:
     *        / 1, i = 0
     * dp[i] =
     *        \ max{ dp[j] + 1 | 0 <= j < i and A[i] > A[j] }, i > 0
     *
     * Complexity Analysis:
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 11 ms, faster than 58.99% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.7 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.lengthOfLIS(new int[] {}) == 0);
        System.out.println(solu.lengthOfLIS(new int[] {1}) == 1);
        System.out.println(solu.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}) == 4);
        System.out.println(solu.lengthOfLIS(new int[] {4, 2, 3, 6, 10, 1, 12}) == 5);
    }
}