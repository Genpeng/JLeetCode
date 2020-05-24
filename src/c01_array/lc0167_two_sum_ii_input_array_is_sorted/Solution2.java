package c01_array.lc0167_two_sum_ii_input_array_is_sorted;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 167 problem in the LeetCode,
 * the website of the problem is as follow:
 *
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 * - Your returned answers (both index1 and index2) are not zero-based.
 * - ou may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * ==========================================================================================================
 *
 * Tags: array;hash table;two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Hash Table
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 18.07% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 42.6 MB, less than 5.22% of Java online submissions for Two Sum II - Input array is sorted.
     *
     * @param nums int[], an input array of integers
     * @param target int, a target number
     * @return int[], indices of the two numbers such that they add up to the target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num)+1, i+1};
            } else {
                map.put(target - num, i);
            }
        }
        throw new IllegalArgumentException("[ERROR] There are no two numbers such that their sum is equal to target!!!");
    }
}