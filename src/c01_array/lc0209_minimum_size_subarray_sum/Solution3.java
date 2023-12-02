package c01_array.lc0209_minimum_size_subarray_sum;

/**
 * This is the solution of No. 209 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * - If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;two pointers;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Sliding Window (Two Pointers)
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param target int, target sum
     * @param nums int[], an array of integers
     * @return int, the minimal length of a contiguous subarray of which the sum ≥ s
     */
    public int minSubArrayLen(int target, int[] nums) {
        final int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int s = 0;
        for (int li = 0, ri = 0; ri < n; ++ri) {
            s += nums[ri];
            while (s >= target) {
                minLen = Math.min(minLen, ri-li+1);
                s -= nums[li++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}