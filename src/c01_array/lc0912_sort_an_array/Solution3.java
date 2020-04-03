package c01_array.lc0912_sort_an_array;

import java.util.Arrays;

/**
 * This is the solution of No. 912 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 * Constraints:
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Heap Sort
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(log(n))
     *
     * @param nums int[], an array
     * @return int[], the sorted array
     */
    public int[] sortArray(int[] nums) {
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution3 solution = new Solution3();
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
}