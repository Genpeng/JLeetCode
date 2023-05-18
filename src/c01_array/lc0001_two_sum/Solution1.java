package c01_array.lc0001_two_sum;

import util.PrintUtil;

/**
 * This is the solution of No. 1 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/two-sum/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: array;hash table;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * <p>
     * Complexity Analysis:
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(1)
     *
     * @param nums   int[], the input integer array
     * @param target int, the target integer
     * @return int[], indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] == target - nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("[ERROR] There are no two numbers such that their sum is equal to target!!!");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        PrintUtil.printArray((new Solution1()).twoSum(nums, target));
    }
}
