package dp.lc0300_longest_increasing_subsequence;

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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(2 ^ n)
     * Space Complexity: O(n ^ 2) ???
     *
     * Time Limit Exceeded
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    /**
     * Compute the length of longest increasing subsequence with index starts from `si`.
     *
     * @param nums int[], the input integer array
     * @param prev int, the previous element
     * @param si int, the index of start element
     * @return int, the length of longest increasing subsequence
     */
    private int lengthOfLIS(int[] nums, int prev, int si) {
        if (si == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[si] > prev) {
            taken = 1 + lengthOfLIS(nums, nums[si], si + 1);
        }
        int untaken = lengthOfLIS(nums, prev, si + 1);
        return Math.max(taken, untaken);
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution1 solution = new Solution1();
        System.out.println(solution.lengthOfLIS(nums2));
    }
}