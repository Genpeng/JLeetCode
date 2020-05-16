package c08_dp.lc0300_longest_increasing_subsequence;

import java.util.ArrayList;

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
public class Solution1 {
    private int maxLen;

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(1)
     *
     * Time Limit Exceeded
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        maxLen = 0;
        helper(nums, 0, new ArrayList<>());
        return maxLen;
    }

    private void helper(int[] nums, int i, ArrayList<Integer> subseq) {
        if (i == nums.length) {
            if (isIncreasing(subseq)) {
                maxLen = Math.max(maxLen, subseq.size());
            }
            return;
        }
        subseq.add(nums[i]);
        helper(nums, i+1, subseq);
        subseq.remove(subseq.size() - 1);
        helper(nums, i+1, subseq);
    }

    private boolean isIncreasing(ArrayList<Integer> subseq) {
        for (int i = 1; i < subseq.size(); ++i) {
            if (subseq.get(i) < subseq.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.lengthOfLIS(new int[] {}) == 0);
        System.out.println(solu.lengthOfLIS(new int[] {1}) == 1);
        System.out.println(solu.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}) == 4);
        System.out.println(solu.lengthOfLIS(new int[] {4, 2, 3, 6, 10, 1, 12}) == 5);
    }
}