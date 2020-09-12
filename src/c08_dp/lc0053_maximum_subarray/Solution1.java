package c08_dp.lc0053_maximum_subarray;

/**
 * This is the solution of No. 53 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-subarray/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * - If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: array;dp;divide and conquer;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Find out all the sub-arrays and save the maximum sum.
     *
     * Complexity Analysis:
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int currSum = 0;
            for (int j = i; j < n; ++j) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[] {1};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxSubArray(nums1));
        System.out.println(solution.maxSubArray(nums2));
    }
}