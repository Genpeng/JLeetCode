package c08_dp.lc0300_longest_increasing_subsequence;

import java.util.Arrays;

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
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming
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
        final int L = nums.length;
        if (L == 0) {
            return 0;
        }
        int[] dp = new int[L];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < L; ++i) {
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

    // =================================================================================================== //
    // 以下是如何写出最终的动态规划写法的过程，即从暴力递归到带备忘录的递归。

    private int maxLength;

    /**
     * Recursion
     * Time Complexity: O(n ^ n)
     * Space Complexity: O(n)
     *
     * The state transition equation is as follow:
     *          / 1, i = 0
     * LIS(i) =
     *          \ max{LIS(j) | nums[i] > nums[j], j = 0, 1, ..., i-1} + 1, i > 0
     *
     * Time Limit Exceeded
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLISV1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        maxLength = 1;
        for (int i = 0; i < nums.length; ++i) {
            maxLength = Math.max(maxLength, lengthOfLISV1(nums, i));
        }
        return maxLength;
    }

    private int lengthOfLISV1(int[] nums, int ei) {
        if (ei == 0) {
            return 1;
        }
        int maxSub = 0;
        for (int i = ei - 1; i >= 0; --i) {
            if (nums[ei] > nums[i]) {
                int sub = lengthOfLISV1(nums, i);
                maxSub = Math.max(maxSub, sub);
            }
        }
        return maxSub + 1;
    }

    /**
     * Recursion with memorization
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     *
     * The state transition equation is as follow:
     *          / 1, i = 0
     * LIS(i) =
     *          \ max{LIS(j) | nums[i] > nums[j], j = 0, 1, ..., i-1} + 1, i > 0
     *
     * Runtime: 21 ms, faster than 13.81% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.7 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLISV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        maxLength = 1;
        int[] memo = new int[n];
        for (int i = 0; i < n; ++i) {
            maxLength = Math.max(maxLength, lengthOfLISV2(nums, i, memo));
        }
        return maxLength;
    }

    private int lengthOfLISV2(int[] nums, int idx, int[] memo) {
        if (idx == 0) {
            memo[idx] = 1;
            return memo[idx];
        }
        if (memo[idx] != 0) {
            return memo[idx];
        }
        int maxSub = 0;
        for (int i = idx - 1; i >= 0; --i) {
            if (nums[idx] > nums[i]) {
                int sub = lengthOfLISV2(nums, i, memo);
                maxSub = Math.max(maxSub, sub);
            }
        }
        memo[idx] = maxSub + 1;
        return memo[idx];
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution3 solution = new Solution3();
        long t0 = System.currentTimeMillis();
        System.out.println(solution.lengthOfLISV1(nums2));
        long t1 = System.currentTimeMillis();
        System.out.format("[INFO] Done in %.6f seconds.", (float) (t1 - t0) / 1000);
    }
}