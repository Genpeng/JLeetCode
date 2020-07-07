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
 * Tags: array;dp;divide and conquer;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int maxSum = Integer.MIN_VALUE;

    /**
     * Approach 1: Recursive
     * Suppose `F(A, n)` represents the max sum of subarray A[:n] which must contains A[n]
     * as the last element, the state transition equation can be written as follow:
     *           / A[0], n = 0
     * F(A, n) =
     *           \ max(F(A, n-1), 0) + A[n], n > 0
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 85.31% of Java online submissions for Maximum Subarray.
     * Memory Usage: 43.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        helper(nums, nums.length - 1);
        return maxSum;
    }

    /**
     * The auxiliary function of the recursive approach.
     *
     * @param nums int[], the input integer
     * @param n    int, the index of last element
     * @return int, the largest sum of subarray `nums[:n]`, which must have `nums[n]` as the last element
     */
    public int helper(int[] nums, int n) {
        if (n == 0) {
            maxSum = nums[0];
            return nums[0];
        }
        int s = Math.max(helper(nums, n - 1), 0) + nums[n];
        maxSum = Math.max(maxSum, s);
        return s;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[] {1};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxSubArray(nums1));
        System.out.println(solution.maxSubArray(nums2));
    }
}