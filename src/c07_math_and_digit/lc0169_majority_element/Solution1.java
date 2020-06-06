package c07_math_and_digit.lc0169_majority_element;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 169 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/majority-element/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/14
 */
public class Solution1 {
    /**
     * Approach 1: Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums int[], the array contains majority element
     * @return int, the majority element
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > nums.length / 2) {
                return num;
            }
        }
        throw new IllegalArgumentException("[INFO] The input array is illegal!!!");
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 1, 1, 2};
        System.out.println((new Solution1()).majorityElement(nums));
    }
}
