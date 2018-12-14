package linked_list.leetcode001;

import java.util.Arrays;

/**
 * This is the solution of No. 1 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/two-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/14
 */
public class Solution1 {
    /**
     * 方法1：暴力法
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums int[], the array of integers
     * @param target int, the specific integer
     * @return int[], the indices of the two numbers such that they add up to the specific target
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException("[ERROR] Illegal array!");
        }

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] ans = (new Solution1()).twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
