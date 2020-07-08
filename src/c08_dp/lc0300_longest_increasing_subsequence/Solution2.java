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
public class Solution2 {
    /**
     * Approach 2: Recursion (with pruning)
     *
     * Complexity Analysis:
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Time Limit Exceeded
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, -1, 0);
    }

    private int lengthOfLIS(int[] nums, int prevIndex, int currIndex) {
        if (currIndex == nums.length) {
            return 0;
        }
        int take = 0;
        if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            take = 1 + lengthOfLIS(nums, currIndex, currIndex+1);
        }
        int untake = lengthOfLIS(nums, prevIndex, currIndex+1);
        return Math.max(take, untake);
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.lengthOfLIS(new int[] {}) == 0);
        System.out.println(solu.lengthOfLIS(new int[] {1}) == 1);
        System.out.println(solu.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}) == 4);
        System.out.println(solu.lengthOfLIS(new int[] {4, 2, 3, 6, 10, 1, 12}) == 5);
    }
}