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
public class Solution3 {
    /**
     * Approach 3: Dynamic programming with memory optimization (or Kadane's algorithm)
     * Suppose dp[i] represents the max sum of subarray A[0 ... i] which must contains A[i]
     * as the last element, the state transition equation can be written as follow:
     *         / A[0], i = 0
     * dp[i] =
     *         \ max(dp[i-1], 0) + A[i], i > 0
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 85.31% of Java online submissions for Maximum Subarray.
     * Memory Usage: 41.7 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

        // or write as follow:
//        int currSum = nums[0], maxSum = nums[0];
//        for (int i = 1; i < nums.length; ++i) {
//            currSum = Math.max(currSum, 0) + nums[i];
//            maxSum = Math.max(maxSum, currSum);
//        }
//        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[] {1};
        Solution3 solution = new Solution3();
        System.out.println(solution.maxSubArray(nums1));
        System.out.println(solution.maxSubArray(nums2));
    }
}