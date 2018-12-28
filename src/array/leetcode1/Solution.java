package array.leetcode1;

import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

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
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/28
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException("[ERROR] The input array is illegal!");
        }

        Map<Integer, Integer> num2Index = new HashMap<>(16);
        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (num2Index.containsKey(complement)) {
                return new int[] {num2Index.get(complement), i};
            }
            num2Index.put(nums[i], i);
        }

        // 如果最后没有找到这两个数字，返回一个空数组
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        PrintUtil.printArray((new Solution()).twoSum(nums, target));
    }
}
