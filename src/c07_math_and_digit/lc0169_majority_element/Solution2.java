package c07_math_and_digit.lc0169_majority_element;

import java.util.Arrays;

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
public class Solution2 {
    /**
     * Approach 2: Sort
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(n) or O(1), depends on whether the input array can be modified
     *
     * @param nums int[], the array contains majority element
     * @return int, the majority element
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 1, 1, 2};
        System.out.println((new Solution2()).majorityElement(nums));
    }
}
