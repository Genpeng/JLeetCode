package c01_array.lc0283_move_zeros;

import java.util.Arrays;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/move-zeroes/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * ==========================================================================================================
 *
 * Tags: slow & fast pointers;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/07
 */
public class Solution3 {
    /**
     * Approach 3: Slow & Fast Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Note:
     * - similar with the partition process of quick sort algorithm
     *
     * @param nums int[], the input integer array
     */
    public void moveZeroes(int[] nums) {
        for (int i = -1, j = 0; j < nums.length; ++j) {
            if (nums[j] != 0) {
                ++i;
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 2, 1};
        System.out.println(Arrays.toString(nums));
        Solution3 solution = new Solution3();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
