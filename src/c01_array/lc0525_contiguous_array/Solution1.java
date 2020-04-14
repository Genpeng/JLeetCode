package c01_array.lc0525_contiguous_array;

/**
 * This is the solution of No. 525 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/contiguous-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Time Limit Exceeded
     *
     * @param nums int[], the input binary array
     * @return int, the maximum length of a contiguous subarray with equal number of 0 and 1
     */
    public int findMaxLength(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array is null!!!");
        }
        int n = nums.length;
        int maxLen = 0;
        int zeros, ones;
        for (int i = 0; i < n; ++i) {
            zeros = 0;
            ones = 0;
            for (int j = i; j < n; ++j) {
                if (nums[j] == 0) {
                    ++zeros;
                } else {
                    ++ones;
                }
                if (zeros == ones) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0};
        Solution1 solution = new Solution1();
        System.out.println(solution.findMaxLength(nums));
    }
}