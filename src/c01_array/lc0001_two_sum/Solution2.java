package c01_array.lc0001_two_sum;

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
public class Solution2 {
    /**
     * 解法2：Hash Table
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums int[], the input integer array
     * @param target int, the target integer
     * @return int[], indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }
            map.put(target - num, i);
        }
        throw new IllegalArgumentException("[ERROR] There are no two numbers such that their sum is equal to target!!!");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        PrintUtil.printArray((new Solution2()).twoSum(nums, target));
    }
}
